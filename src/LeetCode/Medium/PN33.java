package LeetCode.Medium;

public class PN33 {

    public static void main(String[] args) {

        // int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        // int target = 3;
        // int target = 0;
        // int[] nums = { 7, 1, 2, 3, 4, 5, 6 };
        // int target = 7;
        // int[] nums = { 1, 2 };
        // int target = 0;
        // int[] nums = { 5, 1, 2, 3, 4 };
        // int target = 1;

        // int[] nums = { 8, 9, 2, 3, 4 };
        // int target = 9;
        int[] nums = { 4, 5, 6, 7, 8, 1, 2, 3 };
        int target = 8;

        // int[] nums = { 1 };
        // int target = 1;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {

        if (nums.length == 1 && target == nums[0])
            return 0;

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            // System.out.println("Left: (" + nums[left] + ") " + left + " --- Mid: (" +
            // nums[mid] + ") " + mid
            // + " --- Right: (" + nums[right] + ") " + right);

            if (nums[mid] == target)
                return mid;
            else if (nums[left] <= nums[mid]) { // left is ordered
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else { // right is ordered
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }

        }

        return -1;
    }
}
