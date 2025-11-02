package LeetCode.Medium;

public class PN198 {

    public static void main(String[] args) {

        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums));
    }

    // New approach saw on AI
    public static int rob(int[] nums) {

        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int previouseRob = 0, latestRob = 0;
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            temp = Math.max(nums[i] + previouseRob, latestRob);
            previouseRob = latestRob;
            latestRob = temp;
        }

        return latestRob;
    }

    // after removing a maxRob did not get increase in the space complexity on
    // leetcode
    // public static int rob(int[] nums) {

    // if (nums.length == 1)
    // return nums[0];
    // else if (nums.length == 2)
    // return nums[0] < nums[1] ? nums[1] : nums[0];
    // else if (nums.length == 3)
    // return (nums[2] + nums[0]) < nums[1] ? nums[1] : (nums[2] + nums[0]);

    // nums[1] = nums[0] < nums[1] ? nums[1] : nums[0];
    // nums[2] += nums[0];
    // int maxValue = 0;
    // int highestRob = nums[0] < nums[2] ? nums[2] : nums[0];

    // for (int i = 3; i < nums.length; i++) {
    // maxValue = (nums[i - 2] < nums[i - 3]) ? nums[i - 3] : nums[i - 2];
    // nums[i] += maxValue;
    // highestRob = nums[i] < highestRob ? highestRob : nums[i];
    // }

    // return highestRob;
    // }

    // Working fine Leetcode 41.01MB
    // public static int rob(int[] nums) {

    // if (nums.length == 1)
    // return nums[0];
    // else if (nums.length == 2)
    // return nums[0] < nums[1] ? nums[1] : nums[0];
    // else if (nums.length == 3)
    // return (nums[2] + nums[0]) < nums[1] ? nums[1] : (nums[2] + nums[0]);

    // int[] maxRob = new int[nums.length];
    // maxRob[0] = nums[0];
    // maxRob[1] = nums[0] < nums[1] ? nums[1] : nums[0];
    // maxRob[2] = nums[2] + nums[0];
    // int maxValue = 0;
    // int highestRob = maxRob[0] < maxRob[2] ? maxRob[2] : maxRob[0];

    // for (int i = 3; i < nums.length; i++) {
    // maxValue = (maxRob[i - 2] < maxRob[i - 3]) ? maxRob[i - 3] : maxRob[i - 2];
    // maxRob[i] = nums[i] + maxValue;
    // highestRob = maxRob[i] < highestRob ? highestRob : maxRob[i];
    // }

    // return highestRob;
    // }

    // Wrong solution wil fail on [2,1,1,2]
    // public static int rob(int[] nums) {

    // int evenHouse = 0;
    // int oddHouse = 0;

    // for (int i = 0; i < nums.length; i++) {

    // if (i % 2 == 0)
    // evenHouse += nums[i];
    // else
    // oddHouse += nums[i];
    // }

    // return (evenHouse < oddHouse) ? oddHouse : evenHouse;
    // }
}
