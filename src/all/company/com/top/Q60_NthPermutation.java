package all.company.com.top;

public class Q60_NthPermutation {
    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        System.out.println(getPermutation(n, k));
    }

    private static String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for(int i = 1; i <= n; i++){
            arr[i-1] = i;
        }
        return getPermutation(arr, n, k-1, "", getFactorial(n-1));
    }

    private static String getPermutation(int[] arr, int n, int k, String s, int permuteCounts) {
        if(n < 1){
            return s;
        }
        int index = (int)(k / permuteCounts);
        int[] arr1 = new int[arr.length-1];
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(i == index){
                s += arr[index];
            } else {
                arr1[j++] = arr[i];
            }
        }
        k -= (permuteCounts * index);
        if(n-1 == 0){
            permuteCounts = 0;
        } else {
            permuteCounts = permuteCounts/(n-1);
        }
        return getPermutation(arr1, n-1, k, s, permuteCounts);
    }

    private static int getFactorial(int n){
        int fact = 1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }
}
