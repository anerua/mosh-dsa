package AVLTree;

public class AVLTree {

    private class AVLNode {
        private final int value;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int height;

        public AVLNode(int value) {
            this.value = value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        var node = new AVLNode(value);

        if (this.root == null) {
            this.root = node;
            return;
        }

        insert(this.root, node);
    }

    private void insert(AVLNode root, AVLNode node) {
        if (node.value < root.value) {
            if (root.leftChild == null)
                root.leftChild = node;
            else
                insert(root.leftChild, node);
        }
        else if (node.value > root.value) {
            if (root.rightChild == null)
                root.rightChild = node;
            else
                insert(root.rightChild, node);
        }
        
        int leftHeight = height(root.leftChild);
        int rightHeight = height(root.rightChild);
        root.height = Math.max(leftHeight, rightHeight) + 1;

        int balanceFactor = balanceFactor(root);
        if (isLeftHeavy(root))
            System.out.println(root.value + " is Left Heavy");
        else if (isRightHeavy(root))
            System.out.println(root.value + " is Right Heavy");
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
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

}
