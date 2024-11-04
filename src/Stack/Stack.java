package Stack;

public class Stack {

    private final int[] stack = new int[2];
    private int pointer = 0;

    public void push(int item) {
        if (pointer == stack.length)
            throw new StackOverflowError();
        stack[pointer++] = item;
    }

    public int pop() {
        if (pointer == 0) throw new IllegalStateException();
        return stack[--pointer];
    }

    public int peek() {
        if (pointer == 0) throw new IllegalStateException();
        return stack[pointer - 1];
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

}
