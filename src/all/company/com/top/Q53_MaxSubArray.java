package all.company.com.top;

public class Q53_MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1};
        //System.out.println(maxSubArray(arr));
        System.out.println(maxSubArrayNaiveApproach(arr));
    }

    //Kadane's Algo
    public static int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndsHere = 0;
        for(int i = 0; i < nums.length; i++){
            maxEndsHere += nums[i];
            if(maxEndsHere > maxSoFar){
                maxSoFar = maxEndsHere;
            }
            if(maxEndsHere < 0){
                maxEndsHere = 0;
            }
        }
        return maxSoFar;
    }

    public static int maxSubArrayNaiveApproach(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                max = Integer.max(sum, max);
            }
        }
        return max;
    }
}
