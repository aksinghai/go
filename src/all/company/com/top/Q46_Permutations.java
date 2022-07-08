package all.company.com.top;

import java.util.ArrayList;
import java.util.List;


public class Q46_Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums){
        List<Integer> l = new ArrayList<>();
        for(int i : nums){
            l.add(i);
        }
        permutation(new ArrayList<>(), l);
        return lists;
    }

    static List<List<Integer>> lists = new ArrayList<>();
    private static void permutation(List<Integer> p, List<Integer> l){
        if(l.size() == 0){
            lists.add(new ArrayList<>(p));
            return;
        }

        for(int i = 0; i < l.size(); i++){
            List<Integer> list = new ArrayList<>();
            List<Integer> permute = new ArrayList<>(p);
            for(int j = 0; j < l.size(); j++){
                if(i != j){
                    list.add(l.get(j));
                } else {
                    permute.add(l.get(i));
                }
            }
            permutation(permute, list);
        }
    }

}
