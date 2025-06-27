package LeetCode.Easy;
import java.util.*;

public class PN1 {
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> dict = new HashMap<>();
        int[] value = new int[2];

        for(int i = 0; i < nums.length; i++){
            int difference = target - nums[i];

            if(dict.containsKey(difference)){
                value[0] = dict.get(difference);
                value[1] = i;
                return value;
            }
            dict.put(nums[i], i);
        }

        return value;
    }

    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] value = twoSum(nums, target);
        System.out.println("[" + value[0] + ", " + value[1] + "]");
    }
}
