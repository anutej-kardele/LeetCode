package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class PN131 {

    public static void main(String[] args) {
        PN131 solution = new PN131();
        List<List<String>> result = solution.partition("aab");
        System.out.println(result);
    }

    List<List<String>> solution = new ArrayList<>();

    public List<List<String>> partition(String s) {

        // Calculate all possible palindromic partitions of the string
        char[] ch = s.toCharArray();
        int n = ch.length;
        boolean[][] dp = new boolean[n][n];

        // 'i' Represents length
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {

                int end = start + len - 1;
                if (ch[start] == ch[end])
                    // If the size is 1 or 2 its directly valid but if it has things in between we
                    // also need to check it
                    dp[start][end] = len <= 2 ? true : dp[start + 1][end - 1];
            }
        }

        backtrack(ch, dp, 0, new ArrayList<>());
        return solution;
    }

    public void backtrack(char[] ch, boolean[][] dp, int start, List<String> current) {

        if (start >= ch.length) {
            solution.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < ch.length; i++) {

            // OLD VERSION - WHERE IS USED TO CHECK WITH O(N)
            // if (!validPalindrome(ch, start, i))
            // continue;

            // NEW VERSION - NOW WE PRECOMPUTE A 'dp' with valid palindromic in O(N^2) and
            // then access it with just O(1)
            if (!dp[start][i])
                continue;

            // add
            current.add(new String(ch, start, i - start + 1));

            // backtrack
            backtrack(ch, dp, i + 1, current);

            // remove
            current.remove(current.size() - 1);
        }
    }

    // public boolean validPalindrome(char[] curr, int start, int end) {

    // while (start <= end) {
    // if (curr[start] != curr[end])
    // return false;

    // start++;
    // end--;
    // }

    // return true;
    // }

}
