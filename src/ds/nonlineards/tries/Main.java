package ds.nonlineards.tries;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertTrie("category");
        trie.insertTrie("cat");
        trie.insertTrie("catering");
        System.out.println();
        System.out.println();
        trie.removeWord("cat");

        System.out.println(trie.search("category"));
        System.out.println(trie.search("cat"));
        System.out.println(trie.search("catering"));

    }
}
