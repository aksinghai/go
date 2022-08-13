package all.company.com.top;

import java.util.Arrays;


public class Q978_TurbulentArray {
    public static void main(String[] args) {
        int[] nums = new int[]{9,4,2,10,7,8,8,1,9};
        System.out.println(maxTurbulenceSize(nums));
    }

    private static int maxTurbulenceSize(final int[] arr) {
        int[] signArray = new int[arr.length];
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] < arr[i+1]){
                signArray[i] = -1;
            } else if(arr[i] > arr[i+1]) {
                signArray[i] = 1;
            } else {
                signArray[i] = 0;
            }
        }

        /*int i = 0;
        int j = 1;
        while (j < arr.length){
            if(signArray[j-1] > signArray[])
        }
*/
        System.out.println(Arrays.toString(signArray));
        return 0;
    }
}
