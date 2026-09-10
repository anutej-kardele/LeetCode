package LeetCode.Easy;

import java.util.Set;
import java.util.HashSet;

public class PN202 {

    public static void main(String[] args) {
        System.out.println(isHappy2(19));
        // System.out.println(isHappy(2));
    }

    public static boolean isHappy2(int n) {
        Set<Integer> seen = new HashSet<>();
        int digit = 0;
        int newTotal = 0;

        while (n != 1 && seen.add(n)) {
            newTotal = 0;
            while (n > 0) {
                digit = n % 10;
                newTotal += digit * digit;
                n /= 10;
            }
            n = newTotal;
        }

        return n == 1;
    }

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int currentSize = 0;

        while (seen.size() == currentSize) {

            int newTotal = 0;
            while (n > 0) {
                int digit = n % 10;
                newTotal += digit * digit;
                n /= 10;
            }

            // Check total 1
            n = newTotal;
            int sum = 0;
            while (newTotal > 0) {
                int digit = newTotal % 10;
                sum += digit;
                newTotal /= 10;
            }

            seen.add(n);
            currentSize++;
            System.out.println("Total: " + n + " Sum: " + sum);

            if (sum == 1)
                return true;
        }
        return false;
    }
}
