package LeetCode.Easy;

public class PN724 {

    public static void main(String[] args) {
        
        //int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums = {-1,-1,-1,-1,-1,-1};

        System.out.println(pivotIndex(nums));
    }


    public static int pivotIndex(int[] nums) {
        
        int leftSum = 0;
        int rightSum = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            for(int j = 0; j < nums.length; j++){
                
                if(j < i) leftSum += nums[j];
                if(j > i) rightSum += nums[j];

            }
            
            if(leftSum == rightSum) return i;

            leftSum = 0;
            rightSum = 0;
        }

        return -1;
    }
}
