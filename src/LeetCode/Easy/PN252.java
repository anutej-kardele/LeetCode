package LeetCode.Easy;

import java.util.List;

public class PN252 {

    public static void main(String[] args) {

        // int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        // System.out.println(canAttendMeetings(new
        // IntervalList(intervals).getIntervals()));
    }

    public static boolean canAttendMeetings(List<Interval> intervals) {

        if (intervals == null || intervals.isEmpty())
            return true;

        intervals.sort((a, b) -> a.end - b.end);

        int n = intervals.size();
        int currentLimit = intervals.get(0).end;

        for (int i = 1; i < n; i++) {

            if (currentLimit <= intervals.get(i).start) {
                currentLimit = intervals.get(i).end;
            } else {
                return false;
            }
        }

        return true;
    }

    public class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
