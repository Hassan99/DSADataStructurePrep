package ds.nonlineards.tries;

import java.util.HashMap;

public class Trie {


    class Node {
        private char value;
        private HashMap<Character, Node> node = new HashMap<>();
        private boolean isEndOfNode = false;

        public Node(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }


        public boolean isEndOfNode() {
            return isEndOfNode;
        }

        public void setEndOfNode(boolean endOfNode) {
            isEndOfNode = endOfNode;
        }

        public boolean hasChild(char ch) {
            return node.containsKey(ch);
        }

        public void addChild(char ch, Node node) {
            this.node.put(ch, node);
        }

        public Node getChild(char ch) {
            return this.node.get(ch);
        }

        public Node[] getAllChildren() {
            return node.values().toArray(new Node[0]);
        }

        public void remove(char ch) {
            node.remove(ch);
        }
    }

    private Node rootNode = new Node(' ');

    public void traversePre() {
        preOrderTraversal(rootNode);
    }

    public void traversePost() {
        postOrderTraversal(rootNode);
    }

    private void preOrderTraversal(Node node) {
        System.out.println(node.value);
        Node[] allChild = node.getAllChildren();
        for (Node child : allChild) {
            preOrderTraversal(child);
        }
    }

    private void postOrderTraversal(Node node) {
        Node[] allChild = node.getAllChildren();
        for (Node child : allChild) {
            postOrderTraversal(child);
        }
        System.out.println(node.value);


    }


    public void insertTrie(String word) {
        Node current = rootNode;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch, new Node(ch));
            }
            current = current.getChild(ch);
        }
        current.isEndOfNode = true;
    }

    public boolean search(String word) {
        Node current = rootNode;
        for (char ch : word.toCharArray()) {
            if (current.hasChild(ch)) {
                current = current.getChild(ch);
            }

        }
        return current.isEndOfNode();
    }

    public void removeWord(String word) {
        removeWord(rootNode, word, 0);
    }

    private void removeWord(Node node, String word, int index) {
        if(index == word.length()){
            node.isEndOfNode = false;
            return;
        }

        char ch = word.charAt(index);
        Node child = node.getChild(ch);
        if(child==null){
            return;
        }
        removeWord(child, word, index + 1);
        if(child.getAllChildren().length==0 && !child.isEndOfNode){
            child.remove(ch);
        }
    }



   /* private void removeWord(Node node, String word) {
        Node current = node;
        for (char ch : word.toCharArray()) {
            if (current.hasChild(ch)) {
                current = current.getChild(ch);
            }else{
                System.out.println("Word not exist..");
                return;
            }
        }
        if (current.isEndOfNode()) {
            current.setEndOfNode(false);
            if(current.getAllChildren().length==0){

            }
        }else{
            System.out.println("This word not found..");
        }


    }
*/
}
