package LeetCode.Easy;

public class PN1768 {

    public String mergeAlternately(String word1, String word2) {

        int leftSize = word1.length();
        int rightSize = word2.length();
        char[] result = new char[leftSize + rightSize];
        int count = 0;
        int left = 0;
        int right = 0;

        while (left < leftSize && right < rightSize) {
            if (left <= right) {
                result[count] = word1.charAt(left);
                left++;
                count++;
            } else {
                result[count] = word2.charAt(right);
                right++;
                count++;
            }
        }

        while (left < leftSize) {
            result[count] = word1.charAt(left);
            left++;
            count++;
        }

        while (right < rightSize) {
            result[count] = word2.charAt(right);
            right++;
            count++;
        }

        return new String(result);
    }

}
