package LeetCode.Easy;

import java.util.Arrays;

public class PN509 {

    public static void main(String[] args) {
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
    }

    public static int fib(int n) {

        if (n <= 1)
            return n;
        // return fib(n - 1) + fib(n - 2);

        int[] fibonacci = new int[n + 1];
        Arrays.fill(fibonacci, -1);

        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }

        return fibonacci[n];
    }
}
