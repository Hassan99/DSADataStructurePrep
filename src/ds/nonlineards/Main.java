package ds.nonlineards;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(6);
        bst.add(1);
        System.out.println(bst.search(11));
        bst.delete( 6);

    }
}
