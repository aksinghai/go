package all.company.com.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q1_TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7 ,2, 11, 15};
        int T = 4;
        System.out.println(twoSum1(arr, T));
    }

    /* Hint:
    1. Sort array
    2. check from last and first
    */
    private static List<List<Integer>> twoSum(int[] arr, int T){
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        List<List<Integer>> list = new ArrayList<>();
        while ( i < j) {
            int v = arr[i]+arr[j];
            if(v == T) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(j);
                list.add(l);
                i++;
                j--;
            } else if(v < T) {
                i++;
            } else {
                j--;
            }
        }
        return list;
    }

    /* Hint
        1. Create map with item and its frequency
        2. X + Y = T => T - X = Y, search Y in map
     */
    private static List<List<Integer>> twoSum1(int[] arr, int T){
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> lookup = new HashMap<>();
        for(int i : arr){
            int c = 0;
            if(lookup.containsKey(i)){
                c = lookup.get(i);
            }
            lookup.put(i, c+1);
        }
        for(int i = 0; i < arr.length; i++){
            if(lookup.containsKey(T - arr[i])){
                if(T - arr[i] != arr[i] || (T - arr[i] == arr[i] && lookup.get(arr[i]) > 1)){
                    List<Integer> l = new ArrayList<>();
                    l.add(arr[i]);
                    l.add(T - arr[i]);
                    result.add(l);
                }
            }
        }
        return result;
    }
}
