package LeetCode.Hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PN1851 {

    public static void main(String[] args) {
        PN1851 solution = new PN1851();
        int[][] intervals = { { 1, 4 }, { 2, 4 }, { 3, 6 }, { 4, 4 } };
        int[] queries = { 2, 3, 4, 5 };
        int[] result = solution.minInterval(intervals, queries);
        // Output: [3,3,1,4]
        System.out.println(java.util.Arrays.toString(result));
        System.out.println("Expected: [3,3,1,4]");

        intervals = new int[][] { { 2, 3 }, { 2, 5 }, { 1, 8 }, { 20, 25 } };
        queries = new int[] { 2, 19, 5, 22 };
        result = solution.minInterval(intervals, queries);
        // Output: [2,-1,4,6]
        System.out.println(java.util.Arrays.toString(result));
        System.out.println("Expected: [2,-1,4,6]");
    }

    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[queries.length];

        int intervalIndex = 0; // Pointer to track how many intervals we have processed so far

        for (int[] q : sortedQueries) {
            int query = q[0];
            int originalIndex = q[1];

            // STEP A: Drop intervals into the heap as the timeline moves forward
            // We only add them if their start time is <= the current query
            while (intervalIndex < intervals.length && intervals[intervalIndex][0] <= query) {
                int size = intervals[intervalIndex][1] - intervals[intervalIndex][0] + 1;
                // Add to heap: [size, end_time]
                minHeap.offer(new int[] { size, intervals[intervalIndex][1] });
                intervalIndex++;
            }

            // STEP B: Aggressively purge dead intervals
            // If the interval at the top of the heap ended before our current query, throw
            // it away.
            // Because our queries are sorted, if it's dead now, it's dead forever. No
            // "hold" list needed!
            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            // STEP C: Record the answer
            // The heap is sorted by size, so the top is guaranteed to be the smallest valid
            // interval
            result[originalIndex] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }

        return result;
    }

}
