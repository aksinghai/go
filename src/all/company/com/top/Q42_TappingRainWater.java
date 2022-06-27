package all.company.com.top;

public class Q42_TappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }

    public static int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int rMax = 0;
        int sum = 0;
        for(int i = n-1; i >= 0; i--){
            if(rMax < height[i]){
                rMax = height[i];
            }
            sum += ((Math.min(leftMax[i], rMax)) - height[i]);
        }
        return sum;
    }
}
