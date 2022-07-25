package all.company.com.top;


public class Q1091_ShortestPathInABinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0,0,0,0},
                {1,1,1,1,1,0},
                {0,0,0,0,0,0},
                {0,1,1,1,1,1},
                {0,0,0,0,0,0}
        } ;
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    static int min = Integer.MAX_VALUE;
    private static int shortestPathBinaryMatrix(final int[][] grid) {
        if(grid[0][0] != 0){
            return 0;
        }
        boolean[][] visiting = new boolean[grid.length][grid[0].length];
        long start = System.currentTimeMillis();
        min = grid.length * grid[0].length;
        shortestPath(grid, 0, 0, grid.length-1, grid[0].length-1,visiting, 1);
        System.out.println("Time taken : "+ (System.currentTimeMillis() - start));
        return min;
    }

    private static void shortestPath(int[][] grid, int cx, int cy, int tx, int ty, boolean[][] visiting, int c){
        if(cx == tx && cy == ty){
            min = Integer.min(min, c);
            return;
        }
        int[][] d = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        if(c+1 <= min){
            for (final int[] ints : d) {
                int x = cx + ints[0];
                int y = cy + ints[1];
                if (x < grid.length && x >= 0 && y < grid[0].length && y >= 0 &&
                        grid[x][y] == 0 && !visiting[x][y]) {
                    visiting[x][y] = true;
                    shortestPath(grid, x, y, tx, ty, visiting, c + 1);
                    visiting[x][y] = false;
                }
            }
        }

    }
}
