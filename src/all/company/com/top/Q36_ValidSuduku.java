package all.company.com.top;

public class Q36_ValidSuduku {
    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}}));
    }

    private static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i+=3){
            for(int j= 0; j < board[i].length; j+=3) {
                if(!check3x3(board, i, j)){
                    return false;
                }
            }
        }

        return checkRowAndColumn(board);
    }

    private static boolean check3x3(char[][] board, int a, int b){
        int[] nums = new int[9];
        for(int i  = a;i < a+3; i++){
            for(int j = b;j < b+3; j++){
                if(board[i][j] >= '1' && board[i][j] <= '9'){
                    int n = (int)board[i][j] - '0'  - 1;
                    if(nums[n] == 0){
                        nums[n]++;
                    } else {
                        return false;
                    }
                } else if (board[i][j] != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkRowAndColumn(char[][] board){
        for(int i = 0; i < board.length; i++){
            int[] nums = new int[9];
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] >= '1' && board[i][j] <= '9'){
                    int n = (int)board[i][j] - '0'  - 1;
                    if(nums[n] == 0){
                        nums[n]++;
                    } else {
                        return false;
                    }
                } else if (board[i][j] != '.') {
                    return false;
                }
            }
        }
        for(int j = 0; j < board.length; j++){
            int[] nums = new int[9];
            for(int i = 0; i < board[j].length; i++){
                if(board[i][j] >= '1' && board[i][j] <= '9'){
                    int n = (int)board[i][j] - '0'  - 1;
                    if(nums[n] == 0){
                        nums[n]++;
                    } else {
                        return false;
                    }
                } else if (board[i][j] != '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
