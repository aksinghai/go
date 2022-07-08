package all.company.com.top;


public class Q45_JumpGame2_INC {
    public static void main(String[] args) {
        int[] arr = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println(jump(arr));
    }

    private static int jump(final int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int i = 0;
        int c = 0;
        while (true){
            int j = Integer.min(i+nums[i], nums.length-1);
            if(i == nums.length-1){
                return c;
            }
            i = maxInSubArray(nums, i+1, j);
            c++;
        }
    }

    private static int maxInSubArray(int[] nums, int i, int j){
        int max = nums[i];
        int index = i;
        i++;
        int k = 1;
        for(;i <= j; i++){
            if(max <= (nums[i] + k)){
                max = nums[i];
                index = i;
            }
            k++;
        }
        return index;
    }
}