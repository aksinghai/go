package test.junk.Dunzo;

import java.util.LinkedList;
import java.util.Queue;


public class Problem2 {
    public static void main(String[] args) {
        int[][] arr = {
                {1 , 1 , 1 , 0 , 0},
                {1 , 1 , 0 , 0 , 0},
                {0 , 1 , 0 , 1 , 1},
                {0 , 0 , 0 , 1 , 1}
        };
        System.out.println(findServiceableAreas(arr));
    }

    private static int findServiceableAreas(final int[][] arr) {
        Queue<String> queue = new LinkedList<>();
        int ctr = 2;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0 ; j < arr[i].length; j++){
                if(arr[i][j] == 1){
                    queue.add(i+"_"+j);
                    while (!queue.isEmpty()){
                        String[] splited = queue.remove().split("_");
                        int k = Integer.parseInt(splited[0]);
                        int l = Integer.parseInt(splited[1]);
                        arr[k][l] = ctr;
                        if(k - 1 >= 0 && arr[k-1][l] == 1){
                            queue.add((k-1)+"_"+l);
                        }
                        if(l +1 < arr[0].length && arr[k][l+1] == 1){
                            queue.add((k)+"_"+(l+1));
                        }
                        if(k + 1 < arr.length && arr[k+1][l] == 1){
                            queue.add((k+1)+"_"+l);
                        }
                        if(l-1 >= 0 && arr[k][l-1] == 1){
                            queue.add((k)+"_"+(l-1));
                        }
                    }
                    ctr++;
                }
            }
        }
        return ctr - 2;
    }
}
