package LeetCode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class PN739 {

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = dailyTemperatures(temperatures);
        System.out.println("Expected: [1, 1, 4, 2, 1, 1, 0, 0] Output: " + java.util.Arrays.toString(result));
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> index = new ArrayDeque<>();

        int[] output = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {

            while (!deque.isEmpty()) {

                if (temperatures[i] < deque.peek())
                    break;

                deque.pop();
                index.pop();
            }

            output[i] = index.isEmpty() ? 0 : index.peek() - i;
            deque.push(temperatures[i]);
            index.push(i);
        }

        return output;
    }

}
