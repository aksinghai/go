package all.company.com.Patterns.SlidingWindow;

public class Q8_LongestSubStringWithOnceAfterReplacement {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
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
