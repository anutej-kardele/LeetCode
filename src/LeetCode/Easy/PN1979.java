package LeetCode.Easy;

public class PN1979 {

    public static void main(String[] args) {

        // int[] nums = { 2, 5, 6, 9, 10 };
        // int[] nums = { 7, 5, 6, 8, 3 };
        int[] nums = { 3, 3 };

        int output = findGCD(nums);
        System.out.println(output);
    }

    public static int findGCD(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }

        int divisor = min;
        int divident = max;

        while (divisor > 0) {

            int remainder = divident % divisor;

            divident = divisor;
            divisor = remainder;
        }
        return divident;
    }

}
