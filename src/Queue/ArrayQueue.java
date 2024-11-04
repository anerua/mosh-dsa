package Queue;

import java.util.Arrays;

public class ArrayQueue {

    private final int[] queue;
    private int front;
    private int back;
    private int size;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
    }

    public void enqueue(int item) {
        if (size == queue.length) throw new IllegalStateException();

        queue[back++] = item;

        // Mosh used modulo here but that means back will keep increasing for as long as more items
        // are dequeued, which limits operations to the capacity of the integer type in Java
        if (back == queue.length) back = 0;
        
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();

        int item = queue[front++];

        // Again this > modulo approach
        if (front == queue.length) front = 0;
        
        size--;
        
        return item;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
