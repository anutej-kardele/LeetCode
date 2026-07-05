package LeetCode.Medium;

public class PN11 {

    public static void main(String[] args) {

        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 }; // 49

        System.out.println("Max Area : " + maxArea(height));
    }

    public static int maxArea(int[] height) {

        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxArea = 0;

        while (leftPointer < rightPointer) {

            int leftHeight = height[leftPointer];
            int rightHeight = height[rightPointer];

            // Calculate area and check
            int length = leftHeight < rightHeight ? leftHeight : rightHeight;
            int area = length * (rightPointer - leftPointer);

            maxArea = area > maxArea ? area : maxArea;

            if (leftHeight < rightHeight)
                while (leftPointer < rightPointer && height[leftPointer] <= leftHeight)
                    leftPointer++;
            else
                while (leftPointer < rightPointer && height[rightPointer] <= rightHeight)
                    rightPointer--;
        }

        return maxArea;
    }
}
