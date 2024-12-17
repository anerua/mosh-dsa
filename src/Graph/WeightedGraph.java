package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedGraph {

    private final Map<Node, LinkedList<Edge>> nodes = new HashMap<>();

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

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to + ", weight=" + weight;
        }
    }

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(node, new LinkedList<>());
    }

    public void addEdge(String from, String to, int weight) {
        Node toNode = new Node(to);
        Node fromNode = new Node(from);

        if (!(nodes.containsKey(fromNode) && nodes.containsKey(toNode)))
            throw new IllegalArgumentException();

        Edge edge = new Edge(fromNode, toNode, weight);
        Edge edgeComplement = new Edge(toNode, fromNode, weight);

        var fromNodeEdges = nodes.get(fromNode);
        if (!fromNodeEdges.contains(edge))
            fromNodeEdges.add(edge);

        var toNodeEdges = nodes.get(toNode);
        if (!toNodeEdges.contains(edgeComplement))
            toNodeEdges.add(edgeComplement);
    }

    public void print() {
        for (var node : nodes.entrySet()) {
            List<Edge> neighbors = new ArrayList<>();
            for (var neighbor : node.getValue())
                neighbors.add(neighbor);
            System.out.println(node.getKey() + " is connected with " + neighbors.toString());
        }
    }

}
