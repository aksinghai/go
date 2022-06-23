package all.company.com.top;

import java.util.Arrays;


public class Q34_FindFirstAndLastPositionOfAnElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,8};
        int target = 8;
        System.out.println(Arrays.toString(findFirstAndLastPosition(arr, target)));
    }

    private static int[] findFirstAndLastPosition(final int[] nums, final int target) {
        int[] resp = new int[]{-1, -1};
        boolean found = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target && !found) {
                resp[0] = i;
                found = true;
            }
            if(nums[i] ==target && found) {
                resp[1] = i;
            }
            if(nums[i] != target && found){
                return resp;
            }
        }
        return resp;
    }
}
