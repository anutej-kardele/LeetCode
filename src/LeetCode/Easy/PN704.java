package LeetCode.Easy;

public class PN704 {

    public static void main(String[] args) {

        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 121;

        System.out.println("9 is found at index: " + search(nums, target));
    }

    public static int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int search;

        while (start <= end) {

            search = (start + end) / 2;

            if (target == nums[search])
                return search;
            else if (nums[search] < target)
                start = search + 1;
            else
                end = search - 1;
        }

        return -1;
    }
}
