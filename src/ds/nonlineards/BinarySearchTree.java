package ds.nonlineards;

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
   /* public void delete(int element){
        if(rootNode.value==element){
            rootNode= null;
            return;
        }
        Node currentNode = rootNode;
        Node nodeToDelete;
        while (currentNode!=null){
            if ( element < currentNode.value) {
                currentNode = currentNode.left;
            } else if ( element > currentNode.value) {
                currentNode = currentNode.right;
            } else  {
                nodeToDelete = currentNode;

            }
        }
    }*/

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

}
