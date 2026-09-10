package LeetCode.Medium;

import java.util.List;
import java.util.PriorityQueue;

import LeetCode.Easy.PN252.Interval;

public class PN253 {

    public static void main(String[] args) {

    }

    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals == null || intervals.isEmpty())
            return 0;

        // intervals.sort((a, b) -> a.start - b.start);
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        int n = intervals.size();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals.get(0).end);

        for (int i = 1; i < n; i++) {

            if (minHeap.peek() <= intervals.get(i).start)
                minHeap.poll();

            minHeap.offer(intervals.get(i).end);
        }

        return minHeap.size();
    }

}
