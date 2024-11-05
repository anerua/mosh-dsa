package Queue;

import java.util.Stack;

public class StackQueue {

    private final Stack<Integer> enqStack = new Stack<>();
    private final Stack<Integer> deqStack = new Stack<>();
    private final int capacity;
    private int size;

    public StackQueue(int capacity) {
        this.capacity = capacity;
    }

    // O(1)
    public void enqueue(int item) {
        if (isFull()) throw new IllegalStateException();

        enqStack.add(item);

        size++;
    }

    // O(n)
    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();

        if (deqStack.empty()) {
            while (!enqStack.empty()) {
                int popped = enqStack.pop();
                deqStack.push(popped);
            }
        }

        int item = deqStack.pop();

        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();

        if (deqStack.empty())
            while (!enqStack.empty()) 
                deqStack.push(enqStack.pop());

        int item = deqStack.peek();

        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
