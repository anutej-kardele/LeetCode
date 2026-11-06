package LeetCode.Easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class PN1046 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++)
            maxHeap.offer(stones[i]);

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 == stone2)
                continue;

            maxHeap.offer(stone1 - stone2);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

}
