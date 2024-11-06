package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    public char findFirstNonRepeatedChar(String text) {
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (c == ' ') continue;

            // if (map.containsKey(c))
            //     map.put(c, map.get(c) + 1);
            // else
            //     map.put(c, 1);

            // Mosh's implementation
            int count = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, count + 1);
        }

        for (char c : chars) {
            if (c == ' ') continue;
            if (map.get(c) == 1)
                return c;
        }

        return Character.MIN_VALUE;
    }

    public char findFirstRepeatedChar(String text) {
        Set<Character> set = new HashSet<>();

        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (c == ' ') continue;
            if (set.contains(c)) return c;
            set.add(c);
        }

        return Character.MIN_VALUE;
    }

}
