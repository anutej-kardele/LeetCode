package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class PN1137 {
    public static int tribonacci(int n) {
        int intList[] = new int[n+1];

        if(n >= 0) intList[0] = 0;
        if(n >= 1) intList[1] = 1;
        if(n >= 2) intList[2] = 1;

        if(n < 3) return intList[n];

        for(int i = 3; i <= n; i++){
            intList[i] = intList[i-1] + intList[i-2] + intList[i-3];
        }

        return intList[n];
    }

    public static int tribonacci2(int n) {
        List<Integer> intList = new ArrayList<Integer>(){{ add(0); add(1);add(1); }};

        for(int i = 3; i <= n; i++){
            intList.add( intList.get(i - 1) + intList.get(i - 2) + intList.get(i - 3) );
        }

        return intList.get(n);
    }

    public static void main(String[] args) {

        System.out.println(tribonacci(4));
        //System.out.println(tribonacci2(5));
    }
}
