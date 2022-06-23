package all.company.com.experiment;

/**
 After catching your classroom students cheating before, you realize your students are getting craftier and hiding words in 2D grids of letters. The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.

 Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.

 grid1 = [
 ['c', 'c', 't', 'n', 'a', 'x'],
 ['c', 'c', 'a', 't', 'n', 't'],
 ['a', 'c', 'n', 'n', 't', 't'],
 ['t', 'n', 'i', 'i', 'p', 'p'],
 ['a', 'o', 'o', 'o', 'a', 'a'],
 ['s', 'a', 'a', 'a', 'o', 'o'],
 ['k', 'a', 'i', 'o', 'k', 'i'],
 ]

 Visit = [
 [F, F, 't', 'n', 'a', 'x'],
 [T, 'c', 'a', 't', 'n', 't'],
 [T, 'c', 'n', 'n', 't', 't'],
 [T, T, 'i', 'i', 'p', 'p'],
 ['a', 'o', 'o', 'o', 'a', 'a'],
 ['s', 'a', 'a', 'a', 'o', 'o'],
 ['k', 'a', 'i', 'o', 'k', 'i'],
 ]


 word1 = "catnip"
 word2 = "cccc"
 word3 = "s"
 word4 = "ant"
 word5 = "aoi"
 word6 = "ki"
 word7 = "aaoo"
 word8 = "ooo"

 grid2 = [['a']]
 word9 = "a"

 find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
 find_word_location(grid1, word2) =>
 [(0, 0), (1, 0), (1, 1), (2, 1)]
 OR [(0, 0), (0, 1), (1, 1), (2, 1)]
 find_word_location(grid1, word3) => [(5, 0)]
 find_word_location(grid1, word4) => [(0, 4), (1, 4), (2, 4)] OR [(0, 4), (1, 4), (1, 5)]
 find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
 find_word_location(grid1, word6) => [(6, 4), (6, 5)]
 find_word_location(grid1, word7) => [(5, 2), (5, 3), (5, 4), (5, 5)]
 find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
 find_word_location(grid2, word9) => [(0, 0)]

 Complexity analysis variables:

 r = number of rows
 c = number of columns
 w = length of the word
 */

public class GridProblem {
    public static void main(String[] argv) {
        char[][] grid1 = {
                { 'c', 'c', 't', 'n', 'a', 'x' },
                { 'c', 'c', 'a', 't', 'n', 't' },
                { 'a', 'c', 'n', 'n', 't', 't' },
                { 't', 'n', 'i', 'i', 'p', 'p' },
                { 'a', 'o', 'o', 'o', 'a', 'a' },
                { 's', 'a', 'a', 'a', 'o', 'o' },
                { 'k', 'a', 'i', 'o', 'k', 'i' }
        };
        String word1 = "catnip";
        String word2 = "cccc";
        String word3 = "s";
        String word4 = "ant";
        String word5 = "aoi";
        String word6 = "ki";
        String word7 = "aaoo";
        String word8 = "ooo";

        char[][] grid2 = { { 'a' } };
        String word9 = "a";

        //System.out.println(find_word_location(grid1,word1));
    }

    /*private static String find_word_location(char[][] grid1, String word1){
        if(word1 == null || word1.isEmpty()) {
            return "";
        }

        boolean[][] visit = new boolean[grid1.length][grid1[0].length];
        String path = "";
        for(int i = 0; i < grid1.length; i++){
            for(int j = 0; j < grid1[i].length; j++){
                if(grid1[i][j] == word1.charAt(0)){
                    find_word(grid1, word1, i, j, 1, visit,path);
                }
            }
        }
    }

    private static void find_word(char[][] grid1, String word1, int x, int y, int a, boolean[][] visit, String path){
        if(a == word1.length()){
            return path;
        }

        if(x+1 < grid1[0].length && grid1[x+1][y] == word1.length() && !visit[x+1][y]){
            visit[x+1][y] = true;
            find_word(grid1, word1, x+1, y, a+1, visit, path);
            }
        }

        return null;

    }*/

}

