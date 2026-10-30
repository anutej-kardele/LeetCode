package LeetCode.Medium;

import java.util.Arrays;

public class PN567 {

    public static void main(String[] args) {

        String s1 = "ab", s2 = "eidbaooo";
        System.out.println("Expected: true Output: " + checkInclusionFor(s1, s2));

        System.out.println("\n");
        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println("Expected: false Output: " + checkInclusionFor(s1, s2));

        System.out.println("\n");

        s1 = "adc";
        s2 = "dcda";
        System.out.println("Expected: true Output: " + checkInclusionFor(s1, s2));
    }

    // droping while loop and using for - NO advantage on leetcode of this
    public static boolean checkInclusionFor(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;
        // create the expected result
        int[] chExpected = new int[26];
        // execution window - there are total 26 charectors
        int[] ch = new int[26];

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        for (int i = 0; i < s1.length(); i++) {
            chExpected[s1Arr[i] - 'a']++;
            ch[s2Arr[i] - 'a']++;
        }

        if (Arrays.equals(chExpected, ch))
            return true;

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {

            ch[s2Arr[r] - 'a']++;
            ch[s2Arr[l++] - 'a']--;

            if (Arrays.equals(chExpected, ch))
                return true;
        }

        return false;
    }

    // Solving using Fixed Sliding Window approach
    public static boolean checkInclusion(String s1, String s2) {

        // create the expected result
        int[] chExpected = new int[26];
        // execution window - there are total 26 charectors
        int[] ch = new int[26];
        int l = 0, r = -1;

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        for (int i = 0; i < s1.length(); i++) {
            chExpected[s1Arr[i] - 'a'] += 1;
            ch[s2Arr[++r] - 'a'] += 1;
        }

        while (r < s2.length()) {

            System.out.println("Window index " + l + " to " + r + " Size(r - l + 1): " + (r - l + 1) + " Char: "
                    + s2.substring(l, r + 1));

            if (Arrays.equals(chExpected, ch))
                return true;

            if (r == s2.length() - 1)
                break;

            ch[s2Arr[l++] - 'a'] -= 1;
            ch[s2Arr[++r] - 'a'] += 1;
        }

        return false;
    }

    // Slow beacause I am not using sliding window technique properly
    // I am more of using brute force as I am adding one and removing one
    // continously
    public static boolean checkInclusionSLOW(String s1, String s2) {

        // create the expected result
        int[] chExpected = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            chExpected[s1.charAt(i) - 'a'] += 1;
        }

        // there are total 26 charectors
        int[] ch = new int[26];

        // inserting the initial values
        int l = 0;
        int r = 0;
        ch[s2.charAt(r) - 'a'] += 1;

        System.out.println("Size1: " + s1.length() + " Size2: " + s2.length());

        while (r < s2.length()) {

            if (r - l + 1 == s1.length()) {
                System.out.println("Window index " + l + " to " + r + " Size(r - l + 1): " + (r - l + 1) + " Char: "
                        + s2.substring(l, r + 1));
                // if size equal then
                if (Arrays.equals(chExpected, ch))
                    return true;
                ch[s2.charAt(l++) - 'a'] -= 1;

            } else if (r - l + 1 < s1.length()) {
                System.out.println("Window index " + l + " to " + r + " Size(r - l + 1): " + (r - l + 1) + " Char: "
                        + s2.substring(l, r + 1));
                // increase size

                if (r == s2.length() - 1)
                    break;

                ch[s2.charAt(++r) - 'a'] += 1;
            }
        }

        return false;
    }
}
