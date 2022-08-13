package test.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Intervals {
    int x;
    int y;

    Intervals(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override public String toString() {
        return "Intervals{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        int[][] intervals = {{2,6},{8,10},{15,18}, {16, 17},{1,3}};
        mergeIntervals(intervals);
    }

    private static void mergeIntervals(final int[][] intervals) {
        if(intervals == null){
            return;
        }
        if(intervals.length == 1){
            System.out.println(Arrays.toString(intervals[0]));
        }

        List<Intervals> intervalsList = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            intervalsList.add(new Intervals(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(intervalsList, (o1, o2) -> o1.x - o2.x);
        for(int i = 0; i < intervalsList.size()-1; i++){
            if(intervalsList.get(i).y >= intervalsList.get(i+1).x){
                if(intervalsList.get(i).y > intervalsList.get(i+1).y){
                    intervalsList.add(i, new Intervals(intervalsList.get(i).x, intervalsList.get(i).y));
                } else {
                    intervalsList.add(i, new Intervals(intervalsList.get(i).x, intervalsList.get(i+1).y));
                }

                intervalsList.remove(i+1);
                intervalsList.remove(i+1);
            }
        }
        System.out.println(intervalsList);
    }
}
