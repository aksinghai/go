package all.company.com.top;

public class Q941_ValidMountainArray {
    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{0,3,3,2,1}));
    }

    public static boolean validMountainArray(int[] arr) {
        if(arr == null || arr.length < 3){
            return false;
        }
        int len = arr.length;
        int i = 0;
        while (i+1 < len){
            if(arr[i] < arr[i+1]){
                i++;
            } else {
                break;
            }
        }

        int j = len-1;
        while (j-1 >= 0){
            if(arr[j] < arr[j-1]){
                j--;
            } else {
                break;
            }
        }

        return i == j;
    }
}
