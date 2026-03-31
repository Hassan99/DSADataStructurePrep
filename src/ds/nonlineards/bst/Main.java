package ds.nonlineards.bst;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(17);
        bst.add(65);
        bst.add(12);
        bst.add(6);
        bst.add(1);
//        System.out.println(bst.search(11));
//        bst.delete( 6);
        bst.preOrderTraversal();
        bst.inOrderTraversal();
        bst.postOrderTraversal();
        System.out.println("Height of the tree is: " + bst.findHeight());
        System.out.println(bst.findMin());
        System.out.println(bst.findMax());
        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.add(10);
        bst1.add(5);
        bst1.add(15);
        bst1.add(12);
        bst1.add(6);
        bst1.add(1);
        System.out.println(bst.equalityCheck(bst1.rootNode));
        bst.nodeAtKDistance(1).forEach(System.out::println);
        bst.levelOrderTraversal();
        bst.size();
        bst.countLeafs();
        bst.max();
        System.out.println("Value is " + (bst.find(68) ? "Found" : "Not Found"));
        System.out.println("Value are " + (bst.areSiblings(5, 15) ? "Siblings" : "Not Siblings"));
        System.out.println("\nAncestors are:");
        bst.getAncestors(6).forEach(System.out::println);


    }
}
