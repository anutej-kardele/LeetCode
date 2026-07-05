package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PN347 {

    public static void main(String[] args) {

        int[] nums = { 1, 3, 1, 3, 1, 3, 2, 1, 2, 3 };
        System.out.println(topKFrequent(nums, 2));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i], 0) + 1);
        }

        List<HashMap.Entry<Integer, Integer>> list = new ArrayList<>(hashmap.entrySet());

        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println(list.toString());

        int[] output = new int[k];

        for (int i = 0; i < k; i++) {
            output[i] = list.get(i).getKey();
        }

        return output;
    }
}
