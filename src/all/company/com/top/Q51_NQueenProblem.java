package all.company.com.top;

import java.util.ArrayList;
import java.util.List;


public class Q51_NQueenProblem {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = '.';
            }
        }
        solveNQueenProblem(board, 0, new ArrayList<>());
        return lists;
    }


    static List<List<String>> lists = new ArrayList<>();
    private static void solveNQueenProblem(char[][] board, int row, List<String> list){
        if(row == board.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int j = 0; j < board[row].length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                list.add(new String(board[row]));
                solveNQueenProblem(board, row+1, list);
                list.remove(list.size()-1);
                board[row][j] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int x, int y){
        if(x ==0){
            return true;
        }

        int i = x-1;
        int j = y-1;
        int k = y+1;
        while (i >=0){
            if(j >= 0){
                if(board[i][j--] == 'Q'){
                    return false;
                }
            }
            if(k < board.length){
                if(board[i][k++] == 'Q'){
                    return false;
                }
            }
            if(board[i--][y] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
