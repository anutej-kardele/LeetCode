package LeetCode.Medium;

public class PN424 {

    public static void main(String[] args) {

        // String s = "AABABBA";
        // int k = 1;
        String s = "ABAB";
        int k = 0;

        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {

        int len = s.length();
        if (len == 0 || len == 1)
            return len;

        int[] counts = new int[26];
        char[] chars = s.toCharArray();

        int p1 = 0;
        int maxFrequency = 1;
        int maxSize = 1;

        for (int p2 = 0; p2 < len; p2++) {

            counts[chars[p2] - 'A']++;
            int windowSize = p2 - p1 + 1;
            int newFrequency = counts[chars[p2] - 'A'];
            maxFrequency = maxFrequency < newFrequency ? newFrequency : maxFrequency;

            if (windowSize - maxFrequency > k) {
                counts[chars[p1] - 'A']--;
                p1++;
            }

            windowSize = p2 - p1 + 1;
            maxSize = maxSize < windowSize ? windowSize : maxSize;
        }

        return maxSize;
    }
}
