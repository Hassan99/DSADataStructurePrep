package ds.nonlineards.tries;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertTrie("careder");
        trie.insertTrie("caredful");
        /*
        trie.insertTrie("car");
        trie.insertTrie("cab");
        trie.insertTrie("egg");
        trie.insertTrie("eager");
        trie.insertTrie("elephant");
        trie.insertTrie("casual");
        trie.insertTrie("carpentor");*/

//        System.out.println(trie.searchRecursive("category"));
//        System.out.println(trie.countWordsInTrie());
        System.out.println(trie.getLongestCommonPrefix());


    }
}
