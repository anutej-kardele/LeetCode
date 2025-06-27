package LeetCode.Easy;
import java.util.Arrays;

public class PN283 {

    public static void Swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }

    public static void main(String[] args) {
        //int[] nums = {0, 1, 0, 3, 12};
        int[] nums = {1,0};
        //int[] nums = {4,0,2,6,0};
        
        // This approach is n^2 complexity 

        //for(int i = nums.length - 1; i >= 0; i--) {
        //    if(nums[i] == 0)LeftShilft(nums, i);
        //}

        // n complexity - zero at last -- pointer approach 

        int i = 0;
        int j = 1;
        int temp;

        while ( j < nums.length) {
            
            if(nums[i] == 0 && nums[j] != 0){
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                i++;
                j++;
            }
            else if (nums[i] == 0 && nums[j] == 0) {
                j++;
            }
            else {
                j++;
                i++;
            }
        }

        

        // using a new array to store the data 

        // int lastindex = nums.length - 1;
        // int firstIndex= 0;

        // int[] arr2 = new int[nums.length];

        // for(int i = 0; i < nums.length; i++){


        //     if(nums[i] == 0){
        //         arr2[lastindex] = nums[i];
        //         lastindex--;
        //     }
        //     else{
        //         arr2[firstIndex] = nums[i];
        //         firstIndex++;
        //     }
        // }

        // nums = arr2;

        System.out.println(Arrays.toString(nums));

    }

    public static int[] LeftShilft(int[] arr, int end){

        int temp = arr[end];
        
        for(int i = arr.length - 1; i >= end; i--){
            int val = arr[i];
            arr[i] = temp;
            temp = val;
        }

        return arr;
    }
}
