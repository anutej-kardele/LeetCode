package LeetCode.Easy;

import java.util.HashMap;

public class PN169 {
    
    public static void main(String[] args){

        int arr[] = {2,3,1,1,1,3,2};

        System.out.println(MajorityElement(arr));
    }

    public static int MajorityElement(int nums[]){


        HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){
            if(data.containsKey(nums[i])) data.put(nums[i], data.get(nums[i]) + 1);
            else data.put(nums[i], 1);
        }

        int largest = Integer.MIN_VALUE;
        int largestData = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(data.get(nums[i]) > largest) {
                largest = data.get(nums[i]);
                largestData = nums[i];
            }
        }

        return largestData;
    }
}
