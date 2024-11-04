package Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SyntaxChecker {

    private final List<Character> openers = Arrays.asList('(', '[', '<', '{');
    private final List<Character> closers = Arrays.asList(')', ']', '>', '}');

    private boolean isPair(char opener, char closer) {
        return openers.indexOf(opener) == closers.indexOf(closer);
    }

    private boolean isOpener(char c) {
        return openers.contains(c);
    }

    private boolean isCloser(char c) {
        return closers.contains(c);
    }

    public boolean checker(String str) {
        var stack = new Stack<Character>();
        for (char c: str.toCharArray()) {
            if (isOpener(c))
                stack.push(c);
            else if (isCloser(c)) {
                if (stack.empty()) return false;

                char opener = stack.pop();
                if (!isPair(opener, c)) return false;
            }
        }

        return stack.empty();
    }
}
