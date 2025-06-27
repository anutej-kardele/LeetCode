package LeetCode.Hard;

public class PN60 {

    public static void main(String[] args){

        //System.out.println(" N = 3 & K = 3 : " + getPermutation(3, 3));
        // System.out.println(" N = 3 & K = 1 : " + getPermutation(3, 1));
        System.out.println(" N = 4 & K = 9 : " + getPermutation(4, 9));
    }

    public static String getPermutation(int n, int k) {

        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }

        for(int i = 1; i < k; i++){

            if(i % 2 == 0){
                RightShift(arr);
            }
            else{
                int temp = arr[arr.length- 1];
                arr[arr.length- 1] = arr[arr.length- 2];
                arr[arr.length- 2] = temp;
            }
        }



        String send = "";
        for(int i = 0; i < arr.length; i++){
            send += arr[i];
        }

        return send;
    }

    public static int[] RightShift(int[] arr){

        int swap = arr[arr.length - 1];

        for(int i = 0; i < arr.length; i++){
            int temp = arr[i];
            arr[i] = swap;
            swap = temp;
        }

        return arr;
    }
}
