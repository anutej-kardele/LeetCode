package LeetCode.Medium;

import java.util.Arrays;

public class PN853 {

    public static void main(String[] args) {

        int target = 12;
        int[] position = { 10, 8, 0, 5, 3 }, speed = { 2, 4, 1, 1, 3 };
        System.out.println("Expected: 3 Output: " + carFleet(target, position, speed));

        target = 10;
        position = new int[] { 3 };
        speed = new int[] { 3 };
        System.out.println("Expected: 1 Output: " + carFleet(10, position, speed));

        target = 100;
        position = new int[] { 0, 2, 4 };
        speed = new int[] { 4, 2, 1 };
        System.out.println("Expected: 1 Output: " + carFleet(100, position, speed));

        target = 10;
        position = new int[] { 0, 4, 2 };
        speed = new int[] { 2, 1, 3 };
        System.out.println("Expected: 1 Output: " + carFleet(target, position, speed));

    }

    public static int carFleet(int target, int[] position, int[] speed) {

        // combining the data and sorting it
        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        // checking the fleets
        int fleets = 0;
        double slowestArrivalTime = 0;

        for (int i = position.length - 1; i >= 0; i--) {

            // time = distance / speed
            // current end time
            double currentEndTime = (double) (target - cars[i][0]) / cars[i][1];

            if (currentEndTime > slowestArrivalTime) {
                fleets++;
                slowestArrivalTime = currentEndTime;
            }

        }

        return fleets;
    }

}
