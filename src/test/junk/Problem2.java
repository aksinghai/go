package test.junk;/*
We have a two-dimensional board game involving snakes.  The board has two types of squares on it: +'s represent impassable squares where snakes cannot go, and 0's represent squares through which snakes can move.

Snakes may move in any of four directions - up, down, left, or right - one square at a time, but they will never return to a square that they've already visited.  If a snake enters the board on an edge square, we want to catch it at a different exit square on the board's edge.

The snake is familiar with the board and will take the route to the nearest reachable exit, in terms of the number of squares it has to move through to get there. Note that there may not be a reachable exit.

Here is an example board:

    col-->        0  1  2  3  4  5  6  7  8
               +---------------------------
    row      0 |  +  +  +  +  +  +  +  0  0
     |       1 |  +  +  0  0  0  0  0  +  +
     |       2 |  0  0  0  0  0  +  +  0  +
     v       3 |  +  +  0  +  +  +  +  0  0
             4 |  +  +  0  0  0  0  0  0  +
             5 |  +  +  0  +  +  0  +  0  +

Write a function that takes a rectangular board with only +'s and O's, along with a starting point on the edge of the board, and returns the coordinates of the nearest exit to which it can travel.  If there is a tie, return any of the nearest exits.
-----------------------------------------------------
Sample inputs:
board1 = [['+', '+', '+', '+', '+', '+', '+', '0', '0'],
          ['+', '+', '0', '0', '0', '0', '0', '+', '+'],
          ['0', '0', '0', '0', '0', '+', '+', '0', '+'],
          ['+', '+', '0', '+', '+', '+', '+', '0', '0'],
          ['+', '+', '0', '0', '0', '0', '0', '0', '+'],
          ['+', '+', '0', '+', '+', '0', '+', '0', '+']]
start1_1 = (2, 0) # Expected output = (5, 2)
start1_2 = (0, 7) # Expected output = (0, 8)
start1_3 = (5, 2) # Expected output = (2, 0) or (5, 5)
start1_4 = (5, 5) # Expected output = (5, 7)

board2 = [['+', '+', '+', '+', '+', '+', '+'],
          ['0', '0', '0', '0', '+', '0', '+'],
          ['+', '0', '+', '0', '+', '0', '0'],
          ['+', '0', '0', '0', '+', '+', '+'],
          ['+', '+', '+', '+', '+', '+', '+']]
start2_1 = (1, 0) # Expected output = null (or a special value representing no possible exit)
start2_2 = (2, 6) # Expected output = null

board3 = [['+', '0', '+', '0', '+',],
          ['0', '0', '+', '0', '0',],
          ['+', '0', '+', '0', '+',],
          ['0', '0', '+', '0', '0',],
          ['+', '0', '+', '0', '+']]
start3_1 = (0, 1) # Expected output = (1, 0)
start3_2 = (4, 1) # Expected output = (3, 0)
start3_3 = (0, 3) # Expected output = (1, 4)
start3_4 = (4, 3) # Expected output = (3, 4)

board4 = [['+', '0', '+', '0', '+',],
          ['0', '0', '0', '0', '0',],
          ['+', '+', '+', '+', '+',],
          ['0', '0', '0', '0', '0',],
          ['+', '0', '+', '0', '+']]
start4_1 = (1, 0) # Expected output = (0, 1)
start4_2 = (1, 4) # Expected output = (0, 3)
start4_3 = (3, 0) # Expected output = (4, 1)
start4_4 = (3, 4) # Expected output = (4, 3)

board5 = [['+', '0', '0', '0', '+',],
          ['+', '0', '+', '0', '+',],
          ['+', '0', '0', '0', '+',],
          ['+', '0', '+', '0', '+']]

          [[F, F, '0', '0', F,],
            [F, '0', F, '0', F,],
            [F, '0', '0', '0', F,],
            [F, '0', F, '0', F]]


start5_1 = (0, 1) # Expected output = (0, 2)
start5_2 = (3, 1) # Expected output = (0, 1)

All test cases:
findExit(board1, start1_1) => (5, 2)
findExit(board1, start1_2) => (0, 8)
findExit(board1, start1_3) => (2, 0) or (5, 5)
findExit(board1, start1_4) => (5, 7)
findExit(board2, start2_1) => null (or a special value representing no possible exit)
findExit(board2, start2_2) => null
findExit(board3, start3_1) => (1, 0)
findExit(board3, start3_2) => (3, 0)
findExit(board3, start3_3) => (1, 4)
findExit(board3, start3_4) => (3, 4)
findExit(board4, start4_1) => (0, 1)
findExit(board4, start4_2) => (0, 3)
findExit(board4, start4_3) => (4, 1)
findExit(board4, start4_4) => (4, 3)
findExit(board5, start5_1) => (0, 2)
findExit(board5, start5_2) => (0, 1)

Complexity Analysis:

r: number of rows in the board
c: number of columns in the board
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem2 {
    public static void main(String[] argv) {
        char[][] board1 = new char[][] {{'+', '+', '+', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '+', '+'},
                {'0', '0', '0', '0', '0', '+', '+', '0', '+'},
                {'+', '+', '0', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '0', '+'},
                {'+', '+', '0', '+', '+', '0', '+', '0', '+'}};
        int[] start1_1 = {2, 0}; // Expected output = {5, 2}
        int[] start1_2 = {0, 7}; // Expected output = {0, 8}
        int[] start1_3 = {5, 2}; // Expected output = {2, 0} or {5, 5}
        int[] start1_4 = {5, 5}; // Expected output = {5, 7}

        char[][] board2 = new char[][] {{'+', '+', '+', '+', '+', '+', '+'},
                {'0', '0', '0', '0', '+', '0', '+'},
                {'+', '0', '+', '0', '+', '0', '0'},
                {'+', '0', '0', '0', '+', '+', '+'},
                {'+', '+', '+', '+', '+', '+', '+'}};
        int[] start2_1 = {1, 0}; // Expected output = null (or a special value representing no possible exit)
        int[] start2_2 = {2, 6}; // Expected output = null

        char[][] board3 = new char[][] {{'+', '0', '+', '0', '+'},
                {'0', '0', '+', '0', '0'},
                {'+', '0', '+', '0', '+'},
                {'0', '0', '+', '0', '0'},
                {'+', '0', '+', '0', '+'}};
        int[] start3_1 = {0, 1}; // Expected output = {1, 0}
        int[] start3_2 = {4, 1}; // Expected output = {3, 0}
        int[] start3_3 = {0, 3}; // Expected output = {1, 4}
        int[] start3_4 = {4, 3}; // Expected output = {3, 4}

        char[][] board4 = new char[][] {{'+', '0', '+', '0', '+'},
                {'0', '0', '0', '0', '0'},
                {'+', '+', '+', '+', '+'},
                {'0', '0', '0', '0', '0'},
                {'+', '0', '+', '0', '+'}};
        int[] start4_1 = {1, 0}; // Expected output = {0, 1}
        int[] start4_2 = {1, 4}; // Expected output = {0, 3}
        int[] start4_3 = {3, 0}; // Expected output = {4, 1}
        int[] start4_4 = {3, 4}; // Expected output = {4, 3}

        char[][] board5 = new char[][] {{'+', '0', '0', '0', '+'},
                {'+', '0', '+', '0', '+'},
                {'+', '0', '0', '0', '+'},
                {'+', '0', '+', '0', '+'}};
        int[] start5_1 = {0, 1}; // Expected output = (0, 2)
        int[] start5_2 = {3, 1}; // Expected output = (0, 1)

        // System.out.println(solution(board1));
        // System.out.println(solution(board2));
        // System.out.println(solution(board3));
        // System.out.println(solution(board4));
        System.out.println(solution2(board1, start1_1));
        System.out.println(solution2(board1, start1_2));
        System.out.println(solution2(board1, start1_3));
        System.out.println(solution2(board1, start1_4));
        System.out.println(solution2(board2, start2_1));
        System.out.println(solution2(board2, start2_2));
        System.out.println(solution2(board3, start3_1));
        System.out.println(solution2(board3, start3_2));
        System.out.println(solution2(board3, start3_3));
        System.out.println(solution2(board3, start3_4));
        System.out.println(solution2(board4, start4_1));
        System.out.println(solution2(board4, start4_2));
        System.out.println(solution2(board4, start4_3));
        System.out.println(solution2(board4, start4_4));
        System.out.println(solution2(board5, start5_1));
        System.out.println(solution2(board5, start5_2));
    }

    private static String solution2(char[][] maze, int[] entrance){
        if(maze == null){
            return "";
        }
        System.out.println("Input :"+entrance[0]+","+entrance[1]+" ");
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(maze[i][j] == '+'){
                    visited[i][j] = true;
                }
            }
        }

        int i = entrance[0];
        int j = entrance[1];
        boolean exitAllow = false;
        Queue<String> queue = new LinkedList<>();
        queue.add(i+"_"+j);
        visited[i][j] = true;
        while(!queue.isEmpty()){
            String item = queue.remove();
            String[] items = item.split("_");
            i = Integer.parseInt(items[0]);
            j = Integer.parseInt(items[1]);
            if(exitAllow && (i == 0 || i == m-1 || j == 0 || j == n-1)){
                return i+"_"+j;
            }
            if(i-1 >= 0 && !visited[i-1][j]){
                queue.add((i-1) + "_"+j);
                visited[i-1][j] = true;
            }
            if (i+1 < m && !visited[i+1][j]) {
                queue.add((i+1) + "_"+j);
                visited[i+1][j] = true;
            }
            if (j-1 >= 0 && !visited[i][j-1]) {
                queue.add(i + "_"+(j-1));
                visited[i][j-1] = true;
            }
            if (j+1 < n && !visited[i][j+1]) {
                queue.add(i + "_"+(j+1));
                visited[i][j+1] = true;
            }
            exitAllow = true;
        }
        return "";
    }


    private static List<List<Integer>> solution(char[][] board){
        if(board == null){
            return new ArrayList<>();
        }
        int m = board.length;
        int n = board[0].length;
        List<Integer> rows = new ArrayList<>();
        for(int i = 0; i < m; i++){
            boolean snakeCanPass = true;
            for(int j = 0; j < n; j++){
                if(board[i][j] == '+'){
                    snakeCanPass = false;
                    break;
                }
            }
            if(snakeCanPass){
                rows.add(i);
            }
        }

        List<Integer> cols = new ArrayList<>();
        for(int i = 0; i < n; i++){
            boolean snakeCanPass = true;
            for(int j = 0; j < m; j++){
                if(board[j][i] == '+'){
                    snakeCanPass = false;
                    break;
                }
            }
            if(snakeCanPass){
                cols.add(i);
            }
        }
        List<List<Integer>> result = new ArrayList<>(2);
        result.add(rows);
        result.add(cols);
        return result;

    }

}
