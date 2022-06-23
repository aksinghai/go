package all.company.com.top;

public class Q26_RemoveDuplicateFromArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int n = removeDuplicate(nums);
        for(int i = 0; i < n; i++){
            System.out.println(nums[i]);
        }
    }

    private static int removeDuplicate(final int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int i = 0;
        int j = i+1;
        while (j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            } else {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
