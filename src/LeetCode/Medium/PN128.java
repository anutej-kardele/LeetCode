package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;

public class PN128 {

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int highestSequence = 0;

        for (int val : nums) {

            if (!set.contains(val - 1)) {

                int lastValue = val;
                int currentSequence = 1;

                while (set.contains(lastValue + 1)) {
                    lastValue += 1;
                    currentSequence += 1;
                }

                highestSequence = Math.max(highestSequence, currentSequence);

                if (highestSequence > nums.length / 2) {
                    break;
                }
            }
        }

        return highestSequence;
    }

    // public static int longestConsecutive(int[] nums) {

    // if (nums.length == 0)
    // return 0;
    // Arrays.sort(nums);

    // int lastValue = nums[0];
    // int highestSequence = 1;
    // int currentSequence = 1;

    // for (int i = 1; i < nums.length; i++) {

    // if (nums[i] == lastValue)
    // continue;
    // else if (nums[i] == lastValue + 1) {

    // // sequence
    // lastValue = nums[i];
    // currentSequence += 1;

    // if (currentSequence > highestSequence)
    // highestSequence = currentSequence;
    // } else {
    // // Reset
    // lastValue = nums[i];
    // currentSequence = 1;
    // }
    // }

    // return highestSequence;
    // }
}
