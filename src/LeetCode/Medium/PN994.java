package LeetCode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class PN994 {

    public static void main(String[] args) {

        PN994 pn994 = new PN994();
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println("Expected 4 --- Actual " + pn994.orangesRotting(grid));

        grid = new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        System.out.println("Expected -1 --- Actual " + pn994.orangesRotting(grid));

        grid = new int[][] { { 0, 2 } };
        System.out.println("Expected 0 --- Actual " + pn994.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {

        int oneCount = 0, timing = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        // setting up oneCount and queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    oneCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        int gridWidth = grid.length;
        int gridHeight = grid[0].length;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] rottenIndex = queue.poll();
                int w = rottenIndex[0], h = rottenIndex[1];

                if (w + 1 < gridWidth && grid[w + 1][h] == 1) {
                    grid[w + 1][h] = 2;
                    oneCount--;
                    queue.offer(new int[] { w + 1, h });
                }
                if (w - 1 >= 0 && grid[w - 1][h] == 1) {
                    grid[w - 1][h] = 2;
                    oneCount--;
                    queue.offer(new int[] { w - 1, h });
                }
                if (h + 1 < gridHeight && grid[w][h + 1] == 1) {
                    grid[w][h + 1] = 2;
                    oneCount--;
                    queue.offer(new int[] { w, h + 1 });
                }
                if (h - 1 >= 0 && grid[w][h - 1] == 1) {
                    grid[w][h - 1] = 2;
                    oneCount--;
                    queue.offer(new int[] { w, h - 1 });
                }
            }

            if (!queue.isEmpty())
                timing++;
        }

        return oneCount > 0 ? -1 : timing;
    }
}
