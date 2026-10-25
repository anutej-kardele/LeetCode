package LeetCode.Medium;

public class PN167 {

    public static void main(String[] args) {

        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        PN167 solution = new PN167();
        int[] result = solution.twoSum(numbers, target);
        if (result != null) {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        }

        numbers = new int[] { 2, 3, 4 };
        target = 6;
        result = solution.twoSum(numbers, target);
        if (result != null) {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        }

        numbers = new int[] { -1, 0 };
        target = -1;
        result = solution.twoSum(numbers, target);
        if (result != null) {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        }
    }

    public int[] twoSum(int[] numbers, int target) {

        int l = 0;
        int r = numbers.length - 1;

        int total = 0;

        int[] output = new int[2];

        while (l < r) {

            total = numbers[l] + numbers[r];

            if (total == target) {
                output[0] = l + 1;
                output[1] = r + 1;
                return output;
            } else if (total < target)
                l++;
            else
                r--;
        }

        return output;
    }

}
