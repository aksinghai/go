package test.junk.Dunzo;

public class Problem1 {
    public static void main(String[] args) {
        int[] arr1 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int K1 = 3;
        int[] arr2 = {1,1,1,0,0,0,1,1,1,1,0};
        int K2 = 2;
        int[] arr3 = {1,1,1,0,0,0,1,1,1,1,0};
        int K3 = 3;
        System.out.println(maxLength(arr1, K1));
        System.out.println(maxLength(arr2, K2));
        System.out.println(maxLength(arr3, K3));
    }

    private static int maxLength(final int[] arr, final int K) {
        int i = 0;
        int j = 0;
        int ctr = 0;
        int max = Integer.MIN_VALUE;
        while (j < arr.length){
            if(arr[j] == 1){
                j++;
                max = Integer.max(max, j-i);
            } else {
                if(ctr < K){
                    j++;
                    ctr++;
                    max = Integer.max(max, j-i);
                } else {
                    if(arr[i] != 1){
                        ctr--;
                    }
                    i++;
                }
            }
        }
        return max;
    }
}
