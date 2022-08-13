package all.company.com.top;

public class Q1004_LongestSubArrayAfterReplacementOfOne {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int K = 3;
        System.out.println(longestSubArray(arr, K));
    }

    private static int longestSubArray(final int[] nums, final int k) {
        int ctr = 0;
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < nums.length){
            if(nums[j] == 0 && ctr < k){
                ctr++;
                j++;
                max = Integer.max(j-i, max);
            } else if(nums[j] == 1) {
                j++;
                max = Integer.max(j-i, max);
            } else {
                if(nums[i] == 0){
                    ctr--;
                }
                i++;
            }
        }
        return max;
    }

}
