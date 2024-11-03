package Stack;

import java.util.Stack;

public class StringReverser {
    public String reverse(String str) {
        if (str == null)
            throw new IllegalArgumentException();

        var stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++)
            stack.push(str.charAt(i));
        
        // My implementation
        // String reversed = "";
        // while (!stack.empty())
        //     reversed += stack.pop();

        // Mosh
        var reversed = new StringBuilder();
        while (!stack.empty())
            reversed.append(stack.pop());

        return reversed.toString();
    }
}
