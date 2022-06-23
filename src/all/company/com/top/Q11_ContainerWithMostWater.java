package all.company.com.top;

//https://leetcode.com/problems/container-with-most-water/
public class Q11_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxWater(arr));
    }

    /*
        Max size container
     */
    private static int maxWater(final int[] height) {
        int max = -1;
        int i = 0;
        int j = height.length-1;
        while(i < j){
            int waterFilled = Integer.min(height[i], height[j]) * (j-i);
            max = Integer.max(waterFilled, max);
            if(height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
