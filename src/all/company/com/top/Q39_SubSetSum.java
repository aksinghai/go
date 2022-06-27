package all.company.com.top;

import java.util.ArrayList;
import java.util.List;


public class Q39_SubSetSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }

    //Hint : Recursion with Include and Exclude
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combination(candidates, target, new ArrayList<>(), 0, result);
        return result;
    }

    public static void combination(int[] candidates, int target, List<Integer> list, int j, List<List<Integer>> listOfList){
        if(target == 0){
            listOfList.add(new ArrayList<>(list));
            return;
        }
        for(int i = j; i < candidates.length; i++){
            if(target >= candidates[i]) {
                list.add(candidates[i]);
                combination(candidates, target - candidates[i], list, i, listOfList);
                list.remove(list.size()-1);
            }
        }
    }
}
