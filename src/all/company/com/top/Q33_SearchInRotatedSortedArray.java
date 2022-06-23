package all.company.com.top;

public class Q33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        //int[] arr = {0,1,2,4,5,6,7};
        int target = 0;
        System.out.println(searchInRotatedSortedArray(arr,target));
    }

    private static int searchInRotatedSortedArray(final int[] nums, final int target) {
        return pivotedBinarySearch(nums, target, 0, nums.length-1);
    }

    private static int pivotedBinarySearch(final int[] arr, final int target, final int low, final int high) {
        int pivot = findPivot(arr, 0, arr.length-1);
        if(pivot == -1){
            return binarySearch(arr, target,0, arr.length-1);
        }
        if(arr[pivot] == target){
            return pivot;
        } else if (target < arr[pivot] && target >= arr[low]) {
            return binarySearch(arr, target,low, pivot-1);
        } else if(target <= arr[high] && target >= arr[pivot+1]) {
            return binarySearch(arr, target, pivot+1, high);
        } else {
            return -1;
        }
    }

    private static int findPivot(final int[] arr, final int low, final int high) {
        int mid = ((high - low)/2) + low;
        if(low == mid){
            return mid;
        }
        if(arr[mid] > arr[high]){
            return findPivot(arr, mid, high);
        } else if(arr[mid] < arr[low]) {
            return findPivot(arr, low, mid);
        } else {
            return -1;
        }
    }

    private static int binarySearch(final int[] arr, final int target, final int low, final int high) {
        int mid = ((high - low)/2) + low;
        if(low > high ){
            return -1;
        }
        if(target == arr[mid]){
            return mid;
        } else if (target < arr[mid]) {
            return binarySearch(arr, target, low, mid-1);
        } else {
            return binarySearch(arr, target, mid+1, high);
        }
    }

}
