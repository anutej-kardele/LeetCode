package LeetCode.Hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PN239 {

    public static void main(String[] args) {

        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] output = { 3, 3, 5, 5, 6, 7 };
        int[] val = maxSlidingWindow(nums, k);
        System.out.println(
                "Expected: " + Arrays.toString(output) + " Actual: " + Arrays.toString(val));

        nums = new int[] { 1 };
        k = 1;
        output = new int[] { 1 };
        val = maxSlidingWindow(nums, k);
        System.out.println(
                "Expected: " + Arrays.toString(output) + " Actual: " + Arrays.toString(val));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] output = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        // int l = 0, r = k - 1;

        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();

            deque.offerLast(i);
        }

        output[0] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++) {

            // decrease first value from window
            if (deque.peekFirst() == i - k)
                deque.pollFirst();

            // add new value to window
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();

            deque.offerLast(i);

            // store the new window size
            output[i - k + 1] = nums[deque.peekFirst()];
        }

        return output;
    }

    // WRONG UNDERSTANDING - this calculates sum, not maximum
    public static int[] maxSlidingWindowWRONG(int[] nums, int k) {

        int[] output = new int[nums.length - k + 1];

        // initialize the window
        int windowSize = 0;
        int l = 0, r = k - 1;

        for (int i = 0; i < k; i++) {
            windowSize += nums[i];
        }

        output[0] = windowSize;

        for (int i = 1; i < output.length; i++) {

            // decrease first value from window
            windowSize -= nums[l++];

            // add new value to window
            windowSize += nums[r++];

            // store the new window size
            output[i] = windowSize;
        }

        return output;
    }

}
