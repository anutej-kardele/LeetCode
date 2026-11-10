package LeetCode.Medium;

public class PN323 {

    public int countComponents(int n, int[][] edges) {

        int count = n;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = -1;

        for (int[] edge : edges) {

            int u = edge[0], v = edge[1];

            int uPar = find(parent, u);
            int vPar = find(parent, v);

            int w_par_u = parent[uPar];
            int w_par_v = parent[vPar];

            if (uPar != vPar) {
                count--;
                if (w_par_u < w_par_v)
                    union(parent, vPar, uPar);
                else
                    union(parent, uPar, vPar);
            }
        }

        return count;
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
