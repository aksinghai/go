package test.junk;

public class ShortestPathInAGrid {

    //Cashfree
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,2},
                {1,1,6}
        };
        System.out.println(findShortestPath(grid, 0, 0, grid.length-1, grid[0].length-1));
    }

    private static int findShortestPath(int[][] grid, int cx, int cy, int tx, int ty){
        if(cx == tx && cy == ty){
            return grid[cx][cy];
        }
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(cy+1 < grid[0].length){
            right = findShortestPath(grid, cx, cy+1, tx, ty) + grid[cx][cy] ;
        }
        if (cx+1 < grid.length){
            down =  findShortestPath(grid, cx+1, cy, tx, ty) + grid[cx][cy];
        }
        return Integer.min(right, down);
    }
}
