package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PN417 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] pacificOcean = new int[rows][cols];
        int[][] atlanticOcean = new int[rows][cols];

        for (int i = 0; i < cols; i++) {

            if (pacificOcean[0][i] == 0)
                dfs(heights, pacificOcean, 0, i, 0);

            if (atlanticOcean[rows - 1][i] == 0)
                dfs(heights, atlanticOcean, rows - 1, i, 0);
        }

        for (int i = 0; i < rows; i++) {

            if (pacificOcean[i][0] == 0)
                dfs(heights, pacificOcean, i, 0, 0);

            if (atlanticOcean[i][cols - 1] == 0)
                dfs(heights, atlanticOcean, i, cols - 1, 0);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (pacificOcean[i][j] == 1 && atlanticOcean[i][j] == 1)
                    result.add(Arrays.asList(i, j));
            }
        }

        return result;
    }

    public void dfs(int[][] heights, int[][] ocean, int i, int j, int val) {

        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || ocean[i][j] == 1)
            return;

        if (heights[i][j] >= val) {
            // valid search more

            ocean[i][j] = 1;

            dfs(heights, ocean, i + 1, j, heights[i][j]);
            dfs(heights, ocean, i - 1, j, heights[i][j]);
            dfs(heights, ocean, i, j + 1, heights[i][j]);
            dfs(heights, ocean, i, j - 1, heights[i][j]);
        }
    }

}
