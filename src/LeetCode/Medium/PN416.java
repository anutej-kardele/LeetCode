package LeetCode.Medium;

import java.util.Arrays;

public class PN416 {

    public static void main(String[] args) {
        PN416 solution = new PN416();
        int[] nums = { 1, 5, 11, 5 };
        System.out.println(solution.canPartition(nums));

        int[] nums2 = { 1, 2, 3, 5 };
        System.out.println(solution.canPartition(nums2));
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        sum /= 2; // converting to target

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {

            for (int j = sum; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }

            if (dp[sum])
                return true;
        }

        return false;
    }

    public boolean canPartitionWRONG(int[] nums) {

        if (nums.length <= 1)
            return false;

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        int lsum = nums[0], rsum = nums[nums.length - 1];
        int l = 0, r = nums.length - 1;

        while (l + 1 < r) {
            if (lsum < rsum) {
                lsum += nums[++l];
            } else {
                rsum += nums[--r];
            }
        }

        return lsum == rsum;
    }
}
