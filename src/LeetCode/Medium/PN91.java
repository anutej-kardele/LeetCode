package LeetCode.Medium;

public class PN91 {

    public static void main(String[] args) {
        System.out.println("0 : " + numDecodings("0"));
    }

    public static int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        if (s.length() == 1)
            return 1;

        Integer[] memo = new Integer[s.length()];

        return decodeHelper(s, 0, memo);
    }

    public static int decodeHelper(String s, int i, Integer[] memo) {

        if (i == s.length())
            return 1;

        if (s.charAt(i) == '0')
            return 0;

        if (memo[i] != null)
            return memo[i];

        int ways = decodeHelper(s, i + 1, memo);

        if (i + 1 < s.length()) {
            int val = Integer.parseInt(s.substring(i, i + 2));
            if (10 <= val && val <= 26)
                ways += decodeHelper(s, i + 2, memo);
        }

        memo[i] = ways;

        return ways;
    }
}
