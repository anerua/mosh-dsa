package Queue;

import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

    public Queue<Integer> reverse(Queue<Integer> queue) {
        var stack = new Stack<Integer>();
        while (!queue.isEmpty()) {
            int item = queue.remove();
            stack.push(item);
        }
        while (!stack.isEmpty()) {
            int item = stack.pop();
            queue.add(item);
        }
        return queue;
    }
}
