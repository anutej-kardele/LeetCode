package LeetCode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class PN300 {

    public static void main(String[] args) {

        PN300 solution = new PN300();
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int result = solution.lengthOfLIS(nums);
        System.out.println(result);
        System.out.println("Expected: 4");

        nums = new int[] { 0, 1, 0, 3, 2, 3 };
        result = solution.lengthOfLIS(nums);
        System.out.println(result);
        System.out.println("Expected: 4");

        nums = new int[] { 7, 7, 7, 7, 7, 7, 7 };
        result = solution.lengthOfLIS(nums);
        System.out.println(result);
        System.out.println("Expected: 1");
    }

    public int lengthOfLIS(int[] nums) {

        int ans = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {

            dp[i] = 1;
            int j = i - 1;

            while (j >= 0) {
                if (nums[i] > nums[j]) {
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                    ans = dp[i] > ans ? dp[i] : ans;
                }
                j--;
            }
        }

        return ans;
    }

    public int lengthOfLISWRONG(int[] nums) {

        int max = 1;
        int n = nums.length - 1;

        int[] dp = new int[nums.length];
        dp[n] = 1;

        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] { nums[n], n });

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek()[0] <= nums[i]) {
                stack.pop();
            }

            dp[i] = 1;
            if (!stack.isEmpty())
                dp[i] += dp[stack.peek()[1]];

            max = dp[i] > max ? dp[i] : max;

            System.out.println("i[" + i + "] num[" + nums[i] + "], dp[i]: " + dp[i]);
            stack.push(new int[] { nums[i], i });
        }

        return max;

    }
}
