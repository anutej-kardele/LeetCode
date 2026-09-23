package LeetCode.Medium;

import java.util.Arrays;

public class PN322 {

    public static void main(String[] args) {

        // int[] coins = { 1, 2, 5 };
        int[] coins = { 2 };

        System.out.println(coinChange(coins, 3));
    }

    // lower to higher approach

    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int j = 0; j < coins.length; j++) {

                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int coinChange2(int[] coins, int amount) {

        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;

        Integer[] memo = new Integer[amount + 1];

        return coinHelper(coins, amount, memo);
    }

    public static int coinHelper(int[] coins, int amount, Integer[] memo) {

        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        if (memo[amount] != null)
            return memo[amount];

        int minCoins = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {

            int recersion = coinHelper(coins, amount - coins[i], memo);

            if (recersion >= 0 && recersion < minCoins)
                minCoins = 1 + recersion;
        }

        memo[amount] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;

        return memo[amount];
    }

}
