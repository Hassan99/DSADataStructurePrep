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
            return  node.values().toArray(new Node[0]);
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
        Node[] allChild =  node.getAllChildren();
        for (Node child : allChild) {
            preOrderTraversal(child);
        }
    }
    private void postOrderTraversal(Node node) {
        Node[] allChild =  node.getAllChildren();
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
}
