package ds.nonlineards.tries;

public class Main {
    public static void main(String[] args) {
        Trie trie= new Trie();
        trie.insertTrie("category");
        trie.insertTrie("can");
        System.out.println(trie.search("category"));
        System.out.println("Completed");
    }
}
