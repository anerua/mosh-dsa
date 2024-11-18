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

}
