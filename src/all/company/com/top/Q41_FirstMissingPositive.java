package all.company.com.top;

public class Q41_FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2};
        System.out.println(firstMissingPositive(arr));
    }

    //Hint: Replace num on the right location in an array
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = -1;
                i++;
            } else if (i+1 == nums[i]){
                i++;
            } else if(nums[i]-1 <= nums.length){
                if(nums[i] == nums[nums[i]-1]) {
                    nums[i] = -1;
                    i++;
                } else {
                    int t = nums[i];
                    nums[i] = nums[t-1];
                    nums[t-1] = t;
                }
            }
        }

        for(i = 0; i < nums.length; i++){
            if(nums[i] == -1){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
