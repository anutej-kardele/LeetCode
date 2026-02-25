package LeetCode;

public class Helper {

    public static void PrintArray(int[] nums) {

        String str = "[ ";
        for (int i = 0; i < nums.length; i++) {
            str += nums[i] + (((nums.length - 1) == i) ? " ]" : ", ");
        }
        System.out.println(str);

    }

    public static void PrintArray(int[] nums, String identifier) {

        String str = identifier + ": [ ";
        for (int i = 0; i < nums.length; i++) {
            str += nums[i] + (((nums.length - 1) == i) ? " ]" : ", ");
        }
        System.out.println(str);

    }
}
