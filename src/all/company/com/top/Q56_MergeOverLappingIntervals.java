package all.company.com.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Q56_MergeOverLappingIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1,4},{0,2},{3,5}};
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        int[][] output = merge(arr);
        System.out.println(Arrays.toString(output));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        return mergeIntervals(intervals);
    }

    public static int[][] mergeIntervals(int[][] intervals){
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(intervals[0][0], intervals[0][1]));
        for(int i = 1; i < intervals.length; i++){
            List<Integer> l = new ArrayList<>();
            if(intervals[i-1][1] >= intervals[i][0]){
                list.get(i-1).set(1, Integer.max(intervals[i][1],intervals[i-1][1]));
            } else {
                l.add(intervals[i][0]);
                l.add(intervals[i][1]);
                list.add(l);
            }
        }
        if(intervals.length == list.size()){
            return intervals;
        }
        intervals = new int[list.size()][2];
        int i = 0;
        for(List<Integer> ll : list){
            intervals[i][0] = (int) ll.get(0);
            intervals[i++][1] = (int) ll.get(1);
        }
        return merge(intervals);
    }

}
