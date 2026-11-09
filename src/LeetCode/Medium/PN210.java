package LeetCode.Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class PN210 {

    public static void main(String[] args) {
        // Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        // Output: [0,2,1,3] or [0,1,2,3]

        PN210 solution = new PN210();
        int[] result = solution.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
        System.out.println("Expected: [0,2,1,3] or [0,1,2,3], Result: " + Arrays.toString(result));
    }

    @SuppressWarnings("unchecked")
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] sequence = new int[numCourses];

        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<>();

        for (int[] pre : prerequisites)
            adj[pre[0]].add(pre[1]);

        Deque<Integer> deque = new ArrayDeque<>();
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adj, i, visited, deque)) {
                return new int[0];
            }
        }

        for (int i = 0; i < numCourses; i++)
            sequence[i] = deque.poll();

        return sequence;
    }

    public boolean dfs(List<Integer>[] adj, int index, int[] visited, Deque<Integer> deque) {

        if (visited[index] == 1)
            return false;
        if (visited[index] == 2)
            return true;

        visited[index] = 1;

        for (int node : adj[index]) {

            if (!dfs(adj, node, visited, deque)) {
                return false;
            }
        }

        visited[index] = 2;
        deque.addLast(index);

        return true;
    }

}
