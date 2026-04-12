package ds.nonlineards.avltree;

/*public class AVLTree {
    AVLNode rootNode;

    public void print() {
        System.out.println(rootNode);
    }

    private class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        private int height;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value + "" + "\n" +
                    "" + leftChild != null ? "" + leftChild.value : "null" + "      " + rightChild != null ? "" + rightChild.value : "null";
        }
    }

    public void insert(int value) {
        rootNode = add(rootNode, value);
    }

    private AVLNode add(AVLNode node, int value) {
        if (node == null) {
            return new AVLNode(value);
        }
        if (value < node.value) {
            node.leftChild = add(node.leftChild, value);
        } else {
            node.rightChild = add(node.rightChild, value);
        }



        return balance(node);
    }

    public AVLNode balance(AVLNode node) {
        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0) {
               return rotateLeft(node);
            }
            return rotateRight(node);
        } else if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) > 0) {
              return rotateRight(node);
            }
            rotateLeft(node);
        }
    }

//    10
//       20   newRoot
//          30



    private AVLNode rotateLeft(AVLNode root) {
        var newRoot = root.rightChild;
        newRoot.leftChild = root;
        root.rightChild = newRoot.leftChild;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root.leftChild;
        newRoot.rightChild = root;
        root.leftChild = newRoot.rightChild;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }


    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return node == null ? 0 : height(node.leftChild) - height(node.rightChild);
    }
}*/

public class AVLTree {

    private AVLNode rootNode;

    private class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int height;

        public AVLNode(int value) {
            this.value = value;
            this.height = 0;
        }
    }

    public void insert(int value) {
        rootNode = add(rootNode, value);
    }

    private AVLNode add(AVLNode node, int value) {

        if (node == null)
            return new AVLNode(value);

        if (value < node.value)
            node.leftChild = add(node.leftChild, value);
        else if (value > node.value)
            node.rightChild = add(node.rightChild, value);
        else
            return node; // avoid duplicates

        // 1️⃣ Update height
        setHeight(node);

        // 2️⃣ Balance the node
        return balance(node);
    }

    private AVLNode balance(AVLNode node) {

        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0)
                node.leftChild = rotateLeft(node.leftChild); // LR case

            return rotateRight(node); // LL case
        }

        if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) > 0)
                node.rightChild = rotateRight(node.rightChild); // RL case

            return rotateLeft(node); // RR case
        }

        return node;
    }

    // 🔁 Right Rotation
    private AVLNode rotateRight(AVLNode root) {

        AVLNode newRoot = root.leftChild;
        AVLNode T2 = newRoot.rightChild;

        newRoot.rightChild = root;
        root.leftChild = T2;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    //10
    //   20
    //       30
    /*
       root
       var newRoot = root.rightChild
       var t2 = newRoot.leftChild
       newRoot.leftChild = root
       root.rightChild = t2
       setHeight(root)
       setHeight(newRoot)


        return newRoot;

     */

    // 🔁 Left Rotation
    private AVLNode rotateLeft(AVLNode root) {

        var newRoot = root.rightChild;
        AVLNode T2 = newRoot.leftChild;

        newRoot.leftChild = root;
        root.rightChild = T2;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    public boolean isBalanced(){

        return isBalanced(rootNode);
    }
    private boolean isBalanced(AVLNode node){
        int balanceFac = balanceFactor(node);
        return balanceFac<=1;

    }
}
