package LeetCode.Hard;

public class PN42 {

    public static void main(String[] args){
    
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        
        System.out.println(TrappingRainWater(height));
    }

    public static int TrappingRainWater(int[] height) {
        
        if(height.length < 3) return 0;

        int leftLargest = Integer.MIN_VALUE;
        int rightLargest = Integer.MIN_VALUE;

        int trapWater = 0;

        for(int i = 1; i < height.length - 1; i++){
            
            leftLargest = Integer.MIN_VALUE;
            rightLargest = Integer.MIN_VALUE;

            for(int j = i; j < height.length; j++){
                if(rightLargest < height[j]) rightLargest = height[j];
            }

            for(int j = i; j >= 0; j--){
                if(leftLargest < height[j]) leftLargest = height[j];
            }

            if(leftLargest > height[i] && rightLargest > height[i]){
                
                if(leftLargest < rightLargest) trapWater += (leftLargest - height[i]);
                else trapWater += (rightLargest - height[i]);
            }
        }

        return trapWater;
    }
    
}
