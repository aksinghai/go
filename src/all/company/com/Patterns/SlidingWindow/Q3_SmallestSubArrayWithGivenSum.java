package all.company.com.Patterns.SlidingWindow;

public class Q3_SmallestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 8};
        int K = 7;
        smallestSubArrayWithGivenSum(arr, K);
    }

    private static void smallestSubArrayWithGivenSum(final int[] arr, final int k) {
        int i = 0;
        int j = 0;
        int l = -1;
        int h = -1;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (j < arr.length){
            if(sum < k){
                sum+= arr[j++];
            } else {
                sum-=arr[i++];
            }
            if(sum == k && min > (j-i)){
                min = (j-i);
                l = i;
                h = j-1;
            }
        }
        for(i = l; i <= h; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
