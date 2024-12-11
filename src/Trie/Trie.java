package Trie;

public class Trie {

    private class Node {
        private final char value;
        private final Node[] children = new Node[26];
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }
    }

    private final Node root = new Node(' ');

    public void insert(String word) {
        Node current = root;
        for (char letter : word.toCharArray()) {
            int index = letter - 'a';
            if (current.children[index] == null)
                current.children[index] = new Node(letter);

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }
}
