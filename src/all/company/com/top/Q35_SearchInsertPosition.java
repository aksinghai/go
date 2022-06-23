package all.company.com.top;

public class Q35_SearchInsertPosition {
    public static void main(String[] args) {
       int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchIndex(nums, target, 0, nums.length-1));
    }

    private static int searchIndex(int[] nums, int target, int low, int high){
        int mid = ((high-low)/2+low);
        if(low > high){
            return low;
        }
        if(nums[mid] == target){
            return mid;
        } else if(target < nums[mid]){
            return searchIndex(nums, target, low, mid-1);
        } else {
            return searchIndex(nums, target, mid+1, high);
        }
    }
}
