package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;

public class PN3 {

    public static void main(String[] args) {

        // String s = "abcabcbb";
        // String s = "bbbbb";
        String s = "pwwkew";
        System.out.println(s.length());
        System.out.println("Lenght Longest Substring: " + lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0)
            return 0;

        char[] chars = s.toCharArray();

        int p1 = 0;
        int p2 = 1;

        int maxsubstring = 1;

        Set<Character> allCharacters = new HashSet<>();
        allCharacters.add(chars[0]);

        while (p2 < s.length()) {

            allCharacters.add(chars[p2]);

            int currSubStrLen = p2 - p1 + 1;
            if (currSubStrLen == allCharacters.size()) {
                maxsubstring = currSubStrLen > maxsubstring ? currSubStrLen : maxsubstring;

                p2++;
            } else {
                // we found a duplicate
                // remove the value
                allCharacters.remove(chars[p1]);
                p1++;
            }
        }

        return maxsubstring;
    }
}
