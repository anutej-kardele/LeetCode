package LeetCode.Easy;

public class PN35 {
    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        
        int checker = -1;

        for(int i = nums.length - 1; i >= 0; i--){      // i-- loop used so that we can get the values greater and it will store the lowest gerater value 
            if(nums[i] == target) {
                checker = i;                      // checks for equal if so sets the value and breaks the loop
                break;
            }
            else if(target < nums[i]) checker = i;    // keeps on taking the greater value
        }

        if(checker != -1) return checker;
        else return nums.length;               // if the value is still -1 means it was not equal to target also there was no value greater than this in the array

    }
}
