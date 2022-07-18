package all.company.com.top;


public class Q73_SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
    }

    /*private static void setZeroes(final int[][] matrix) {
        int nonExistsNumber = -1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = nonExistsNumber;
                    matrix[0][j] = nonExistsNumber;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == -1){
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] != nonExistsNumber){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[0][j] == -1){
                for(int i = 0; i < matrix.length; i++){
                    if(matrix[i][j] != nonExistsNumber){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == nonExistsNumber){
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }*/

    private static void setZeroes(final int[][] matrix) {
        boolean colZero = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0 && j != 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                } else if (matrix[i][j] == 0) {
                    colZero = true;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){ // Check all rows
                for(int j = 0; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }


        for(int j = 1; j < matrix[0].length; j++){
            if(matrix[0][j] == 0) { //Check all columns
                for(int i = 0; i < matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        /*
        if(colZero){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }*/

        System.out.println(colZero);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
