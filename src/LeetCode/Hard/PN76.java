package LeetCode.Hard;

public class PN76 {

    public static void main(String[] args) {

        // String s = "ADOBECODEBANC", t = "ABC";
        String s = "a", t = "aa";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";
        int p1 = 0;

        int[] targetCounts = new int[128];
        int[] windowCounts = new int[128];

        char[] charS = s.toCharArray();

        int need = 0;
        for (char c : t.toCharArray()) {

            if (targetCounts[c] == 0)
                need++;
            targetCounts[c]++;
        }

        int minStart = 0;
        int minLength = Integer.MAX_VALUE;

        int have = 0;

        for (int p2 = 0; p2 < s.length(); p2++) {

            char rightChar = charS[p2];
            windowCounts[rightChar]++;

            if (targetCounts[rightChar] > 0 && targetCounts[rightChar] == windowCounts[rightChar])
                have++;

            while (have == need) {

                int currentLength = p2 - p1 + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    minStart = p1;
                }

                char leftChar = charS[p1];
                windowCounts[leftChar]--;

                if (targetCounts[leftChar] > 0 && windowCounts[leftChar] < targetCounts[leftChar])
                    have--;

                p1++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
