package LeetCode.Hard;

import java.util.Arrays;

public class PN41 {

    public static void main(String[] args) {
        PN41 obj = new PN41();

        int[] nums = { 3, 4, -1, 1 };
        System.out.println(Arrays.toString(nums) + " First missing positive: " + obj.firstMissingPositive(nums));

        int[] nums2 = { 1, 2, 0 };
        System.out.println(Arrays.toString(nums2) + " First missing positive: " + obj.firstMissingPositive(nums2));

        int[] nums3 = { 7, 8, 9, 11, 12 };
        System.out.println(Arrays.toString(nums3) + " First missing positive: " + obj.firstMissingPositive(nums3));
    }

    public int firstMissingPositive(int[] nums) {

        int length = nums.length;
        int[] arr = new int[length + 1];

        for (int i = 0; i < length; i++) {
            if (nums[i] <= length && nums[i] > 0)
                arr[nums[i]] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0)
                return i;
        }

        return length + 1;
    }
}
