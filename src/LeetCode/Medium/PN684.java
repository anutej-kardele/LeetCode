package LeetCode.Medium;

import java.util.Arrays;

public class PN684 {

    public static void main(String[] args) {

        PN684 solution = new PN684();
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int[] result = solution.findRedundantConnection(edges);
        System.out.println("Expected [2, 3], Actual [" + result[0] + ", " + result[1] + "]");

        System.out.println("\n\n");
        edges = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
        result = solution.findRedundantConnection(edges);
        System.out.println("Expected [1, 4], Actual [" + result[0] + ", " + result[1]
                + "]");
    }

    public int[] findRedundantConnection(int[][] edges) {

        int[] result = new int[2];
        int[] parent = new int[edges.length];

        for (int i = 0; i < parent.length; i++)
            parent[i] = -1;

        for (int[] edge : edges) {

            int u = edge[0], v = edge[1];

            int uPar = find(parent, u - 1);
            int vPar = find(parent, v - 1);

            int w_par_u = parent[uPar];
            int w_par_v = parent[vPar];

            if (uPar == vPar) {
                // parent same cycle detected on this node
                result[0] = u;
                result[1] = v;
            } else if (w_par_u < w_par_v) {
                // select parent of v as new parent
                union(parent, vPar, uPar);
            } else {
                // select parent of u as new parent
                union(parent, uPar, vPar);
            }
        }

        return result;
    }

    public int find(int[] parent, int index) {

        if (parent[index] < 0)
            return index;

        parent[index] = find(parent, parent[index]);

        return parent[index];
    }

    public void union(int[] parent, int uPar, int vPar) {

        parent[uPar] += parent[vPar];
        parent[vPar] = uPar;
    }
}
