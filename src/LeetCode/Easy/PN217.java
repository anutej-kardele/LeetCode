package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

public class PN217 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        // int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        System.out.println(containsDuplicate(nums));
    }

    // Beats 89% only
    public static boolean containsDuplicate(int[] nums) {

        if (nums.length == 1)
            return false;

        Set<Integer> num = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            num.add(nums[i]);
            if ((i + 1) != num.size())
                return true;
        }

        return false;
    }
}
