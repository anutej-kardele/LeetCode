package LeetCode.Hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class PN84 {

    public static void main(String[] args) {

        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Expected: 10 Output: " + largestRectangleArea(heights));

        heights = new int[] { 2, 4 };
        System.out.println("Expected: 4 Output: " + largestRectangleArea(heights));

        heights = new int[] { 5, 4, 1, 2 };
        System.out.println("Expected: 8 Output: " + largestRectangleArea(heights));

        heights = new int[] { 6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3 };
        System.out.println("Expected: 14 Output: " + largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {

        if (heights.length == 1)
            return heights[0];

        Deque<Integer> height = new ArrayDeque<>();
        Deque<Integer> index = new ArrayDeque<>();

        int maxArea = heights[0];
        height.push(heights[0]);
        index.push(0);

        for (int i = 1; i < heights.length; i++) {

            if (height.isEmpty()) {
                height.push(heights[i]);
                index.push(i);
            } else if (height.peek() < heights[i]) {
                height.push(heights[i]);
                index.push(i);
            } else {

                // if height is less then we calculate index till back till we have greater then
                // equal height
                int indexTill = -1;

                while (!height.isEmpty() && height.peek() >= heights[i]) {
                    indexTill = index.pop();

                    int area = height.pop() * (i - indexTill);
                    maxArea = maxArea < area ? area : maxArea;
                }

                height.push(heights[i]);
                index.push(indexTill);
            }
        }

        while (!height.isEmpty()) {
            int area = height.pop() * (heights.length - index.pop());
            maxArea = maxArea < area ? area : maxArea;
        }

        return maxArea;
    }

    public static int largestRectangleAreaWORKEDSOMEISSUE(int[] heights) {

        if (heights.length == 1)
            return heights[0];

        Deque<Integer> height = new ArrayDeque<>();
        Deque<Integer> index = new ArrayDeque<>();

        int maxArea = heights[0];
        height.push(heights[0]);
        index.push(0);

        for (int i = 1; i < heights.length; i++) {

            if (height.isEmpty()) {
                height.push(heights[i]);
                index.push(i);
                continue;
            }

            if (height.peek() < heights[i]) {
                maxArea = maxArea < heights[i] ? heights[i] : maxArea;
                height.push(heights[i]);
                index.push(i);
            } else {

                // if height is less then we calculate index till back till we have greater then
                // equal height
                int indexTill = -1;
                int area = 0;

                while (!height.isEmpty() && height.peek() >= heights[i]) {
                    height.pop();
                    int ind = index.pop();

                    if (!height.isEmpty()) {
                        area = height.peek() * (ind - index.peek() + 1);
                        maxArea = Math.max(maxArea, area);
                        System.out.println("Area1: " + area + " Index Till: " + index.peek() + " Index From: " + ind
                                + " Height: " + height.peek());
                    }
                    indexTill = ind;
                }

                area = heights[i] * (i - indexTill + 1);
                System.out.println(
                        "Area2: " + area + " Index Till: " + indexTill + " Index From: " + i + " Height: "
                                + heights[i]);

                maxArea = maxArea < area ? area : maxArea;
                height.push(heights[i]);
                index.push(indexTill);
            }
        }

        while (!height.isEmpty()) {
            int val = height.pop();
            int ind = index.pop();

            int area = val * (heights.length - ind);

            System.out.println(
                    "Area3: " + area + " Index Till: " + ind + " Index From: " + (heights.length - 1) + " Height: "
                            + val);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

}
