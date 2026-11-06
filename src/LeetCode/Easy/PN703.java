package LeetCode.Easy;

import java.util.PriorityQueue;

public class PN703 {

    public static void main(String[] args) {

        KthLargest solution = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        System.out.println(solution.add(3));
        System.out.println(solution.add(5));
        System.out.println(solution.add(10));
        System.out.println(solution.add(9));
        System.out.println(solution.add(4));
    }
}

class KthLargest {

    PriorityQueue<Integer> minHeap;
    int size = 0;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>(k + 1);
        size = k;

        for (int i = 0; i < nums.length; i++)
            add(nums[i]);
    }

    public int add(int val) {

        if (minHeap.size() < size) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();
    }
}