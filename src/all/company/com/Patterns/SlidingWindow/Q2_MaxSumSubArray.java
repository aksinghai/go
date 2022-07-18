package all.company.com.Patterns.SlidingWindow;

public class Q2_MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 5};
        int K = 2;
        System.out.println(maxSumSubArray(arr, K));
    }

    private static int maxSumSubArray(int[] arr, int K) {
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        int sum  = 0;
        while (j < arr.length){
            if(j-i >= K){
                sum -= arr[i++];
            } else {
                sum += arr[j++];
                max = Integer.max(sum, max);
            }
        }
        return max;
    }

}
