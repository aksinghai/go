package all.company.com.top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q697_DegreeOfAnArray {
    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> lookup = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(!lookup.containsKey(nums[i])){
                lookup.put(nums[i], new ArrayList<>());
            }
            lookup.get(nums[i]).add(i);
            int size = lookup.get(nums[i]).size();
            if(max < size){
                max = size;
            }
        }
        System.out.println(lookup);
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer, List<Integer>> entry : lookup.entrySet()){
            if(entry.getValue().size() == max){
                int d = (entry.getValue().get(entry.getValue().size() - 1) - entry.getValue().get(0)) + 1;
                if(min > d){
                    min = d;
                }
            }
        }
        return min;
    }
}
