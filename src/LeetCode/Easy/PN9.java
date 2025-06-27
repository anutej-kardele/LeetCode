package LeetCode.Easy;

public class PN9 {
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;

        String temp = Integer.toString(x);
        int[] newGuess = new int[temp.length()];
        int temp2 = temp.length() - 1;
        for(int i = 0; i < ((int)newGuess.length / 2); i++){
            newGuess[i] = temp.charAt(i);
            newGuess[temp2 - i] = temp.charAt(temp2 - i);
            if(newGuess[i] != newGuess[temp2 - i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
        System.out.println(isPalindrome(100));
        System.out.println(isPalindrome(-1001));
        System.out.println(isPalindrome(1000021));
        System.out.println(isPalindrome(10000021));
        System.out.println(isPalindrome(100000021));
        System.out.println(isPalindrome(1000000021));
        System.out.println(isPalindrome(136929631));

    }
}
