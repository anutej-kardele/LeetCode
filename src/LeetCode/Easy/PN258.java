package LeetCode.Easy;

public class PN258 {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {

        while (num > 9) {
            int total = 0;
            int n = num;
            while (n > 0) {
                int digit = n % 10;
                total += digit;
                n /= 10;
            }
            num = total;
        }

        return num;
    }
}
