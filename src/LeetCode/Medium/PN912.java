package LeetCode.Medium;

public class PN912 {

    public static void main(String[] args) {

    }

    public int[] sortArray(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int indicator = nums[i];
            int iteration = i - 1;

            while (iteration >= 0 && nums[iteration] > indicator) {
                nums[iteration + 1] = nums[iteration];
                iteration -= 1;
            }
            nums[iteration + 1] = indicator;
        }
        return nums;
    }
}
