package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class PN219 {

    public static void main(String[] args){

        // int[] nums = {1,2,3,1};
        // int k = 3;

        // int[] nums = {1,0,1,1};
        // int k = 1;

        int[] nums = {1,2,3,1,2,3};
        int k = 2;

        System.out.println(containsNearbyDuplicate(nums, k));

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){

            if(!map.containsKey(nums[i])) map.put(nums[i], i);
            else if(Math.abs(i - map.get(nums[i])) <= k) {

                System.out.println("Index : " + i + " --- mapIndex : " + map.get(nums[i]) + " --- k : " + k);
                return true;
            }
            else map.put(nums[i], i);
        }

        return false;
    }
    
}
