package LeetCode.Easy;

public class PN746 {

    public static void main(String[] args) {
        PN746 solution = new PN746();
        int[] cost = { 10, 15, 20 };
        System.out.println("Expected: 15 Output: " + solution.minCostClimbingStairs(cost));

        cost = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println("Expected: 6 Output: " + solution.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {

        for (int i = 2; i < cost.length; i++)
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
