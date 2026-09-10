package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class PN57 {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };

        // int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        // int[] newInterval = { 4, 8 };

        int[][] output = insert(intervals, newInterval);

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + " " + output[i][1]);
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> output = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            output.add(intervals[i]);
            i++;
        }

        System.out.println("i is : " + i);

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        output.add(newInterval);
        System.out.println("i is : " + i);

        while (i < n) {
            output.add(intervals[i]);
            i++;
        }
        System.out.println("i is : " + i);

        return output.toArray(new int[output.size()][]);
    }

    // public static int[][] insert2(int[][] intervals, int[] newInterval) {

    // int n = intervals.length - 1;

    // boolean hasStart = false;
    // int startIndex = 0;
    // int endIndex = n - 1;
    // boolean hasEnd = false;

    // for (int i = 0; i < intervals.length; i++) {

    // if (hasStart && hasEnd)
    // break;

    // if (!hasStart) {

    // int[] thisInterval = intervals[i];
    // int thisStart = thisInterval[0];
    // int thisEnd = thisInterval[1];

    // if (thisStart <= newInterval[0] && newInterval[0] <= thisEnd) {
    // System.out.println("HAS START | Start: " + thisStart + " --- End: " +
    // thisEnd);
    // startIndex = i;
    // hasStart = true;
    // }
    // }

    // if (!hasEnd) {

    // int[] thisInterval = intervals[n - i];
    // int thisStart = thisInterval[0];
    // int thisEnd = thisInterval[1];

    // if (thisStart <= newInterval[1] && newInterval[1] <= thisEnd) {
    // System.out.println("HAS END | Start: " + thisStart + " --- End: " + thisEnd);
    // endIndex = n - i;
    // hasEnd = true;
    // }
    // }
    // }

    // int sizeNewOutput = startIndex + (n - endIndex) + 1;

    // System.out.println(
    // "Start Index: " + startIndex + " --- End Index: " + endIndex + " --- Output
    // Size: " + sizeNewOutput);

    // List<int[]> output = new ArrayList<>();

    // for (int i = 0; i < startIndex; i++) {
    // output.add(intervals[i]);
    // }

    // int newS = (newInterval[0] < intervals[startIndex][0]) ? newInterval[0] :
    // intervals[startIndex][0];
    // int newE = (newInterval[1] < intervals[startIndex][1]) ? newInterval[1] :
    // intervals[startIndex][1];

    // output.add(new int[] { newS, newE });

    // for (int i = endIndex + 1; i < n; i++) {
    // output.add(intervals[i]);
    // }

    // return output;
    // }
}
