package ds.nonlineards.avltree;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);

        avlTree.insert(30);
        System.out.println("Is Balanced?:"+avlTree.isBalanced());
        avlTree.insert(20);
        System.out.println("Is Balanced?:"+avlTree.isBalanced());
        avlTree.insert(16);
        System.out.println("Is Balanced?:"+avlTree.isBalanced());
        avlTree.insert(5);
        System.out.println("Is Balanced?:"+avlTree.isBalanced());
        avlTree.insert(15);
//        avlTree.print();

        System.out.println("Is Balanced?:"+avlTree.isBalanced());
    }
}
