package ds.nonlineards.bst;

import java.util.ArrayList;

public class BinarySearchTree {
    Node rootNode;

    static class Node {
        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        int value;
        Node left;
        Node right;

    }

    public void add(int value) {
        if (rootNode == null) {
            rootNode = new Node(value);
            return;
        }
        Node currentNode = rootNode;
        while (true) {
            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = new Node(value);
                    break;
                }
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                if (currentNode.right == null) {
                    currentNode.right = new Node(value);
                    break;
                }
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        System.out.println(rootNode);
    }

    public boolean search(int element) {
        Node currentNode = rootNode;
        while (currentNode !=null) {
            if ( element < currentNode.value) {
                currentNode = currentNode.left;
            } else if ( element > currentNode.value) {
                currentNode = currentNode.right;
            } else  {
                return true;
            }
        }
        return false;
    }

    public void delete(int key){
        rootNode = deleteRec(rootNode,key);
        System.out.println(rootNode);
    }
    Node deleteRec(Node root, int key) {
        if (root == null) return null;

        // 1. Traverse
        if (key < root.value) {
            root.left = deleteRec(root.left, key);

        } else if (key > root.value) {
            root.right = deleteRec(root.right, key);

        } else {
            // 2. Node found

            // Case 1: No child or one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            root.value = minValue(root.right);

            // Delete inorder successor
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    public void preOrderTraversal() {
        System.out.println("Your Pre Order Traversal output is:");
        preOrderTraversal(rootNode);
    }

    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrderTraversal() {
        System.out.println("Your In Order Traversal output is:");
        inOrderTraversal(rootNode);
    }

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.value);
        inOrderTraversal(node.right);
    }

    public void postOrderTraversal() {
        System.out.println("Your Post Order Traversal output is:");
        postOrderTraversal(rootNode);
    }

    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.value);
    }


    public int findHeight() {
        return findHeight(rootNode);
    }

    private int findHeight(Node node) {
        if (node == null) {
            return -1;
        }
        if (node.left == null && node.right == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }

    public int findMin() {
        return findMin(rootNode);
    }

    private int findMin(Node node) {
        if (node == null) {
            throw new IllegalStateException();
        }

        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public int findMax() {
        return findMax(rootNode);
    }

    private int findMax(Node node) {
        if (node == null) {
            throw new IllegalStateException();
        }

        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    public boolean equalityCheck(Node other) {

        return equals(rootNode, other);

    }

    private boolean equals(Node first, Node second) {
        if (first == null && second != null) {
            return false;
        }
        if (second == null && first != null) {
            return false;
        }
        if (first == null && second == null) {
            return true;
        }
        return first.value == second.value
                && equals(first.left, second.left)
                && equals(first.right, second.right);
    }

    public ArrayList<Integer> nodeAtKDistance(int distance) {

        var list = new ArrayList<Integer>();
        nodeAtKDistance(rootNode, distance, list);
        return list;
    }

    private void nodeAtKDistance(Node node, int distance, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        if (distance == 0) {
            list.add(node.value);
            return;
        }
        nodeAtKDistance(node.left, distance - 1, list);
        nodeAtKDistance(node.right, distance - 1, list);
    }

    public void levelOrderTraversal() {
        System.out.println("\n\nLevel Order Traversal");
        for (int i = 0; i < findHeight(); i++) {
            var list = nodeAtKDistance(i);
            for (int value : list) {
                System.out.println(value);
            }
        }
    }

    public void size() {
        System.out.println("Size of the Binary tree is:"+size(rootNode));
    }

    private int size(Node node) {
        if(node==null){
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

}
