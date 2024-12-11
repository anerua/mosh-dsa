package Trie;

import java.util.Arrays;
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

    public void remove(String word) {
        if (word == null || word.equals(""))
            return;
        
        remove(root, word.toCharArray());
    }

    private void remove(Node root, char[] word) {
        if (root == null)
            return;
            
        if (word == null) {
            root.isEndOfWord = false;
            return;
        }

        var newRoot = root.children.get(word[0]);
        var newWord = (word.length == 1) ? null : Arrays.copyOfRange(word, 1, word.length);
      
        remove(newRoot, newWord);

        if (newRoot != null) {
            if (!newRoot.isEndOfWord && newRoot.children.isEmpty())
                root.children.remove(word[0]);
        }
    }
}
