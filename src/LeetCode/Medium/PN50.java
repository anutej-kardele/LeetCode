package LeetCode.Medium;

public class PN50 {

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2.0, -2));
    }

    public static double myPow(double x, int n) {

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return myPowRec(x, n);
    }

    public static double myPowRec(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n == 1)
            return x;

        int split = n / 2;

        double output = myPowRec(x, split);
        output = output * output;

        if (n % 2 != 0)
            output = output * x;

        return output;
    }

}
