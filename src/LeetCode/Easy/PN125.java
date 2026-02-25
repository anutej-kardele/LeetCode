package LeetCode.Easy;

public class PN125 {

    public static void main(String[] args) {

        // String str = "A man, a plan, a canal: Panama";
        // String str = "race a car";
        // String str = " ";
        String str = "0P";

        System.out.println("'" + str + "' has Palindrome? " + isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();
        // System.out.println(s);
        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        // !(c >= 'a' && c <= 'z')

        while (leftIndex <= rightIndex) {
            if (!(s.charAt(leftIndex) >= 'a' && 'z' >= s.charAt(leftIndex))
                    && !(s.charAt(leftIndex) >= '0' && '9' >= s.charAt(leftIndex))) {
                leftIndex++;
            } else if (!(s.charAt(rightIndex) >= 'a' && 'z' >= s.charAt(rightIndex))
                    && !(s.charAt(rightIndex) >= '0' && '9' >= s.charAt(rightIndex))) {
                rightIndex--;
            } else {
                if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                    leftIndex++;
                    rightIndex--;
                } else
                    return false;
            }
        }

        return true;
    }
}

// System.out.println("3. " + s.charAt(leftIndex) + "(" + leftIndex + ") " + " -
// " + s.charAt(rightIndex)
// + "(" + rightIndex + ") ");

// System.out.println("2. " + s.charAt(rightIndex) + " - " + s.charAt(rightIndex
// - 1));

// System.out.println("1. " + s.charAt(leftIndex) + " - " + s.charAt(leftIndex +
// 1));