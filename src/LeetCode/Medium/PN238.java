package LeetCode.Medium;

import java.util.Arrays;

public class PN238 {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4 };
        // int[] nums = { -1, 1, 0, -3, 3 };
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        leftProduct[0] = nums[0];
        rightProduct[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i];
        }

        int[] output = new int[nums.length];

        output[0] = rightProduct[1];
        output[nums.length - 1] = leftProduct[nums.length - 2];

        for (int i = 1; i < nums.length - 1; i++) {
            output[i] = leftProduct[i - 1] * rightProduct[i + 1];
        }

        return output;
    }

    // O(N^2) solution --- shit
    // public static int[] productExceptSelf(int[] nums) {

    // int[] products = new int[nums.length];

    // // Initialization
    // for (int i = 0; i < nums.length; i++) {
    // products[i] = (i == 0) ? nums[1] : nums[0];
    // }

    // for (int i = 1; i < nums.length; i++) {

    // int val = nums[i];

    // for (int j = 0; j < nums.length; j++) {

    // if (i == 1 && j == 0)
    // continue;

    // if (i != j) {
    // products[j] *= val;
    // }
    // }
    // }

    // return products;
    // }
}
