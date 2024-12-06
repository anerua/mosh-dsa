package Heap;

public class Heap {
    private int[] heap;
    private int size;
    // private int rootIndex;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size++] = value;

        bubbleUp();
    }
    
    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
