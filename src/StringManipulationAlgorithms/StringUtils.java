package StringManipulationAlgorithms;

import java.util.Set;

public class StringUtils {
    
    // Q1. Find the number of vowels in a String. Vowels in English are A, E, I, O, U.
    // I: "hello"
    // O: 2
    public static int findVowelCount(String word) {
        if (word == null)
            return 0;

        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U');

        int vowelCount = 0;
        for (char c : word.toCharArray())
            if (vowels.contains(Character.toUpperCase(c)))
                vowelCount++;

        return vowelCount;
    }

    // Q2. Reverse a string
    // I: "hello"
    // O: "olleh"
    public static String reverseString(String word) {
        if (word == null)
            return "";

        var reversed = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--)
            reversed.append(word.charAt(i));

        return reversed.toString();
    }
}
