package LeetCode.Medium;

import java.util.Arrays;

public class PN75 {

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        //sortColorsBubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColorsBubbleSort(int[] nums) {

        for(int k = 0; k < nums.length; k++){
            for(int i = 0; i < nums.length - 1; i++){
                if(nums[i] > nums[i + 1]){
                    // sort 
                    int temp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = temp;
                }
            }

        }

        
    }

    public static void sortColors(int[] nums) {

        boolean sorted = false;

        while (!sorted) {

            boolean checkSorted = true;

            for(int i = 0; i < nums.length - 1; i++){
                if(nums[i] > nums[i + 1]){
                    // sort 
                    int temp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = temp;

                    checkSorted = false;
                }
            }

            if(checkSorted) sorted = true; 
        }

        
    }

}
