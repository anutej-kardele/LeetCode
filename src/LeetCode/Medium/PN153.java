package LeetCode.Medium;

public class PN153 {

    public static void main(String[] args) {

        // int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        // int[] nums = { 7, 1, 2, 3, 4, 5, 6 };
        int[] nums = { 1, 2 };
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            // System.out.println("Mid: " + mid);
            if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[left] < nums[right]) {
                right = mid;
            } else
                left = mid + 1;

            // System.out.println("Left: " + left + " --- Right: " + right + " --- Mid: " +
            // mid);
            // System.out.println("Left: " + nums[left] + " --- Right: " + nums[right] + "
            // --- Mid: " + nums[mid]);
        }

        return (nums[left] < nums[right]) ? nums[left] : nums[right];
    }
}
