package all.company.com.top;

public class Q55_JumpGame {
    public static void main(String[] args) {
        int[] arr = {3,0,8,2,0,0,1};
        System.out.println(canJump(arr));
    }

    static int reachable = 0;
    //Hint : Set max Reach
    private static boolean canJump(final int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int d = Integer.min(i + nums[i], nums.length-1);
            if(reachable == i && nums[i] == 0){
                return false;
            }
            if(reachable < d){
                reachable = d;
            }
            if(reachable == nums.length-1){
                return true;
            }
        }
        return false;
    }
}
