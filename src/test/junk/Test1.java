package test.junk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        int n = 15;
        int headID = 0;
        int[] manager = new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }

    /*public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Integer> reportMap  = new HashMap<>();
        for(int i = 0; i < n; i++){
            reportMap.put(i, manager[i]);
        }
        int max = 0;
        Map<Integer, Integer> timeTaken = new HashMap<>();
        for(int i = 0; i <  n; i++){
            if(i == headID){
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            int sum = 0;
            while (!queue.isEmpty()){
                int c = queue.remove();
                if(timeTaken.containsKey(c)){
                    sum += timeTaken.get(c);
                    continue;
                }
                if(reportMap.containsKey(c)){
                    sum += informTime[reportMap.get(c)];
                    if(reportMap.get(c) != headID){
                        queue.add(reportMap.get(c));
                    }
                }
            }
            timeTaken.put(i, sum);
            max = Integer.max(max, sum);
        }
        return max;
    }*/

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for(int i = 0; i < manager.length; i++){
            if(manager[i] >= 0){
                List<Integer> list;
                if(adjMap.containsKey(manager[i])){
                    list = adjMap.get(manager[i]);
                } else {
                    list = new ArrayList<>();
                }
                list.add(i);
                adjMap.put(manager[i], list);
            }
        }
        return getMaxPath(adjMap, headID, informTime);
    }

    private static int getMaxPath(Map<Integer, List<Integer>> adjMap, int id, int[] informTime){
        if(adjMap.containsKey(id)){
            int max = 0;
            for(int i : adjMap.get(id)){
                max = Integer.max(max, getMaxPath(adjMap, i, informTime) + informTime[id]);
            }
            return max;
        } else {
            return 0;
        }
    }
}