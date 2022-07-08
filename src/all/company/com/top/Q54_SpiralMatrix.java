package all.company.com.top;

import java.util.ArrayList;
import java.util.List;


public class Q54_SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        System.out.println(spiralOrder(arr));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        spiralOrder(matrix, list, 0, matrix.length-1, 0, matrix[0].length-1);
        return list;
    }

    public static void spiralOrder(int[][] matrix, List<Integer> list, int rl, int rh, int cl, int ch){
        if(rl > rh || cl > ch){
            return;
        }

        boolean right = false;
        for(int i = cl; i <= ch; i++){
            list.add(matrix[rl][i]);
            right = true;
        }

        boolean down = false;
        for(int i = rl+1; i <= rh && right; i++){
            list.add(matrix[i][ch]);
            down = true;
        }

        boolean left = false;
        for(int i = ch-1; i >= cl && down; i--){
            list.add(matrix[rh][i]);
            left = true;
        }

        for(int i = rh-1; i > rl && left; i--){
            list.add(matrix[i][cl]);
        }

        spiralOrder(matrix, list, rl+1, rh-1, cl+1, ch-1);
    }

}
