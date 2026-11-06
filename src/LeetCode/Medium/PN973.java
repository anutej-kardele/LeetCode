package LeetCode.Medium;

import java.util.PriorityQueue;

public class PN973 {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < points.length; i++) {

            int x = points[i][0];
            int y = points[i][1];
            int distance = (x * x) + (y * y);

            if (minHeap.size() < k) {
                minHeap.offer(new int[] { distance, x, y });
            } else if (distance < minHeap.peek()[0]) {
                minHeap.poll();
                minHeap.offer(new int[] { distance, x, y });
            }
        }

        int[][] output = new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] val = minHeap.poll();

            output[i][0] = val[1];
            output[i][1] = val[2];
        }

        return output;
    }
}
