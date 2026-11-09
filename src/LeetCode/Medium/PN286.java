package LeetCode.Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PN286 {

    public static void main(String[] args) {

        int[][] input = new int[][] {
                { 2147483647, -1, 0, 2147483647 },
                { 2147483647, 2147483647, 2147483647, -1 },
                { 2147483647, -1, 2147483647, -1 },
                { 0, -1, 2147483647, 2147483647 }
        };

        int[][] output = new int[][] {
                { 3, -1, 0, 1 },
                { 2, 2, 1, -1 },
                { 1, -1, 2, -1 },
                { 0, -1, 3, 4 }
        };

        PN286 solution = new PN286();
        solution.islandsAndTreasure(input);
        System.out.println("IsEqual: " + java.util.Arrays.deepEquals(input, output));
        System.out.println("--------------------------------");

        System.out.println("Expected Output:");
        for (int[] row : output) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nActual Output:");
        for (int[] row : input) {
            System.out.println(Arrays.toString(row));
        }

    }

    public void islandsAndTreasure(int[][] grid) {

        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 0)
                    queue.offer(new int[] { i, j });
            }
        }

        int distance = 0;
        int gridWidth = grid.length;
        int gridHeight = grid[0].length;
        int inf = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {

            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {

                int[] treasure = queue.poll();
                int w = treasure[0], h = treasure[1];

                if (w + 1 < gridWidth && grid[w + 1][h] == inf) {
                    grid[w + 1][h] = Math.min(grid[w + 1][h], distance);
                    queue.offer(new int[] { w + 1, h });
                }
                if (w - 1 >= 0 && grid[w - 1][h] == inf) {
                    grid[w - 1][h] = Math.min(grid[w - 1][h], distance);
                    queue.offer(new int[] { w - 1, h });
                }
                if (h + 1 < gridHeight && grid[w][h + 1] == inf) {
                    grid[w][h + 1] = Math.min(grid[w][h + 1], distance);
                    queue.offer(new int[] { w, h + 1 });
                }
                if (h - 1 >= 0 && grid[w][h - 1] == inf) {
                    grid[w][h - 1] = Math.min(grid[w][h - 1], distance);
                    queue.offer(new int[] { w, h - 1 });
                }
            }
        }
    }

}
