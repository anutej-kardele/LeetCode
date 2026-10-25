package LeetCode.Easy;

public class PN69 {
    public static void main(String[] args) {
        System.out.println("mySqrt(9) = " + mySqrt(9));
        System.out.println("mySqrt(8) = " + mySqrt(8));
        System.out.println("mySqrt(0) = " + mySqrt(0));
        System.out.println("mySqrt(1) = " + mySqrt(1));
        System.out.println("mySqrt(30) = " + mySqrt(30));
        System.out.println("mySqrt(100) = " + mySqrt(100));
    }

    public static int mySqrtOLD(int x) {

        int previousMultiIndex = 0;
        long multi = 0;

        for (long i = 0; i < 999999999; i++) {
            multi = i * i;
            if (multi == x)
                return (int) i;
            else if (multi > x) {
                return previousMultiIndex;
            }
            previousMultiIndex = (int) i;
        }

        return 0;
    }

    public static int mySqrt(int x) {

        if (x == 0 || x == 1)
            return x;

        long pointer = x;

        while (pointer > x / pointer) {
            pointer = (pointer + x / pointer) / 2;
        }

        return (int) pointer;
    }

    public static int mySqrtStillNotGood(int x) {

        long left = 0;
        long right = x;
        long mid = x / 2;

        long largestPossible = 0;

        while (left <= right) {
            long midSqr = mid * mid;

            if (midSqr <= x && largestPossible < mid) {
                largestPossible = mid;
            }
            if (midSqr < x)
                left = mid + 1;
            else
                right = mid - 1;

            mid = left + (right - left) / 2;
        }

        return (int) largestPossible;
    }
}
