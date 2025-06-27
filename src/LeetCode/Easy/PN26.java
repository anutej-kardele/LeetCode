package LeetCode.Easy;

public class PN26 {

    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int value = removeDuplicates(nums);
        System.out.println("Count: " + value);
    }

    public static int removeDuplicates(int[] nums) {
        
        int currentIndex = 0;
        int currentNumber = nums[0];
 
        for(int i = 1; i < nums.length; i++) {
 
            if(nums[i] != currentNumber) {
                currentIndex++;
                nums[currentIndex] = nums[i];
                currentNumber = nums[i];
            }
        }
 
        return currentIndex + 1;
    }
}
