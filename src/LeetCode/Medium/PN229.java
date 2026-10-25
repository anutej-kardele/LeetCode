package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class PN229 {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 1, 2, 1 };
        PN229 obj = new PN229();
        System.out.println(Arrays.toString(nums) + " : " + obj.majorityElement(nums));

        int[] nums2 = { 3, 3, 4, 4, 4, 5, 5 };
        System.out.println(Arrays.toString(nums2) + " : " + obj.majorityElement(nums2));

        int[] nums3 = { 3, 2, 3 };
        System.out.println(Arrays.toString(nums3) + " : " + obj.majorityElement(nums3));

        int[] nums4 = { 1 };
        System.out.println(Arrays.toString(nums4) + " : " + obj.majorityElement(nums4));

        int[] nums5 = { 1, 2 };
        System.out.println(Arrays.toString(nums5) + " : " + obj.majorityElement(nums5));
    }

    public List<Integer> majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>(3);

        for (int i = 0; i < nums.length; i++) {

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (map.size() <= 2)
                continue;

            map.forEach((m, c) -> {
                map.put(m, c - 1);
            });
            map.entrySet().removeIf(entry -> entry.getValue() <= 0);
        }

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;

        for (Integer key : map.keySet()) {

            int count = 0;
            for (int num : nums) {
                if (num == key)
                    count++;
            }
            if (count > threshold)
                result.add(key);
        }

        return result;
    }

}
