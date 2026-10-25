package LeetCode.Easy;

public class PN374 {

    int quessNum = 0;

    public static void main(String[] args) {
        PN374 solution = new PN374();
        int n = 10; // Example input
        solution.quessNum = 7; // Example guess number
        System.out.println("Guess number: " + solution.guessNumber(n));
    }

    public int guessNumber(int n) {

        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int guess = guess(mid);

            if (guess == 0)
                return mid;
            else if (guess == 1)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return right;
    }

    int guess(int num) {
        if (num == quessNum)
            return 0;
        return num < quessNum ? 1 : -1;
    }
}
