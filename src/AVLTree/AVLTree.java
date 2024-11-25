package AVLTree;

public class AVLTree {

    private class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

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
            if (root.leftChild == null) {
                root.leftChild = node;
                return;
            }

            insert(root.leftChild, node);
        }
        else if (node.value > root.value) {
            if (root.rightChild == null) {
                root.rightChild = node;
                return;
            }

            insert(root.rightChild, node);
        }
         
    }

}
