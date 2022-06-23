package all.company.com.top;

public class Q4_MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {2,3};
        System.out.println(findMedianOfTwoSortedArray(arr1, arr2));
    }

    /*
    Hint: using count
     */
    private static double findMedianOfTwoSortedArray(final int[] arr1, final int[] arr2) {
        int i = 0;
        int j = 0;
        int n = arr1.length + arr2.length;
        int c = 0;
        int mid = (int) (n % 2 != 0 ? Math.ceil(n/2.0) : Math.floor(n/2.0));
        int m = 0;
        while (i < arr1.length && j < arr2.length && c < mid){
            if(arr1[i] < arr2[j]){
                m = arr1[i];
                i++;
            } else {
                m = arr2[j];
                j++;
            }
            c++;
        }
        while (c < mid && i < arr1.length) {
            m = arr1[i++];
            c++;
        }
        while (c < mid && j < arr2.length) {
            m = arr2[j++];
            c++;
        }

        if(n %2 == 0){
            if(i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    return (arr1[i] + m)/2.0;
                } else {
                    return (arr2[j] + m)/2.0;
                }
            } else if (i < arr1.length) {
                return (arr1[i] + m)/2.0;
            } else {
                return (arr2[j] + m)/2.0;
            }
        }
        return m;
    }
}
