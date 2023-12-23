/* 
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
public class FirstIndexOfString {
    static int strStr0(String haystack, String needle) {
        int n = 0;
        int ans = -1;
        for (int h = 0; h < haystack.length(); h++) {
            if (n < needle.length())
                if (haystack.charAt(h) == needle.charAt(n)) {
                    if (ans == -1)
                        ans = h;
                    n++;
                } else {
                    ans = -1;
                    h-=n;
                    n = 0;
                }
            else
                break;
        }

        return n == needle.length() ? ans : -1;
    }
    static int strStr(String haystack, String needle) {
        int n = 0;
        for (int h = 0; h < haystack.length(); h++) {
            if (haystack.charAt(h) == needle.charAt(n)) {
                n++;
            } else {
                h -= n;
                n = 0;
            }
            if (n == needle.length()) {
                return h - n + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "dsad";
        System.out.println(strStr0(haystack, needle));
    }
}
