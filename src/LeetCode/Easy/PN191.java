package LeetCode.Easy;

public class PN191 {

    public static void main(String[] args) {

        // int num = 11;
        // int num = 128;
        int num = 2147483645;

        System.out.println(hammingWeight(num));
    }

    public static int hammingWeight(int n) {

        // Brian Kernighan's algorithm n = n & (n - 1)
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }

        return count;

        // looping throw all 32 bits
        // int check = 1;
        // int count = 0;
        // for(int i = 0; i < 32; i++) {
        // if((n & check) != 0)
        // count++;
        // check *= 2;
        // }
        // return count;

        // Java's inbuild function
        // return Integer.bitCount(n);
    }

    public static int hammingWeightOLD(int n) {

        int count = 0;

        String val = Integer.toBinaryString(n);

        System.out.println("Value " + val + " length " + val.length());

        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '1')
                count++;
        }

        return count;
    }

}
