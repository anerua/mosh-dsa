package Tree;

public class Tree {

    private final Node root;

    public Tree(int value) {
        this.root = new Node(value);
    }

    public void insert(int value) {
        var node = new Node(value);

        var current = this.root;
        while (current != null) {
            var currentValue = current.getValue();
            if (value == currentValue)
                break;
            else if (value < currentValue) {
                var left = current.getLeftChild();
                if (left == null) {
                    current.setLeftChild(node);
                    break;
                }
                current = left;
            } else {
                var right = current.getRightChild();
                if (right == null) {
                    current.setRightChild(node);
                    break;
                }
                current = right;
            }
        }
    }

    public boolean find(int value) {
        var current = this.root;
        while (current != null) {
            if (value == current.getValue())
                return true;
            else if (value < current.getValue())
                current = current.getLeftChild();
            else
                current = current.getRightChild();
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(this.root);
    }

    private void traversePreOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.getValue());
        traversePreOrder(node.getLeftChild());
        traversePreOrder(node.getRightChild());
    }

    public void traverseInOrder() {
        traverseInOrder(this.root);
    }

    private void traverseInOrder(Node node) {
        if (node == null)
            return;

        traverseInOrder(node.getLeftChild());
        System.out.println(node.getValue());
        traverseInOrder(node.getRightChild());
    }

    public void traversePostOrder() {
        traversePostOrder(this.root);
    }

    private void traversePostOrder(Node node) {
        if (node == null)
            return;

        traversePostOrder(node.getLeftChild());
        traversePostOrder(node.getRightChild());
        System.out.println(node.getValue());
    }
}
