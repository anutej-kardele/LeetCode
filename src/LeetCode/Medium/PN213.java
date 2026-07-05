package LeetCode.Medium;

import java.util.Arrays;

public class PN213 {

    public static void main(String[] args) {

        // int[] nums = { 2, 3, 2 };
        // int[] nums = { 1, 1, 1, 2 };
        // int[] nums = { 2, 2, 4, 3, 2, 5 };
        // int[] nums = { 1, 3, 1, 3, 100 };
        int[] nums = { 6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3 };
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int[] maxRob = new int[nums.length];
        boolean[] isFirstRobbed = new boolean[nums.length];

        maxRob[0] = nums[0];
        isFirstRobbed[0] = true;

        maxRob[1] = nums[1];
        isFirstRobbed[1] = false;

        for (int i = 2; i < nums.length; i++) {

            if (i == nums.length - 1) {

                int thisRob = maxRob[i - 2] + nums[i];
                int lastRob = maxRob[i - 1];
                int last2Rob = maxRob[i - 2];

                if (isFirstRobbed[i - 2])
                    thisRob -= nums[0];

                if (lastRob < maxRob[i - 1] - nums[i - 1] + nums[i] && !isFirstRobbed[i - 1])
                    lastRob = maxRob[i - 1] - nums[i - 1] + nums[i];

                int max = Math.max(thisRob, Math.max(lastRob, last2Rob));
                maxRob[i] = max;
                continue;
            }

            maxRob[i] = maxRob[i - 2] + nums[i];

            if (maxRob[i] == nums[i])
                isFirstRobbed[i] = false;
            else
                isFirstRobbed[i] = isFirstRobbed[i - 2];

            // else {
            // maxRob[i] = maxRob[i - 1];

            // if (maxRob[i] == nums[i])
            // isFirstRobbed[i] = false;
            // else
            // isFirstRobbed[i] = isFirstRobbed[i - 1];
            // }

            // maxRob[i] = Math.max(maxRob[i - 2] + nums[i], maxRob[i - 1]);
            // isFirstRobbed[i] = maxRob[i] == maxRob[i - 2] + nums[i];
        }

        System.out.println(Arrays.toString(maxRob));
        System.out.println(Arrays.toString(isFirstRobbed));

        return Math.max(maxRob[nums.length - 1], maxRob[nums.length - 2]);
    }

}
