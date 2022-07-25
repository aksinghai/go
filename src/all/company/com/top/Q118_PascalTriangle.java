package all.company.com.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Q118_PascalTriangle {
    public static void main(String[] args) {
        int numRows = 4;
        //System.out.println(getAllRows(numRows));
        System.out.println(getRow(30));
    }

    private static List<List<Integer>> getAllRows(final int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Collections.singletonList(1)));
        if(numRows == 1){
            return list;
        }

        Integer[] prev = new Integer[2];
        prev[0] = 1;
        prev[1] = 1;
        list.add(new ArrayList<>(Arrays.asList(prev)));
        for(int i = 3; i <= numRows; i++){
            Integer[] next = new Integer[i];
            next[0] = 1;
            next[i-1] = 1;
            for(int j = 1; j < i-1; j++){
                next[j] = prev[j-1]+prev[j];
            }
            prev = next;
            list.add(new ArrayList<>(Arrays.asList(next)));
        }
        return list;
    }

    private static List<Integer> getRow(final int rowIndex){
        List<Integer> list = new ArrayList<>();
        int prev = 1;
        list.add(prev);
        for(int i = 1; i <= rowIndex; i++){
            int next = (prev * (rowIndex - i + 1)) / i;;
            list.add(next);
            prev = next;
        }
        return list;
    }
}
