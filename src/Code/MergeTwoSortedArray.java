package Code;

public class MergeTwoSortedArray {

    public static void main(String[] args) {

        int[] nums1 = { 1, 2, 5, 9 };
        int[] nums2 = { 3, 4, 8, 11 };

        int[] mArr = MergeTwoSortedArray(nums1, nums2);

        for (int i = 0; i < mArr.length; i++)
            System.out.print(mArr[i] + " ");
    }

    public static int[] MergeTwoSortedArray(int[] nums1, int[] nums2) {

        int iteration_1 = 0, iteration_2 = 0;

        int[] mergeArr = new int[nums1.length + nums2.length];
        int index = 0;

        while (iteration_1 < nums1.length && iteration_2 < nums2.length) {
            if (nums1[iteration_1] < nums2[iteration_2]) {
                mergeArr[index] = nums1[iteration_1];
                iteration_1++;
            } else {
                mergeArr[index] = nums2[iteration_2];
                iteration_2++;
            }
            index++;
        }

        while (iteration_1 < nums1.length) {
            mergeArr[index] = nums1[iteration_1];
            iteration_1++;
            index++;
        }

        while (iteration_2 < nums2.length) {
            mergeArr[index] = nums2[iteration_2];
            iteration_2++;
            index++;
        }

        return mergeArr;
    }
}
