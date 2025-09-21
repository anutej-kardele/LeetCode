package LeetCode.Hard;

public class PN4 {

    public static void main(String[] args) {

        int[] nums1 = { 1, 2, 5, 9 };
        int[] nums2 = { 3, 4, 8, 11 };

        // double a = findMedianSortedArrays(nums1, nums2);
        // System.out.println(findMedianSortedArrays(nums1, nums2));

        // System.out.println(nums1[4] > nums2[1]);

        int[] mArr = MergeTwoSortedArray(nums1, nums2);

        for (int i = 0; i < mArr.length; i++)
            System.out.print(mArr[i] + " ");
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Merger 2 arrays
        int[] mergeArr = new int[nums1.length + nums2.length];
        int iteration_1 = nums1.length;
        int iteration_2 = nums2.length;
        int index = 0;

        while (index < mergeArr.length) {

            // System.out.println("num1.length: " + nums1.length + " iteration_1: " +
            // iteration_1);
            //
            if (iteration_1 == 0) { // add iteration 2
                mergeArr[index] = nums2[nums2.length - iteration_2];
                iteration_2--;
            } else if (iteration_2 == 0) { // add iteration 1
                mergeArr[index] = nums1[nums1.length - iteration_1];
                iteration_1--;
            } else {
                if (nums1[nums1.length - iteration_1] < nums2[nums2.length - iteration_2]) {
                    mergeArr[index] = nums1[nums1.length - iteration_1];
                    iteration_1--;
                } else {
                    mergeArr[index] = nums2[nums2.length - iteration_2];
                    iteration_2--;
                }
            }
            index++;
        }

        // for (int i = 0; i < mergeArr.length; i++) {
        // System.out.print(mergeArr[i] + " ");
        // }

        // find the middle term if odd terms - or avg of middle 2 terms if even terms

        if (mergeArr.length % 2 == 0) {
            return (double) (mergeArr[mergeArr.length / 2] + mergeArr[(mergeArr.length / 2) - 1]) / 2;
        } else {
            return mergeArr[mergeArr.length / 2];
        }

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

        return nums1;
    }
}
