package Code;

public class MergeSortArray {

    public static void main(String[] args) {

        int[] arr = { 45, 91, 17, 23, 8, 32, 56 };

        arr = MergeSort(arr);
        PrintArray(arr, "Final Sorted Array");
    }

    public static int[] MergeSort(int[] arr) {

        int arr_split_length = arr.length / 2;

        int[] arr1 = new int[arr_split_length];
        int[] arr2 = new int[arr.length - arr_split_length];

        for (int i = 0; i < arr_split_length; i++) {
            arr1[i] = arr[i];
        }

        int index = 0;
        for (int i = arr_split_length; i < arr.length; i++) {
            arr2[index] = arr[i];
            index++;
        }

        if (arr1.length > 1)
            arr1 = MergeSort(arr1);
        if (arr2.length > 1)
            arr2 = MergeSort(arr2);

        return MergeTwoSortedArray(arr1, arr2);
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

    public static void PrintArray(int[] arr, String a_name) {

        String str = a_name + ": ";

        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + " ";
        }

        System.out.println(str);
    }
}
