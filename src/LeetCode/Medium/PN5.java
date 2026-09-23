package LeetCode.Medium;

public class PN5 {

    public static void main(String[] args) {
        // System.out.println(longestPalindrome("babad"));
        // System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
    }

    public static String longestPalindrome(String s) {

        int palSize = 0;
        String pal = "";

        // Find even palindrome
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > palSize) {
                    palSize = r - l + 1;
                    pal = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }

        // Find odd palindrome
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > palSize) {
                    palSize = r - l + 1;
                    pal = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }

        return pal;
    }

}
