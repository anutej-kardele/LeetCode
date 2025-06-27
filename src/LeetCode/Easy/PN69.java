package LeetCode.Easy;

public class PN69 {
    public static void main(String[] args){
        System.out.println(mySqrt(9));
    }

    public static int mySqrt(int x) {

        int previousMultiIndex = 0;
        long multi = 0;

        for(long i = 0; i < 999999999; i++){
            multi = i * i;
            if(multi == x) return (int)i;
            else if(multi > x) {
                return previousMultiIndex;
            }
            previousMultiIndex = (int)i;
        }

        return 0;
    }
}
