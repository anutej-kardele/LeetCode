package LeetCode.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PN560 {

    public static void main(String[] args) {
        PN560 obj = new PN560();
        int[] nums = { 1, 1, 1 };
        int k = 2;
        System.out.println(Arrays.toString(nums) + " Result: " +
                obj.subarraySum(nums, k));

        int[] nums2 = { 1, 2, 3 };
        int k2 = 3;
        System.out.println(Arrays.toString(nums2) + " Result: " +
                obj.subarraySum(nums2, k2));

        int[] nums3 = { -1, -1, 1 };
        int k3 = 0;
        System.out.println(Arrays.toString(nums3) + " Result: " +
                obj.subarraySum(nums3, k3));

        int[] nums4 = { 1, -1, 0 };
        int k4 = 0;
        System.out.println(Arrays.toString(nums4) + " Result: " + obj.subarraySum(nums4, k4));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        for (int n : nums) {
            sum += n;
            int diff = sum - k;

            count += prefixSums.getOrDefault(diff, 0);
            prefixSums.put(sum, 1 + prefixSums.getOrDefault(sum, 0));
        }

        return count;
    }

    public int subarraySumNSquareTimeComplexity(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            int remaining = k - nums[i];
            int index = i;

            while (index >= 0) {
                if (remaining == 0)
                    count += 1;

                if (index <= 0)
                    break;
                // remove next elem
                remaining -= nums[--index];
            }

        }

        return count;
    }

    public int subarraySumOLD_WorksForOnlyPositiveNumbers(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > k)
                break;

            int remaining = k - nums[i];
            int index = i;

            while (remaining >= 0) {
                if (remaining == 0) {
                    count += 1;
                    break;
                }

                if (index <= 0)
                    break;
                // remove next elem
                remaining -= nums[--index];
            }

        }

        return count;
    }
}
