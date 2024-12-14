package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

}
