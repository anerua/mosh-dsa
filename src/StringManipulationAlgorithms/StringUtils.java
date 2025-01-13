package StringManipulationAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
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

    // Q3. Reverse the order of words in a sentence
    // I: "Trees are beautiful"
    // O: "beautiful are Trees"
    public static String reverseSentence(String sentence) {
        if (sentence == null)
            return "";

        String[] words = sentence.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);


        // Vanilla implementation    
        // var reversed = new StringBuilder();
        // for (int i = words.length - 1; i >= 0; i--)
        //     reversed.append(words[i] + " ");

        // return reversed.toString().trim();
    }
}
