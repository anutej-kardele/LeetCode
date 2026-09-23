package LeetCode.Easy;

public class PN680 {

    public static void main(String[] args) {
        System.out.println("aba : " + validPalindrome("aba"));
        System.out.println("abca : " + validPalindrome("abca"));
        System.out.println("Test Case 470 Exp True : " + validPalindrome(
                "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public static boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            return decisionHelper(left + 1, right, s) || decisionHelper(left, right - 1, s);

        }

        return true;
    }

    public static boolean decisionHelper(int left, int right, String s) {

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            return false;
        }
        return true;
    }
}
