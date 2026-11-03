package LeetCode.Easy;

import java.util.Arrays;

public class PN338 {

    public static void main(String[] args) {

    }

    public int[] countBits(int n) {

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++)
            arr[i] = arr[i & (i - 1)] + 1;

        return arr;
    }

    // Slow approach and too much memory

    // int[] vals;
    // public int[] countBits(int n) {

    // int[] arr = new int[n + 1];
    // vals = new int[n+1];
    // Arrays.fill(vals, -1);

    // for(int i = 0; i <= n; i++) {
    // arr[i] = hammingWeight(i);
    // }

    // return arr;
    // }

    // public int hammingWeight(int n) {

    // // Brian Kernighan's algorithm n = n & (n - 1)
    // int count = 0;
    // int i = n;

    // while (n != 0) {
    // if(vals[n] != -1){
    // count += vals[n];
    // break;
    // }

    // n &= (n - 1);
    // count++;
    // }

    // vals[i] = count;
    // return count;
    // }
}
