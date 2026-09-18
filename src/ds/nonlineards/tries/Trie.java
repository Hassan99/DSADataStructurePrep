package ds.nonlineards.tries;

public class Trie {
    class Node{
        private char value;
        private Node[] node = new Node[26];
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

        public Node[] getNode() {
            return node;
        }

        public void setNode(Node[] node) {
            this.node = node;
        }

        public boolean isEndOfNode() {
            return isEndOfNode;
        }

        public void setEndOfNode(boolean endOfNode) {
            isEndOfNode = endOfNode;
        }
    }
    private Node rootNode = new Node(' ');

    public void insertTrie(String word){
        Node current = rootNode;
        for(char ch:word.toCharArray()){
            int index = ch-'a';
            if(current.node[index]==null){
                current.node[index] = new Node(ch);
            }
            current = current.node[index];
        }
        current.isEndOfNode =true;

    }
}
