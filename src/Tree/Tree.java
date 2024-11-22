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

    public int height() {
        if (this.root == null)
            throw new IllegalStateException("Tree is empty");
            
        return height(this.root);
    }

    private int height(Node node) {
        if (node == null)
            return -1;

        if (isLeaf(node))
            return 0;

        return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    public int min() {
        if (this.root == null)
            throw new IllegalStateException("Tree is empty");

        return min(this.root);
    }

    private int min(Node node) {
        if (node == null)
            return Integer.MAX_VALUE;

        if (isLeaf(node))
            return node.getValue();

        return Math.min(node.getValue(), Math.min(min(node.getLeftChild()), min(node.getRightChild())));
    }

    public boolean equals(Tree other) {
        if (other == null)
            return false;

        return equals(this.root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.getValue() == second.getValue()
                    && equals(first.getLeftChild(), second.getLeftChild())
                    && equals(first.getRightChild(), second.getRightChild());

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node node, int min, int max) { 
        if (node == null)
            return true;

        if (node.getValue() <= min || node.getValue() >= max)
            return false;

        var left = isBinarySearchTree(node.getLeftChild(), min, node.getValue());
        var right = isBinarySearchTree(node.getRightChild(), node.getValue(), max);

        return left && right;
    }

    public void swapRoot() {
        var temp = this.root.getLeftChild();
        this.root.setLeftChild(this.root.getRightChild());
        this.root.setRightChild(temp);
    }

    public void printNodesAtDistance(int distance) {
        printNodesAtDistance(this.root, distance);
    }

    private void printNodesAtDistance(Node node, int distance) {
        if (node == null)
            return;

        if (distance == 0) {
            System.out.println(node.getValue());
            return;
        }

        printNodesAtDistance(node.getLeftChild(), distance - 1);
        printNodesAtDistance(node.getRightChild(), distance - 1);
    }

    public void traverseLevelOrder() {
        for (var i = 0; i <= height(); i++) {
            printNodesAtDistance(i);
        }
    }

    public int size() {
        return size(this.root);
    }

    private int size(Node root) {
        if (root == null)
            return 0;
        
        return 1 + size(root.getLeftChild()) + size(root.getRightChild());
    }

    public int countLeaves() {
        return countLeaves(this.root);
    }

    private int countLeaves(Node root) {
        if (root == null)
            return 0;
            
        if (isLeaf(root))
            return 1;

        return countLeaves(root.getLeftChild()) + countLeaves(root.getRightChild());
    }

    private boolean isLeaf(Node node) {
        return node.getLeftChild() == null && node.getRightChild() == null;
    }
}
