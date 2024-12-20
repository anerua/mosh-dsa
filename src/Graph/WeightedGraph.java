package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

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
        private final Node from;
        private final Node to;
        private final int weight;

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
        nodes.putIfAbsent(new Node(label), new LinkedList<>());
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
            List<Edge> edges = new ArrayList<>();
            for (Edge edge : node.getValue())
                edges.add(edge);
            System.out.println(node.getKey() + " is connected with " + edges.toString());
        }
    }

    private class NodeEntry {
        private final Node node;
        private final int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public int getShortestDistance(String from, String to) {
        Node fromNode = new Node(from);

        Map<Node, Integer> distances = new HashMap<>();
        for (Node node : nodes.keySet())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);

        Set<Node> visited = new HashSet<>();
        
        Map<Node, Node> previousNodes = new HashMap<>();


        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
            Comparator.comparingInt(ne -> ne.priority)
        );

        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll().node;
            visited.add(current);

            for (Edge edge : nodes.get(current)) {
                if (visited.contains(edge.to))
                    continue;

                int newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return distances.get(new Node(from));
    }

}
