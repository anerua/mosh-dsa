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
        if (isFull()) throw new IllegalStateException();

        queue[back++] = item;

        back = back % queue.length;
        
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();

        int item = queue[front++];

        front = front % queue.length;

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
