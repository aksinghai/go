package all.company.com.top;

public class Q152_MaxProductSubarray {
    public static void main(String[] args) {
        int[] arr = {-2, 0, -1, 4};
        System.out.println(maxProductSubArray(arr));
    }

    private static int maxProductSubArray(final int[] nums) {
        int maxProductSoFar = nums[0];
        int maxEndsHere = nums[0];
        int minEndsHere = nums[0];
        for(int i = 1; i < nums.length; i++){
            int min = min(nums[i], minEndsHere * nums[i], maxEndsHere * nums[i]);
            maxEndsHere = max(nums[i], minEndsHere * nums[i], maxEndsHere * nums[i]);
            minEndsHere = min;
            maxProductSoFar = Integer.max(maxEndsHere, maxProductSoFar);
        }
        return maxProductSoFar;
    }

    private static int min(int a, int b, int c){
        return Integer.min(Integer.min(a, b), c);
    }

    private static int max(int a, int b, int c){
        return Integer.max(Integer.max(a, b), c);
    }
}
