package LeetCode.Easy;

public class PN191 {

    public static void main(String[] args){

        // int num = 11;
        // int num = 128;
        int num = 2147483645;

        System.out.println(hammingWeight(num));
    }

    public static int hammingWeight(int n) {

        int count = 0;

        String val = Integer.toBinaryString(n);

        System.out.println("Value " + val + " length " + val.length());

        for(int i = 0; i < val.length(); i++){
            if(val.charAt(i) == '1') count++;
        }

        return count;
    }
    
}
