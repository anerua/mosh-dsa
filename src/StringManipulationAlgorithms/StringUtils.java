package StringManipulationAlgorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    // Q4. Check if a string is a rotation of another string
    // ---------------------
    // I: "ABCD", "DABC"
    // O: true
    // ---------------------
    // I: "ABCD", "ADBC"
    // O: false
    public static boolean isRotation(String word, String rotation) {
        // if (word == null || rotation == null)
        //     return false;

        // if (word.length() != rotation.length())
        //     return false;

        // if (word.length() == 0)
        //     return true;

        // int index2 = rotation.indexOf(word.charAt(0));
        // if (index2 == -1)
        //     return false;

        // for (int i = 0; i < word.length(); i++) {
        //     var ch1 = word.charAt(i);
        //     var ch2 = rotation.charAt((i + index2) % rotation.length());
        //     if (ch1 != ch2)
        //         return false;
        // }

        // return true;


        // Mosh's implementation - Space intensive if word is long
        if (word == null || rotation == null)
            return false;

        return (word.length() == rotation.length() &&
                (word + word).contains(rotation));

    }

    // Q5. Remove duplicate characters in a string
    // I: "Hellooo!!"
    // O: "Helo!"
    public static String removeDuplicate(String word) {
        if (word == null)
            return "";

        Set<Character> letters = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (char c : word.toCharArray()){
            if (!letters.contains(c)) {
                builder.append(c);
                letters.add(c);
            }
        }

        return builder.toString();
    }

    // Q6. Find the most repeated character in a string
    // I: "Hellooo!!"
    // O: 'o'
    public static char mostRepeatedCharacter(String word) {
        if (word == null)
            return ' ';

        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (c == ' ') continue;
            int count = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, count + 1);
        }

        char mostRepeated = ' ';
        int mostCount = 0;
        for (var entry : map.entrySet()) {
            if (entry.getValue() > mostCount) {
                mostCount = entry.getValue();
                mostRepeated = entry.getKey();
            }
        }

        return mostRepeated;
    }

    // Q7. Capitalize the first letter of each word in a sentence. Also, remove any extra spaces between words
    // ---------------------------
    // I: "trees are beautiful"
    // O: "Trees Are Beautiful"
    // ---------------------------
    // I: "   trees   are     beautiful  "
    // O: "Trees Are Beautiful"
    public static String capitalizeSentence(String sentence) {
        if (sentence == null)
            return "";
        
        String[] words = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            if (!word.equals("")) {
                builder.append(capitalize(word));
                builder.append(" ");
            }
        }

        return builder.toString().strip();
    }

    private static String capitalize(String word) {
        String first = word.substring(0, 1).toUpperCase();
        String others = word.substring(1).toLowerCase();
        return first + others;
    }
}
