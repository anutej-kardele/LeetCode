package LeetCode.Easy;

import java.util.Arrays;

public class PN344 {

    public static void main(String[] args) {

        char[] ch = {};
        System.out.println(Arrays.toString(reverseString(ch)));
    }

    public static char[] reverseString(char[] s) {

        int leftP = 0;
        int rightP = s.length - 1;

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[rightP];
            s[rightP] = s[leftP];
            s[leftP] = temp;

            leftP++;
            rightP--;
        }

        return s;
    }

}
