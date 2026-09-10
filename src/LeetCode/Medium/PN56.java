package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PN56 {

    public static void main(String[] args) {

        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

        int[][] output = merge(intervals);

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + " " + output[i][1]);
        }
    }

    public static int[][] merge(int[][] intervals) {

        // Stack<int[]> stack = new Stack<>();
        List<int[]> output = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        output.add(intervals[i]);
        i++;

        while (i < n) {

            // get prev interval
            int[] prev = output.get(output.size() - 1);

            // get curr interval
            int[] curr = intervals[i];

            if (prev[1] >= curr[0])
                prev[1] = Math.max(prev[1], curr[1]);
            else
                output.add(curr);

            i++;
        }

        return output.toArray(new int[output.size()][]);
    }
}
