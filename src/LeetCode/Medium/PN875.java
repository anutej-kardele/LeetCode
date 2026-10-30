package LeetCode.Medium;

public class PN875 {

    public static void main(String[] args) {
        PN875 solution = new PN875();
        // You can add test cases here

        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        int expected = 4;
        int result = solution.minEatingSpeed(piles, h);
        System.out.println("Result: " + result + " Expected: " + expected);

        piles = new int[] { 30, 11, 23, 4, 20 };
        h = 5;
        expected = 30;
        result = solution.minEatingSpeed(piles, h);
        System.out.println("Result: " + result + " Expected: " + expected);

        piles = new int[] { 30, 11, 23, 4, 20 };
        h = 6;
        expected = 23;
        result = solution.minEatingSpeed(piles, h);
        System.out.println("Result: " + result + " Expected: " + expected);
    }

    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = -1;
        for (int i = 0; i < piles.length; i++) {
            if (r < piles[i])
                r = piles[i];
        }

        int minSolution = r;

        // check min speed possible to be executed

        while (l <= r) {

            int k = l + ((r - l) / 2);

            boolean valid = isValid(piles, h, k);

            if (valid) {
                if (minSolution > k)
                    minSolution = k;
                r = k - 1;
            } else
                l = k + 1;
        }

        return minSolution;
    }

    public static boolean isValid(int[] piles, int hours, int speed) {

        long totalhours = 0;

        for (int pile : piles) {

            // number of hours needed
            totalhours += (pile + speed - 1) / speed;
        }

        return totalhours <= hours;
    }
}
