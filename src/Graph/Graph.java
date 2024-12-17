package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {

    private final Map<Node, LinkedList<Node>> nodes = new HashMap<>();

    private class Node {
        private final String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            
            Node other = (Node) obj;
            if (!label.equals(other.label))
                return false;
            
            return true;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;

            result = prime * result + getLabelHash(label);
            return result;
        }

        private int getLabelHash(String label) {
            char[] value = label.toCharArray();
            int h = 0;
            int hash = h;
            if (hash == 0 && value.length > 0) {
                char val[] = value;

                for (int i = 0; i < value.length; i++) {
                    hash = 31 * hash + val[i];
                }
                h = hash;
            }
            return h;
        }
    }

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(node, new LinkedList<>());
    }

    public void removeNode(String label) {
        var node = new Node(label);
        if (!nodes.containsKey(node))
            throw new IllegalArgumentException();

        for (var v : nodes.keySet())
            removeEdge(v.label, label);

        nodes.remove(node);
    }

    public void addEdge(String from, String to) {
        var fromNode = new Node(from);
        var toNode = new Node(to);

        if (!(nodes.containsKey(fromNode) && nodes.containsKey(toNode)))
            return;

        var edges = nodes.get(fromNode);
        if (!edges.contains(toNode))
            edges.addLast(toNode);   
    }

    public void removeEdge(String from, String to) {
        var fromNode = new Node(from);
        var toNode = new Node(to);

        if (!(nodes.containsKey(fromNode) && nodes.containsKey(toNode)))
            return;

        var edges = nodes.get(fromNode);
        edges.remove(toNode);
    }

    public void print() {
        for (var node : nodes.entrySet()) {
            List<String> neighbors = new ArrayList<>();
            for (var neighbor : node.getValue())
                neighbors.add(neighbor.label);
            System.out.println(node.getKey() + " is connected with " + neighbors.toString());
        }
    }

    public void depthFirstTraversal(String label) {
        Node node = new Node(label);
        if (!nodes.containsKey(node))
            return;

        depthFirstTraversal(node, new HashSet<>());
    }

    private void depthFirstTraversal(Node root, Set<String> traversed) {
        System.out.println(root.label);
        traversed.add(root.label);

        for (Node neighbor : nodes.get(root))
            if (!traversed.contains(neighbor.label))
                depthFirstTraversal(neighbor, traversed);
    }

    public void depthFirstTraversalIterative(String label) {
        Node node = new Node(label);
        if (!nodes.containsKey(node))
            return;

        Set<String> traversed = new HashSet<>();
        Stack<Node> callStack = new Stack<>();
        callStack.push(node);

        while (!callStack.empty()) {
            Node current = callStack.pop();

            if (traversed.contains(current.label))
                continue;

            System.out.println(current.label);
            traversed.add(current.label);
            
            for (Node neighbor : nodes.get(current))
                if (!traversed.contains(neighbor.label))
                    callStack.push(neighbor);

        }
    }

    public void breadthFirstTraversal(String label) {
        Node node = new Node(label);
        if (!nodes.containsKey(node))
            return;

        Set<String> traversed = new HashSet<>();
        Queue<Node> callQueue = new ArrayDeque<>();
        callQueue.add(node);

        while (!callQueue.isEmpty()) {
            Node current = callQueue.poll();

            if (traversed.contains(current.label))
                continue;

            System.out.println(current.label);
            traversed.add(current.label);

            for (Node neighbor : nodes.get(current))
                if (!traversed.contains(neighbor.label))
                    callQueue.add(neighbor);
        }
    }

    public List<String> topologicalSort() {
        Set<String> traversed = new HashSet<>();
        Stack<Node> sortStack = new Stack<>();

        for (Node node : nodes.keySet())
            topologicalSort(node, traversed, sortStack);

        List<String> sorted = new ArrayList<>();
        while (!sortStack.empty())
            sorted.add(sortStack.pop().label);
        
        return sorted;
    }

    private void topologicalSort(Node root, Set<String> traversed, Stack<Node> sortStack) {
        if (traversed.contains(root.label))
            return;

        traversed.add(root.label);

        for (Node neighbor : nodes.get(root))
            topologicalSort(neighbor, traversed, sortStack);

        sortStack.push(root);
    }

    public boolean hasCycle() {
        Set<Node> allNodes = new HashSet<>(nodes.keySet());
        Set<String> visiting = new HashSet<>();
        Set<String> traversed = new HashSet<>();

        while (!allNodes.isEmpty()) {
            Node current = allNodes.iterator().next();
            if (hasCycle(current, allNodes, visiting, traversed))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Set<Node> allNodes, Set<String> visiting, Set<String> traversed) {
        allNodes.remove(node);
        visiting.add(node.label);

        for (Node neighbor : nodes.get(node)) {
            if (traversed.contains(neighbor.label))
                continue;

            if (visiting.contains(neighbor.label))
                return true;

            if (hasCycle(neighbor, allNodes, visiting, traversed))
                return true;
        }

        visiting.remove(node.label);
        traversed.add(node.label);

        return false;
    }

}
