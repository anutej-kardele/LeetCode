package LeetCode.Medium;

public class PN152 {

    public static void main(String[] args) {

        PN152 solution = new PN152();
        int[] nums = { 2, 3, -2, 4 };
        int result = solution.maxProduct(nums);
        System.out.println(result);
        System.out.println("Expected: 6");

        nums = new int[] { -2, 0, -1 };
        result = solution.maxProduct(nums);
        System.out.println(result);
        System.out.println("Expected: 0");

    }

    public int maxProduct(int[] nums) {

        int highestVal = nums[0], max = nums[0], min = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int val = nums[i];
            int high = nums[i] * max;
            int low = nums[i] * min;

            max = high > low ? high : low;
            max = val > max ? val : max;
            highestVal = max > highestVal ? max : highestVal;

            min = high < low ? high : low;
            min = val < min ? val : min;
        }

        return highestVal;
    }

    public int maxProductOld(int[] nums) {

        int highestVal = nums[0], max = nums[0], min = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int val = nums[i];
            int high = nums[i] * max;
            int low = nums[i] * min;

            max = Math.max(val, Math.max(high, low));
            min = Math.min(val, Math.min(high, low));

            highestVal = Math.max(max, highestVal);
        }

        return highestVal;
    }
}
