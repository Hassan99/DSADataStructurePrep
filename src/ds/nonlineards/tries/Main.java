package ds.nonlineards.tries;

public class Main {
    public static void main(String[] args) {
        Trie trie= new Trie();
        trie.insertTrie("category");
        System.out.println(trie.search("category"));
        trie.traversePost();
        System.out.println("Completed");
    }
}
