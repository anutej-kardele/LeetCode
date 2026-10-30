package LeetCode.Medium;

public class PN287 {

    public static void main(String[] args) {
        PN287 solution = new PN287();
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println("Expected: 2, Actual: " + solution.findDuplicate(nums));

        nums = new int[] { 3, 1, 3, 4, 2 };
        System.out.println("Expected: 3, Actual: " + solution.findDuplicate(nums));

        nums = new int[] { 3, 3, 3, 3, 3 };
        System.out.println("Expected: 3, Actual: " + solution.findDuplicate(nums));
    }

    // Floyd's Tortoise and Hare algorithm in two phases
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect cycle intersection
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        // Phase 2: Find cycle entrance
        int pointer1 = nums[0];
        int pointer2 = slow;

        while (pointer1 != pointer2) {
            pointer1 = nums[pointer1];
            pointer2 = nums[pointer2];
        }

        return pointer1;
    }

    // Approach 1: Memory Array
    public int findDuplicateNExtraMemory(int[] nums) {

        int n = nums.length;
        int[] memory = new int[n];

        for (int i = 0; i < n; i++) {
            int number = nums[i];
            if (memory[number] == 0)
                memory[number] = 1;
            else
                return number;
        }

        return -1;
    }

}
