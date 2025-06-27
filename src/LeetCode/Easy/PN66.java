package LeetCode.Easy;

public class PN66 {
    public static void main(String[] args){
        
        int[] digits = {1,2,3};
        digits = plusOne(digits);
        
        for(int i = 0; i < digits.length; i++){
            System.out.println(digits[i]);
        }
    }

    public static int[] plusOne(int[] digits) {
        
        int size = digits.length;
        int i=0;
    
        for(i = size-1 ; i >= 0 ; i--){
            if (digits[i] != 9) {
                digits[i] += 1;
                break;
            } else {
                digits[i] = 0;
            }
        }
        
        if(i == -1) {
            int[] newDigits = new int[size+1];
            newDigits[0] = 1;
            return newDigits;
        }
        
        return digits;
    }
}
