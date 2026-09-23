package LeetCode.Easy;

import java.util.Arrays;

public class PN88 {

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 0, 0, 0 };
        int arr2[] = { 2, 5, 6 };

        merge(arr, 3, arr2, 3);

        // int arr[] = { 0, 0, 0, 0, 0 };
        // int arr2[] = { 1, 2, 3, 4, 5 };

        // merge(arr, 0, arr2, 5);

        System.out.println(Arrays.toString(arr));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = nums1.length - n - 1;
        int p2 = nums2.length - 1;
        int counter = nums1.length - 1;

        while (p2 >= 0) {

            System.out.println("p1 : " + p1 + " --- p2 : " + p2);

            if (p1 >= 0 && p2 >= 0) {
                if (nums2[p2] > nums1[p1]) {
                    nums1[counter] = nums2[p2];
                    p2--;
                } else {
                    nums1[counter] = nums1[p1];
                    p1--;
                }
            } else if (p1 < 0) {
                nums1[counter] = nums2[p2];
                p2--;
            } else if (p2 < 0) {
                nums1[counter] = nums1[p1];
                p1--;
            }

            counter--;
            System.out.println(Arrays.toString(nums1));
        }
    }

    public static void mergeOLD(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[index];
            index++;
        }

        int temp = 0;

        for (int i = 0; i < nums1.length - 1; i++) {
            for (int j = 0; j < nums1.length - i - 1; j++) {
                if (nums1[j] > nums1[j + 1]) {
                    temp = nums1[j];
                    nums1[j] = nums1[j + 1];
                    nums1[j + 1] = temp;
                }
            }
        }
    }
}
