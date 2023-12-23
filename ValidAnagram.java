/* 
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 */

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    static boolean isAnagram(String s, String t) {
        return method2(s, t);
    }

    private static boolean method2(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    private static boolean method1(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] alphabets = new int[26];

        for (char c : s.toCharArray()) {
            alphabets[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            alphabets[c - 'a']--;
        }

        for (int i : alphabets) {
            if (i != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "car";
        String t = "rat";
        System.out.println(isAnagram(s, t));
    }
}
