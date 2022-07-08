package all.company.com.top;

public class Q44_WildcardMatching {
    public static void main(String[] args) {
        String string = "adceb";
        String pattern = "c*a*b";
        System.out.println(isMatch(string, pattern));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] grid = new boolean[p.length()+1][s.length()+1];
        grid[0][0] = true;
        for(int i = 1; i < grid.length; i++){
            if(p.charAt(i-1) == '*'){
                grid[i][0] = grid[i-1][0];
            } else {
                grid[i][0] = false;
            }
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[i].length; j++){
                if(p.charAt(i-1) == '*') {
                    grid[i][j] = grid[i-1][j-1] || grid[i][j-1] || grid[i-1][j];
                } else if(p.charAt(i-1) == '?') {
                    grid[i][j] = grid[i-1][j-1];
                } else {
                    if(p.charAt(i-1) == s.charAt(j-1)){
                        grid[i][j] = grid[i-1][j-1];
                    } else {
                        grid[i][j] = false;
                    }
                }
            }
        }

        return grid[p.length()][s.length()];
    }
}
