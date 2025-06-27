package LeetCode.Easy;

public class PN88 {
    
    public static void main(String[] args) {

        int arr[] = {1,2,3,0,0,0};
        int arr2[] = {2,5,6};

        merge(arr, 3, arr2, 3);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        for(int i = m; i < nums1.length; i++){
            nums1[i] = nums2[index];
            index++;
        }

        int temp = 0;

        for(int i = 0; i < nums1.length - 1; i++){
            for(int j = 0; j < nums1.length - i - 1; j++){
                if(nums1[j] > nums1[j + 1]){
                    temp = nums1[j];
                    nums1[j] = nums1[j+1];
                    nums1[j+1] = temp;
                }
            }
        }
    }
}
