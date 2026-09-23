package LeetCode.Medium;

public class PN647 {

    public static void main(String[] args) {
        System.out.println("abc : " + countSubstrings("abc"));
        System.out.println("aaa : " + countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {

        int numberPal = 0;

        // Find even palindrome
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                numberPal++;
                l--;
                r++;
            }
        }

        // Find odd palindrome
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                numberPal++;
                l--;
                r++;
            }
        }

        return numberPal;
    }

}
