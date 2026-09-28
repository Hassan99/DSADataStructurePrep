package ds.nonlineards.tries;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertTrie("category");
        trie.insertTrie("cat");
        trie.insertTrie("catering");
        trie.insertTrie("car");
        trie.insertTrie("cab");
        trie.insertTrie("egg");

        System.out.println(trie.autoCompleteList(null));


    }
}
