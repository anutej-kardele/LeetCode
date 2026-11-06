package LeetCode.Medium;

import java.util.PriorityQueue;

public class PN215 {

    public static void main(String[] args) {

        PN215 solution = new PN215();
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println("Expected: 5 -- Output: " + solution.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {

        int[] freq = new int[20001];

        for (int num : nums)
            freq[num + 10000]++;

        for (int i = 20000; i >= 0; i--) {
            k -= freq[i];

            if (k <= 0)
                return i - 10000;
        }

        return 0;
    }

    // This is a slow solution using a min-heap of size k
    public int findKthLargestSLOW(int[] nums, int k) {
        minHeap = new PriorityQueue<>(k + 1);

        for (int i = 0; i < nums.length; i++)
            add(nums[i], k);

        return minHeap.peek();
    }

    PriorityQueue<Integer> minHeap;

    public void add(int val, int k) {

        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
    }
}
