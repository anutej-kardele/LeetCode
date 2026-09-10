package LeetCode.Medium;

import java.util.Arrays;

public class PN435 {

    public static void main(String[] args) {
        // int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        // int[][] intervals = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
        int[][] intervals = { { 1, 2 }, { 2, 3 } };

        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int n = intervals.length;
        int drop = 0;
        int currentLimit = intervals[0][1];

        for (int i = 1; i < n; i++) {

            if (currentLimit <= intervals[i][0]) {
                currentLimit = intervals[i][1];
            } else {
                drop++;
            }
        }

        return drop;
    }
}
