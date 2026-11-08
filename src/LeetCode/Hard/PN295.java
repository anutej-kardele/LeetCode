package LeetCode.Hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class PN295 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // 2.0
    }
}

class MedianFinder {

    // Min-Heap - Store large values
    PriorityQueue<Integer> biggerNum = new PriorityQueue<>();

    // Max-Heap - Store small values
    PriorityQueue<Integer> smallerNum = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {

    }

    int biggerSize = 0, smallerSize = 0;

    public void addNum(int num) {
        if (biggerSize < smallerSize) {
            // need to add in biggerNum
            int val = smallerNum.peek() != null ? smallerNum.peek() : Integer.MAX_VALUE;

            if (val < num) {
                biggerNum.offer(num);
            } else {
                biggerNum.offer(smallerNum.poll());
                smallerNum.offer(num);
            }
            biggerSize++;
        } else {
            // need to add in smallerNum
            int val = biggerNum.peek() != null ? biggerNum.peek() : Integer.MIN_VALUE;

            if (num < val || biggerNum.isEmpty()) {
                smallerNum.offer(num);
            } else {
                smallerNum.offer(biggerNum.poll());
                biggerNum.offer(num);
            }
            smallerSize++;
        }
    }

    public double findMedian() {
        int size = biggerSize + smallerSize;

        if (size % 2 == 0) {
            return (double) (smallerNum.peek() + biggerNum.peek()) / 2;
        } else {
            if (smallerSize < biggerSize)
                return (double) biggerNum.peek();
            else
                return (double) smallerNum.peek();
        }
    }

    // Opproach with less if condition easy to implement but many logn operations
    // slowers the execution

    // public void addNum(int num) {

    // smallerNum.offer(num);
    // biggerNum.offer(smallerNum.poll());

    // if (smallerNum.size() < biggerNum.size())
    // smallerNum.offer(biggerNum.poll());
    // }

    // public double findMedian() {

    // if (smallerNum.size() > biggerNum.size())
    // return smallerNum.peek();
    // else
    // return (double) (smallerNum.peek() + biggerNum.peek()) / 2;
    // }
}
