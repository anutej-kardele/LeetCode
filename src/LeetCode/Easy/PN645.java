package LeetCode.Easy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PN645 {


    public static void main(String[] args){

        //int[] nums = {1,2,2,4};
        //int[] nums = {1,1};
        int[] nums = {3,2,2};

        System.out.println("Mismatch are : " + Arrays.toString(findErrorNumsUsing2DArray(nums)));
        // System.out.println("Mismatch are : " + Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNumsUsing2DArray(int[] nums){

        int[] dup = new int[2];

        // use 2d array 

        int[][] arr = new int[nums.length][2];

        for(int i = 0; i < nums.length; i++){
            arr[i][0] = i + 1;
            arr[nums[i] - 1][1] += 1;
        }


        for(int i = 0; i < nums.length; i++){
            if(arr[i][1] == 2) dup[0] = arr[i][0];
            if(arr[i][1] == 0) dup[1] = arr[i][0];
        }
        
        System.out.println(Arrays.deepToString(arr));

        return dup;
    }

    public static int[] findErrorNums(int[] nums) {
        
        int[] dup = new int[2];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // setting all values to 0 
        for(int i = 1; i <= nums.length; i++){
            map.put(i, 0);
        }

        System.out.println("HashMap Zero :  " + map);

        // Calculating instances 
        for(int i = 1; i <= nums.length; i++){
            map.put(nums[i - 1], map.get(nums[i - 1]) + 1);
        }

        System.out.println("HashMap :  " + map);
        
        // converting to set 
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        System.out.println("Set : " + entrySet);

        // checking for values that have 0 & 2 instances 
        for(Map.Entry<Integer, Integer> entry : entrySet){
            
            if(entry.getValue() == 2) dup[0] = entry.getKey();
            if(entry.getValue() == 0) dup[1] = entry.getKey(); 
        }

        return dup;
    }
}
