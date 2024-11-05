package Queue;

import java.util.Arrays;

public class PriorityQueue {

    private final int[] queue;
    private int front;
    private int back;
    private int size;

    public PriorityQueue(int capacity) {
        queue = new int[capacity];
    }

    public void enqueue(int item) {
        if (isFull()) throw new IllegalStateException();

        int index = back;
        int counter = 0;
        while (counter <= size) {
            if (index == front) {
                queue[index] = item;
                break;
            }

            int focus = (index - 1);
            if (focus < 0) focus = queue.length - 1;
            
            if (item < queue[focus]) {
                queue[index] = queue[focus];
                --index;
                if (index < 0) index = queue.length - 1;
            } else {
                queue[index] = item;
                break;
            }

            ++counter;
        }

        back = (back + 1) % queue.length;

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
