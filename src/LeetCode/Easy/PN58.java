package LeetCode.Easy;

public class PN58 {
    public static int lengthOfLastWord(String s) {

        int output = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ' && output != 0) break;
            else if (s.charAt(i) != ' ' ) output++;
        }

        return output;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
