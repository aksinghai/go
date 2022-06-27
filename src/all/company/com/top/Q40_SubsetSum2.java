package all.company.com.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Q40_SubsetSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    private static List<List<Integer>> combinationSum2(final int[] candidates, final int target) {
        Arrays.sort(candidates);
        combination(candidates, target, 0, new ArrayList<>());
        return new ArrayList<>(globalSet);
    }


    static Set<List<Integer>> globalSet = new HashSet<>();
    private static void combination(int[] candidates, final int target, int i, List<Integer> list){
        if(target == 0){
            globalSet.add(new ArrayList<>(list));
            return;
        } else if (target < 0){
            return;
        }
        if(i == candidates.length){
            return;
        }

        for(;i < candidates.length; i++){
            if(target < candidates[i]) break;
            list.add(candidates[i]);
            combination(candidates, target - candidates[i], i+1, list);
            list.remove(list.size()-1);
        }
    }
}
