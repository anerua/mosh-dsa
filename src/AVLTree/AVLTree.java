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
        
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }

}
