package LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;
    private int size = 0;

    public void addFirst(int value) {
        this.first = new Node(value, this.first);
        if (last == null)
            this.last = this.first;
        this.size++;
    }

    public void addLast(int value) {
        var node = new Node(value, null);

        // My implementation
        // if (this.last != null)
        // this.last.setNext(newLast);
        // this.last = newLast;
        // if (this.first == null)
        // this.first = this.last;

        // Mosh's implementation
        if (this.first == null)
            this.first = this.last = node;
        else {
            this.last.setNext(node);
            this.last = node;
        }

        this.size++;
    }

    public void deleteFirst() {
        if (this.first == null)
            throw new NoSuchElementException();

        // Mosh patch
        var second = this.first.getNext();
        this.first.setNext(null);
        this.first = second;

        this.size--;
    }

    public void deleteLast() {
        if (this.first == null)
            throw new NoSuchElementException();
        if (this.first == this.last) {
            this.first = this.last = null;
        } else {
            Node node = this.first;
            while (node != null) {
                if (node.getNext() == this.last) {
                    node.setNext(null);
                    break;
                }
                node = node.getNext();
            }
        }

        this.size--;
    }

    public boolean contains(int value) {
        // My implementation
        // Node node = this.first;
        // while (node != null) {
        // if (node.getValue() == value)
        // return true;
        // node = node.getNext();
        // }
        // return false;

        // Mosh's implementation
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        Node node = this.first;
        int index = 0;
        while (node != null) {
            if (node.getValue() == value)
                return index;
            index++;
            node = node.getNext();
        }
        return -1;
    }

    public int size() {
        // My implementation
        // if (this.first == null)
        //     return 0;
        // int size = 0;
        // var node = this.first;
        // while (node != null) {
        //     size++;
        //     node = node.getNext();
        // }
        // return size;

        return this.size;
    }

    public int[] toArray() {
        var array = new int[this.size];
        int index = 0;
        var node = this.first;
        while (node != null) {
            array[index++] = node.getValue();
            node = node.getNext();
        }
        return array;
    }

    public void reverse() {
        var node = this.first;
        this.last = node;
        while (node != null) {
            var currentNode = node;
            node = node.getNext();
            if (node != null) {
                this.addFirst(node.getValue());
                this.size--;
            }
            currentNode.setNext(null);
        }
    }

    public void print() {
        Node node = this.first;
        String list = "[";
        while (node != null) {
            list += Integer.toString(node.getValue()) + ",";
            node = node.getNext();
        }
        list += "]";
        System.out.println(list);
    }
}
