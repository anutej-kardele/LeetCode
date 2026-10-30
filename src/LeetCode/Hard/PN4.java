package LeetCode.Hard;

public class PN4 {

    public static void main(String[] args) {

        // int[] nums1 = { 1, 2, 5, 9 };
        // int[] nums2 = { 3, 4, 8, 11 };

        // // double a = findMedianSortedArrays(nums1, nums2);
        // // System.out.println(findMedianSortedArrays(nums1, nums2));

        // // System.out.println(nums1[4] > nums2[1]);

        // int[] mArr = MergeTwoSortedArray(nums1, nums2);

        // for (int i = 0; i < mArr.length; i++)
        // System.out.print(mArr[i] + " ");

        int[] nums1 = { 1, 3 }, nums2 = { 2 };
        double output = 2.00000;
        System.out.println(output + " --- " + findMedianSortedArrays(nums1, nums2));

        int[] nums3 = { 1, 2 };
        int[] nums4 = { 3, 4 };
        double output2 = 2.50000;
        System.out.println(output2 + " --- " + findMedianSortedArrays(nums3, nums4));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0;
        int r = nums1.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int cut1 = mid;
            int cut2 = (nums1.length + nums2.length) / 2 - cut1;

            int n1L = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int n2L = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int n1R = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            int n2R = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];

            if (n1L <= n2R && n2L <= n1R) {
                if ((nums1.length + nums2.length) % 2 == 0)
                    return (Math.max(n1L, n2L) + Math.min(n1R, n2R)) / 2.0;
                else
                    return Math.min(n1R, n2R);
            } else if (n1L > n2R)
                r = mid - 1;
            else
                l = mid + 1;
        }

        return 0;
    }

    // The solution has O(n + m) time, but the LeetCode asks for O(log(n + m))
    public static double findMedianSortedArraysLinearTime(int[] nums1, int[] nums2) {

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
