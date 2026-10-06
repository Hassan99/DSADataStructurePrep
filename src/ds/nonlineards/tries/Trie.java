package ds.nonlineards.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        public boolean hasChildren() {
            return !node.isEmpty();
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

    public boolean searchRecursive(String word) {
        return searchRecursive(rootNode, word,0);
    }


    private boolean searchRecursive(Node node, String word,int index) {
        if (word == null ) {
            return false;
        }
        if (node == null) {
            return false;
        }
        char ch = ' ';
        if(index>=0) {
            ch = word.charAt(index);
        }
        if(node.hasChild(ch) ) {
            Node current = node.getChild(ch);
            if (current.isEndOfNode && word.length() == (index+1)) {
                return true;
            }
            index = index + 1;
            return searchRecursive(current, word, index);
        }
        return false;
    }

    public boolean removeWord(String word) {
        if (word == null || word.isEmpty())
            return false;
        return removeWord(rootNode, word, 0);
    }

    private boolean removeWord(Node node, String word, int index) {
        if (index == word.length()) {
            if (node.isEndOfNode) {
                node.isEndOfNode = false;
                return false;
            }
            System.out.println("This word is not exist..");
            return !node.hasChildren();
        }

        char ch = word.charAt(index);
        Node child = node.getChild(ch);
        if (child == null) {
            return false;
        }
        boolean shouldDeleteChild = removeWord(child, word, index + 1);

        if (shouldDeleteChild) {
            node.remove(ch);
            return !node.hasChildren() && !node.isEndOfNode();
        }
        return false;
    }

    public List<String> autoCompleteList(String prefix) {

        if (prefix == null) {
            return null;
        }
        List<String> listOfWords = new ArrayList<>();
        Node lastNodeOf = findLastNodeOf(prefix);

        if (lastNodeOf == null) {

        } else {
            findWords(lastNodeOf, prefix, listOfWords);
        }
        return listOfWords;
    }

    private void findWords(Node node, String prefix, List<String> listOfWords) {
        if (node.isEndOfNode) {
            listOfWords.add(prefix);
        }
        for (Node ch : node.getAllChildren()) {
            findWords(ch, prefix + ch.getValue(), listOfWords);
        }
    }

    private Node findLastNodeOf(String prefix) {
        Node current = rootNode;
        for (char ch : prefix.toCharArray()) {
            Node child = current.getChild(ch);
            if (child == null) {
                return null;
            }
            current = child;
        }
        return current;
    }


    public int countWordsInTrie() {
        int count = 0;
        return countWordsInTrie(rootNode, count);
    }

    private int countWordsInTrie(Node node, int count) {
        if (node.hasChildren()) {
            for (Node current : node.getAllChildren()) {
                if (current.isEndOfNode) {
                    count = count + 1;
                }
                count = countWordsInTrie(current, count);
            }
        }
        return count;
    }
    public String getLongestCommonPrefix(){
        return longestCommonPrefix(rootNode);
    }

    private String longestCommonPrefix(Node node){

        if(node.isEndOfNode){
            return null;
        }
        if(node.getAllChildren().length==1){

            return prepareString(node,"");
        }
        return null;
    }

    private String prepareString(Node node,String value){
        if(node != null && node.hasChildren()) {
            for (Node current : node.getAllChildren()) {
                if (!current.isEndOfNode && current.getAllChildren().length == 1) {
                    value = value + current.getValue();
                    return prepareString(current, value);
                } else if (!current.isEndOfNode && current.getAllChildren().length > 1) {
                    value = value + current.getValue();
                    return value;
                } else if (node.isEndOfNode) {
                    value = value + current.getValue();
                    return value;
                }
            }
        }
        return value;
    }

}
