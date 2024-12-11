package Trie;

import java.util.HashMap;

public class Trie {

    private class Node {
        private final char value;
        private final HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }
    }

    private final Node root = new Node(' ');

    public void insert(String word) {
        Node current = root;
        for (char letter : word.toCharArray()) {
            if (current.children.get(letter) == null)
                current.children.put(letter, new Node(letter));
            current = current.children.get(letter);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;
        
        Node current = root;
        for (char letter : word.toCharArray()) {
            if (current.children.get(letter) == null)
                return false;
            current = current.children.get(letter);
        }
        return current.isEndOfWord;
    }
}
