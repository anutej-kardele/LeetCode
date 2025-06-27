package LeetCode.Medium;

public class PN189{

    public static void main(String[] args){

        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        k %= nums.length;

        Rotating(nums, 0, nums.length - 1);
        Rotate(nums);
        Rotating(nums, 0, k - 1);
        Rotate(nums);
        Rotating(nums, k, nums.length - 1);
        Rotate(nums);
        
    }

    public static void Rotating(int arr[], int start, int end){

        while (start < end) {

            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;

            start++;
            end--;
        }
    }

    public static void Rotate(int arr[]){

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }


    public static void Rotates(){
        int nums[] = {1,2,3,4,5,6,7};
        int newValue[] = new int[nums.length];

        for (int i : nums) {
            System.out.print(i + " ");
        }

        System.out.println();
        int k = 3;

        for(int i = 0; i < nums.length; i++){
            newValue[(i + k) % nums.length] = nums[i];
        }

        for (int i : newValue) {
            System.out.print(i + " ");
        }
    }

}