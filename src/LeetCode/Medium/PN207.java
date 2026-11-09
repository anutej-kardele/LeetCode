package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class PN207 {

    public static void main(String[] args) {

        System.out.println("Expected false, Actual " + canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));

        System.out.println("Expected true, Actual " + canFinish(2, new int[][] { { 1, 0 } }));
    }

    @SuppressWarnings("unchecked")
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<>();

        for (int[] pre : prerequisites)
            adj[pre[0]].add(pre[1]);

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(adj, i, visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean dfs(List<Integer>[] adj, int index, int[] visited) {

        if (visited[index] == 1)
            return false;
        if (visited[index] == 2)
            return true;

        visited[index] = 1;

        for (int node : adj[index]) {

            if (!dfs(adj, node, visited))
                return false;
        }

        visited[index] = 2;
        return true;
    }

}
