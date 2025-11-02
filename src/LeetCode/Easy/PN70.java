package LeetCode.Easy;

import java.util.Arrays;

public class PN70 {

    public static void main(String[] args) {

        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));

    }

    public static int climbStairs(int n) {

        if (n <= 2)
            return n;

        int[] steps = new int[n + 1];
        Arrays.fill(steps, -1);

        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            steps[i] = steps[i - 2] + steps[i - 1];
        }

        return steps[n];
    }

    // Better solution for space complexity with the same time complexity

    // public int climbStairs(int n) {

    // if(n <= 1) return n;

    // int one = 1, two = 1;
    // int temp = one;

    // for(int i = 2; i <= n; i++) {
    // temp = one;
    // one += two;
    // two = temp;
    // }

    // return one;
    // }
}
