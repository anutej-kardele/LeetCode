package LeetCode.Easy;

import java.util.Arrays;

public class PN1929 {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 1 };

        System.out.println(Arrays.toString(getConcatenation(arr)));
    }

    public static int[] getConcatenation(int[] nums) {

        int size = nums.length * 2;
        int[] numOut = new int[size];

        for (int i = 0; i < size; i++) {

            int index = i % nums.length;
            numOut[i] = nums[index];
        }

        return numOut;
    }

}
