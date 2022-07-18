package all.company.com.top;

import java.util.Arrays;


public class Q31_NextPermutation {
    public static void main(String[] args) {
        int[] nums = {2,2,7,5,4,3,2,2,1};
        nextPermutation(nums);
        for(int i : nums){
            System.out.print(i+",");
        }
    }


    //Algorithm
    /*
    1. Check the condition arr[i] < arr[i+1] from back to first (int reverse order)
    2. if any combination not found, just sort and return (means provided combination is last one)
    3. else search j from i+1 to n-1 with condition arr[i] < arr[j];
    4. Swap (i, j)
    5. because i+1 to n-1 is non decreasing so just reverse the index from i+1 to n-1
     */




    private static void nextPermutation(final int[] nums) {
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                int j = i+1;
                while (j < nums.length && nums[i] < nums[j]){
                    j++;
                }
                swap(nums, i, j-1);
                reverseArray(nums, i+1, nums.length-1);
                return;
            }
        }
        Arrays.sort(nums);
    }

    private static void swap(final int[] nums, final int i, final int pivot) {
        int t = nums[i];
        nums[i] = nums[pivot];
        nums[pivot] = t;
    }

    private static void reverseArray(final int[] nums, final int l, final int h) {
        int m = l + (h-l)/2;
        for(int i = l; i <= m; i++){
            int j = (h-i)+l;
            swap(nums, i, j);
        }
    }
}
