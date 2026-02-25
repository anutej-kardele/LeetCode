package LeetCode.Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import LeetCode.Helper;

public class PN15 {

    public static void main(String[] args) {

        // int[] nums = { -1, 0, 1, 2, -1, -4 };
        // int[] nums = { 0, 1, 1 };
        // int[] nums = { 0, 0, 0 };
        // int[] nums = { 0, 0, 0, 0 };
        // int[] nums = { 2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10 };
        int[] nums = { 2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10 }; // [[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]

        PN15 sc = new PN15();
        System.out.println(sc.threeSum3(nums));
        System.out.println("---");
        System.out.println(sc.threeSum2(nums));

    }

    public List<List<Integer>> threeSum3(int[] nums) {

        if (nums.length < 3)
            return null;

        sort(nums);
        Set<List<Integer>> store = new HashSet<>();

        int sum, l, r;

        for (int i = 0; i < nums.length - 2; i++) {
            l = i + 1;
            r = nums.length - 1;

            while (l < r) {

                sum = nums[i] + nums[l] + nums[r];

                if (sum == 0) {
                    store.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum > 0)
                    r--;
                else
                    l++;
            }
        }

        List<List<Integer>> toReturn = new ArrayList<>(store);

        return toReturn;
    }

    public List<List<Integer>> threeSum2(int[] nums) {

        if (nums.length < 3)
            return null;

        List<List<Integer>> toReturn = new ArrayList<>();
        // Arrays.sort(nums);
        sort(nums);

        int LastChecked = Integer.MIN_VALUE;
        int sum, l, r;

        for (int i = 0; i < nums.length - 2; i++) {

            if (LastChecked == nums[i]) {
                // System.out.println("Continue: " + nums[i]);
                continue;
            }

            LastChecked = nums[i];
            if (LastChecked > 0)
                return toReturn;

            l = i + 1;
            r = nums.length - 1;

            while (l < r) {

                if ((l - 1) > i && nums[l - 1] == nums[l]) {
                    l++;
                    continue;
                } else if ((r + 1) < nums.length && nums[r + 1] == nums[r]) {
                    r--;
                    continue;
                }

                sum = nums[i] + nums[l] + nums[r];

                if (sum == 0) {
                    toReturn.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum > 0)
                    r--;
                else
                    l++;
            }
        }

        return toReturn;
    }

    int[] aux;

    private void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0, arr.length);
    }

    private void sort(int[] arr, int low, int high) {
        if (low + 1 < high) {
            int mid = low + (high - low) / 2;

            sort(arr, low, mid);
            sort(arr, mid, high);

            merge(arr, low, high);
        }
    }

    private void merge(int[] arr, int low, int high) {
        int l = low, mid = low + (high - low) / 2, m = mid, n = high - low;

        for (int i = 0; i < n; i++) {
            if (l == mid) {
                aux[i] = arr[m++];
            } else if (m == high) {
                aux[i] = arr[l++];
            } else if (arr[l] <= arr[m]) {
                aux[i] = arr[l++];
            } else {
                aux[i] = arr[m++];
            }
        }

        for (int i = 0; i < n; i++) {
            arr[low + i] = aux[i];
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> toReturn = new ArrayList<>();
        Arrays.sort(nums);
        // Helper.PrintArray(nums, "Nums");
        int LastChecked = Integer.MIN_VALUE;
        int LastCheckedIndex = -1;

        while (LastCheckedIndex < (nums.length - 1)) {
            // System.out.println(LastChecked + " ---- " + nums[LastCheckedIndex + 1]);
            if (LastChecked == nums[LastCheckedIndex + 1]) {
                LastCheckedIndex++;
                continue;
            }
            // System.out.println("Executing");

            LastCheckedIndex++;
            LastChecked = nums[LastCheckedIndex];

            if (LastChecked > 0) {
                break;
            }

            HashMap<Integer, Integer> dict = new HashMap<>();
            // List<Integer> dict = new ArrayList<>();

            int skipNumber = Integer.MIN_VALUE;

            for (int i = LastCheckedIndex + 1; i < nums.length; i++) {

                if (skipNumber == nums[i])
                    continue;

                int add = nums[LastCheckedIndex] + nums[i];
                int difference = (add < 0) ? Math.abs(add) : add * -1;
                // System.out.println("AAA " + nums[LastCheckedIndex] + " | " + nums[i] + " | "
                // + difference);
                // System.out.println("Dict: " + dict);
                // System.out.println(dict.containsKey(difference));
                if (dict.containsKey(difference)) {
                    // System.out.println("Difference: " + difference);
                    List<Integer> combine = new ArrayList<>();
                    combine.add(nums[LastCheckedIndex]);
                    combine.add(difference);
                    combine.add(nums[i]);
                    // System.out.println("Adding: " + combine);
                    toReturn.add(combine);
                    // dict.remove(dict.get(difference));
                    dict.remove(difference);
                    if (nums[i] == difference)
                        skipNumber = difference;
                } else
                    dict.put(nums[i], i);
            }

        }

        return toReturn;
    }

}
