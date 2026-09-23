package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class PN169 {

    public static void main(String[] args) {

        int arr[] = { 2, 3, 1, 1, 1, 3, 2 };

        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {

        int count = 0;
        int number = 0;

        for (int i = 0; i < nums.length; i++) {

            if (count == 0)
                number = nums[i];

            if (number == nums[i])
                count++;
            else
                count--;
        }

        return number;
    }

    public static int majorityElementOld(int[] nums) {

        int currentHighestCont = 0;
        int currentHighestNumber = 0;

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);

            if (frequencyMap.get(nums[i]) > currentHighestCont) {
                currentHighestCont = frequencyMap.get(nums[i]);
                currentHighestNumber = nums[i];
            }
        }

        return currentHighestNumber;
    }

    public static int MajorityElement1(int nums[]) {

        HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (data.containsKey(nums[i]))
                data.put(nums[i], data.get(nums[i]) + 1);
            else
                data.put(nums[i], 1);
        }

        int largest = Integer.MIN_VALUE;
        int largestData = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (data.get(nums[i]) > largest) {
                largest = data.get(nums[i]);
                largestData = nums[i];
            }
        }

        return largestData;
    }
}
