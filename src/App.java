import AVLTree.AVLTree;
import Array.Array;
import Graph.Graph;
import Graph.WeightedGraph;
import HashTable.CharFinder;
import HashTable.HashTable;
import Heap.Heap;
import Heap.MaxHeap;
import LinkedList.LinkedList;
import LinkedList.Node;
import Queue.PriorityQueue;
import SearchingAlgorithms.Search;
import SortingAlgorithms.BubbleSort;
import SortingAlgorithms.BucketSort;
import SortingAlgorithms.CountingSort;
import SortingAlgorithms.InsertionSort;
import SortingAlgorithms.MergeSort;
import SortingAlgorithms.QuickSort;
import SortingAlgorithms.SelectionSort;
import Stack.Stack;
import StringManipulationAlgorithms.StringUtils;
import Tree.Tree;
import Trie.Trie;
import java.util.Arrays;

public class App {

    public void runArray() {
        Array numbers = new Array(4);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.print();
        numbers.removeAt(1);
        numbers.print();
        System.out.println(numbers.indexOf(30));
    }

    public void runNode() {
        Node node = new Node(2, null);
        System.out.println(node.getValue());
        System.out.println(node.getNext().getValue());
    }

    public void runLinkedList() {
        var linkedList = new LinkedList();
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addLast(3);
        System.out.println(linkedList.contains(3));
        System.out.println(linkedList.indexOf(3));
        var array1 = linkedList.toArray();
        System.out.println(Arrays.toString(array1));
        linkedList.print();
        linkedList.reverse();
        System.out.println("The reversed list");
        linkedList.print();
        System.out.println(linkedList.size());
        linkedList.deleteFirst();
        linkedList.print();
        System.out.println(linkedList.size());
        linkedList.deleteFirst();
        linkedList.print();
        System.out.println(linkedList.size());
        linkedList.deleteLast();
        linkedList.print();
        linkedList.reverse();
        System.out.println("The reversed list");
        linkedList.print();
        var array2 = linkedList.toArray();
        System.out.println(Arrays.toString(array2));
        System.out.println(linkedList.size());
        System.out.println(linkedList.contains(8));
        System.out.println(linkedList.indexOf(3));
    }

    public void runStack() {
        // Reverse a string
        // String text = "ABCDEFG";
        // var reverser = new StringReverser();
        // String reversed = reverser.reverse(text);
        // System.out.println(reversed);

        // Balanced Expressions
        // String expression = "(())()<[(>])";
        // var checker = new SyntaxChecker();
        // System.out.println(checker.checker(expression));

        // Building a Stack with an Array
        var stack = new Stack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
    }

    public void runQueue() {
        // Reversing a Queue
        // Queue<Integer> queue = new ArrayDeque<>();
        // queue.add(10);
        // queue.add(20);
        // queue.add(30);
        // System.out.println(queue);
        // var reverser = new QueueReverser();
        // Queue<Integer> reversed = reverser.reverse(queue);
        // System.out.println(reversed);

        // Building a Queue with an Array
        // var queue = new ArrayQueue(5);
        // System.out.println(queue.isEmpty());
        // System.out.println(queue.isFull());
        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);
        // queue.enqueue(40);
        // queue.enqueue(50);
        // System.out.println(queue);
        // queue.dequeue();
        // System.out.println(queue.peek());
        // queue.enqueue(60);
        // System.out.println(queue);
        // queue.dequeue();
        // System.out.println(queue.peek());
        // queue.enqueue(70);
        // System.out.println(queue);
        // queue.dequeue();
        // queue.enqueue(80);
        // queue.dequeue();
        // System.out.println(queue);
        // System.out.println(queue.peek());
        // queue.dequeue();
        // queue.dequeue();
        // System.out.println(queue);
        // System.out.println(queue.peek());
        // queue.dequeue();
        // queue.dequeue();
        // System.out.println(queue.isEmpty());
        // System.out.println(queue.isFull());

        // Building a Queue using a Stack
        // var queue = new StackQueue(5);
        // System.out.println(queue.isEmpty());
        // System.out.println(queue.isFull());
        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);
        // queue.enqueue(40);
        // queue.enqueue(50);
        // System.out.println(queue.isFull());
        // System.out.println(queue.peek());
        // queue.dequeue();
        // System.out.println(queue.peek());
        // queue.enqueue(60);
        // System.out.println(queue.peek());
        // queue.dequeue();
        // System.out.println(queue.peek());
        // queue.dequeue();
        // queue.dequeue();
        // queue.dequeue();
        // System.out.println(queue.peek());
        // queue.dequeue();
        // System.out.println(queue.isEmpty());
        // System.out.println(queue.peek());
        
        // Building a PriorityQueue using an Array
        var queue = new PriorityQueue(5);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue.isFull());
        System.out.println(queue.peek());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.peek());
        queue.enqueue(35);
        System.out.println(queue);
        System.out.println(queue.peek());
        queue.dequeue();
        queue.enqueue(25);
        System.out.println(queue);
        System.out.println(queue.peek());
    }

    public void runHashTable() {
        String text = "a green apple";
        var finder = new CharFinder();
        System.out.println(finder.findFirstNonRepeatedChar(text));
        System.out.println(finder.findFirstRepeatedChar(text));

        var hashTable = new HashTable();
        hashTable.put(6, "John");
        hashTable.put(8, "Jane");
        hashTable.put(11, "Doe");
        hashTable.remove(6);
        System.out.println(hashTable.get(6));
    }

    public void runTree() {
        var tree1 = new Tree(10);
        tree1.insert(5);
        tree1.insert(15);
        tree1.insert(11);
        tree1.insert(12);
        tree1.insert(16);
        System.out.println("Check existence with find");
        System.out.println(tree1.find(12));
        System.out.println("Check existence with contains");
        System.out.println(tree1.contains(12));
        System.out.println("Pre Order Traversal");
        tree1.traversePreOrder();
        System.out.println("In Order Traversal");
        tree1.traverseInOrder();
        System.out.println("Post Order Traversal");
        tree1.traversePostOrder();
        System.out.println("Height of the tree");
        System.out.println(tree1.height());
        System.out.println("Minimum value in the tree");
        System.out.println(tree1.min());

        System.out.println("Maximum value in the tree");
        System.out.println(tree1.max());

        var tree2 = new Tree(10);
        tree2.insert(5);
        tree2.insert(15);
        tree2.insert(6);
        tree2.insert(12);
        tree2.insert(2);
        System.out.println(tree1.equals(tree2));

        System.out.println(tree1.isBinarySearchTree());
        // tree1.swapRoot();
        // System.out.println(tree1.isBinarySearchTree());

        tree1.printNodesAtDistance(1);
        tree2.printNodesAtDistance(2);

        System.out.println("Level Order Traversal");
        tree1.traverseLevelOrder();

        System.out.println("Size of tree");
        System.out.println(tree1.size());

        System.out.println("Number of leaves");
        System.out.println(tree1.countLeaves());

        System.out.println("Are siblings?");
        System.out.println(tree1.areSiblings(11, 15));
        System.out.println(tree2.areSiblings(6, 2));

        System.out.println("Get ancestors");
        System.out.println(tree1.getAncestors(1));
    }

    public void runAVLTree() {
        var tree1 = new AVLTree();
        tree1.insert(10);
        tree1.insert(20);
        tree1.insert(30);
        System.out.println(tree1.isBalanced());
    }

    public void runHeap() {
        var heap = new Heap(10);
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        System.out.println(heap.remove());
        System.out.println("Done");

        int[] numbers = { 5, 3, 8, 4, 1, 2 };
        MaxHeap.heapify(numbers);
        System.out.println(Arrays.toString(numbers));

        System.out.println(MaxHeap.getKthLargest(numbers, 1));
    }

    public void runTrie() {
        var trie = new Trie();
        trie.insert("canada");
        trie.insert("star");
        trie.insert("dreams");
        trie.insert("crop");
        trie.insert("can");
        System.out.println(trie.contains("canada"));
        // trie.remove("canada");
        // System.out.println(trie.contains("canada"));
        System.out.println(trie.autocomplete("c"));

        // var trie2 = new Trie();
        // trie2.insert("bo");
        // trie2.insert("boo");
        // trie2.insert("book");
        // trie2.insert("bor");
        // trie2.remove("boo");
        // System.out.println(trie2.contains("bor"));
    }

    public void runGraph() {
        var graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.addEdge("D", "C");
        graph.print();
        System.out.println("-----------------");
        // graph.removeEdge("D", "A");
        // graph.removeNode("C");
        // graph.print();

        System.out.println("Recursive:");
        graph.depthFirstTraversal("A");

        System.out.println("Iterative:");
        graph.depthFirstTraversalIterative("A");

        System.out.println("Breadth-First Traversal");
        graph.breadthFirstTraversal("A");

        var graph2 = new Graph();
        graph2.addNode("X");
        graph2.addNode("A");
        graph2.addNode("B");
        graph2.addNode("P");
        graph2.addEdge("X", "A");
        graph2.addEdge("X", "B");
        graph2.addEdge("A", "P");
        graph2.addEdge("B", "P");

        System.out.println("Topological Sort");
        System.out.println(graph2.topologicalSort());

        System.out.println("Has cycle");
        System.out.println(graph2.hasCycle());
    }

    public void runWeightedGraph() {
        var graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 2);
        graph.addEdge("A", "C", 10);
        
        var path = graph.getShortestPath("A", "C");
        System.out.println(path);

        System.out.println(graph.hasCycle());

        var graph2 = new WeightedGraph();
        graph2.addNode("A");
        graph2.addNode("B");
        graph2.addNode("C");
        graph2.addNode("D");
        graph2.addEdge("A", "B", 3);
        graph2.addEdge("B", "D", 4);
        graph2.addEdge("C", "D", 5);
        graph2.addEdge("A", "C", 1);
        graph2.addEdge("B", "C", 2);
        var tree = graph2.getMinimumSpanningTree();
        tree.print();
    }

    public void runSortingAlgorithms() {
        // int[] array2 = {8, 2, 4, 1, 3};
        int[] array = {7, 3, 5, 2, 3, 1, 5, 8};

        var items = array.clone();
        var bubbleSort = new BubbleSort();
        bubbleSort.sort(items);
        System.out.println("Bubble Sort");
        System.out.println(Arrays.toString(items));
        System.out.println();

        var items2 = array.clone();
        var selectionSort = new SelectionSort();
        selectionSort.sort(items2);
        System.out.println("Selection Sort");
        System.out.println(Arrays.toString(items2));
        System.out.println();

        var items3 = array.clone();
        var insertionSort = new InsertionSort();
        insertionSort.sort(items3);
        System.out.println("Insertion Sort");
        System.out.println(Arrays.toString(items3));
        System.out.println();

        var items4 = array.clone();
        var mergeSort = new MergeSort();
        mergeSort.sort(items4);
        System.out.println("Merge Sort");
        System.out.println(Arrays.toString(items4));
        System.out.println();

        var items5 = array.clone();
        var quickSort = new QuickSort();
        quickSort.sort(items5);
        System.out.println("Quick Sort");
        System.out.println(Arrays.toString(items5));
        System.out.println();

        var items6 = array.clone();
        var countingSort = new CountingSort();
        countingSort.sort(items6, 8);
        System.out.println("Counting Sort");
        System.out.println(Arrays.toString(items6));
        System.out.println();

        var items7 = array.clone();
        var bucketSort = new BucketSort();
        bucketSort.sort(items7, 3);
        System.out.println("Bucket Sort");
        System.out.println(Arrays.toString(items7));
        System.out.println();
    }

    public void runSearchingAlgorithms() {
        int[] items = { 7, 3, 5, 2, 3, 1, 5, 8 };
        int[] sortedItems = { 1, 2, 3, 3, 5, 5, 7, 8 };
        int target = 3;

        var search = new Search();

        System.out.println("Linear Search");
        System.out.println(search.linearSearch(items, target));
        System.out.println();

        System.out.println("Binary Search (Recursive)");
        System.out.println(search.binarySearchRecursive(sortedItems, target));
        System.out.println();

        System.out.println("Binary Search (Iterative)");
        System.out.println(search.binarySearchIterative(sortedItems, target));
        System.out.println();

        System.out.println("Ternary Search");
        System.out.println(search.ternarySearch(sortedItems, target));
        System.out.println();

        System.out.println("Jump Search");
        System.out.println(search.jumpSearch(sortedItems, target));
        System.out.println();

        System.out.println("Exponential Search");
        System.out.println(search.exponentialSearch(sortedItems, target));
        System.out.println();
    }

    public void runStringManipulationAlgorithms() {
        String word = "hEllo World";
        System.out.println("The word is: " + word);
        
        // 1. Vowel Count
        int vowelCount = StringUtils.findVowelCount(word);
        System.out.println("Vowel count is: " + vowelCount);

        // 2. Reverse String
        String reversed = StringUtils.reverseString(word);
        System.out.println("The reversed string is: " + reversed);

    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        // app.runArray();
        // app.runNode();
        // app.runLinkedList();
        // app.runStack();
        // app.runQueue();
        // app.runHashTable();
        // app.runTree();
        // app.runAVLTree();
        // app.runHeap();
        // app.runTrie();
        // app.runGraph();
        // app.runWeightedGraph();
        // app.runSortingAlgorithms();
        // app.runSearchingAlgorithms();
        app.runStringManipulationAlgorithms();
    }
}
