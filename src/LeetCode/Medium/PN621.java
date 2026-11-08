package LeetCode.Medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PN621 {

    public static void main(String[] args) {
        PN621 solution = new PN621();
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println("Expected: 8, Actual: " + solution.leastInterval(tasks, n)); // 8

        tasks = new char[] { 'A', 'C', 'A', 'B', 'D', 'B' };
        n = 1;
        System.out.println("Expected: 6, Actual: " + solution.leastInterval(tasks, n)); // 6

        tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
        n = 3;
        System.out.println("Expected: 10, Actual: " + solution.leastInterval(tasks, n)); // 10
    }

    public int leastInterval(char[] tasks, int n) {

        int[] frequencies = new int[26];
        int maxFrequency = 0;

        // Find frequencies and track the highest single frequency
        for (char task : tasks) {
            frequencies[task - 'A']++;
            maxFrequency = Math.max(maxFrequency, frequencies[task - 'A']);
        }

        // Count how many tasks tie for that absolute highest frequency
        int maxCountTasks = 0;
        for (int count : frequencies)
            if (count == maxFrequency)
                maxCountTasks++;

        // The Formula: (Chunks) * (Chunk Size) + (Tying Max Tasks at the end)
        int calculatedTime = (maxFrequency - 1) * (n + 1) + maxCountTasks;

        // If calculated time is less than tasks.length, we had zero idle time.
        return Math.max(calculatedTime, tasks.length);
    }

    public int leastIntervalHeap(char[] tasks, int n) {

        int[] frequencies = new int[26];
        for (char task : tasks)
            frequencies[task - 'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : frequencies)
            if (count > 0)
                maxHeap.offer(count);

        int currentTime = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Loop continues as long as there are tasks to process in EITHER the heap or
        // the waiting room
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {

            currentTime++;

            if (!maxHeap.isEmpty()) {
                // "Max heap polls and executes the task - Add remaining task to the queue"
                int currentCount = maxHeap.poll();
                currentCount--;
                if (currentCount > 0)
                    queue.offer(new int[] { currentCount, currentTime + n });
            }

            // When we have a task ready, add it back to the heap
            if (!queue.isEmpty() && queue.peek()[1] == currentTime)
                maxHeap.offer(queue.poll()[0]);

            // OPTIMIZATION (When heap is empty)
            // Skip to timeStamp where we add the task back to the heap
            if (maxHeap.isEmpty() && !queue.isEmpty())
                currentTime = queue.peek()[1] - 1;

        }

        return currentTime;
    }

    // Slow solution using a priority queue to calculate the least interval.
    public int leastIntervalSLOW(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        n++;

        for (char task : tasks) {

            if (!map.containsKey(task)) {
                map.put(task, 1);
                minHeap.offer(0);
            } else {
                int currentValue = map.get(task);
                int calculatedExecutionTime = currentValue * n;

                map.put(task, currentValue + 1);
                minHeap.offer(calculatedExecutionTime);
            }
        }

        int currentTime = 0;

        while (!minHeap.isEmpty()) {

            int executionTime = minHeap.poll();

            if (executionTime > currentTime)
                currentTime += executionTime - currentTime;
            currentTime++;
        }

        return currentTime;
    }
}
