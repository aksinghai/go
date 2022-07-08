package test.junk;/*
Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

Example:
logs1 = [
    ["58523", "user_1", "resource_1"],
    ["62314", "user_2", "resource_2"],
    ["54001", "user_1", "resource_3"],
    ["200", "user_6", "resource_5"],
    ["215", "user_6", "resource_4"],
    ["54060", "user_2", "resource_3"],
    ["53760", "user_3", "resource_3"],
    ["58522", "user_22", "resource_1"],
    ["53651", "user_5", "resource_3"],
    ["2", "user_6", "resource_1"],
    ["100", "user_6", "resource_6"],
    ["400", "user_7", "resource_2"],
    ["100", "user_8", "resource_6"],
    ["54359", "user_1", "resource_3"],
]

Example 2:
logs2 = [
    ["300", "user_1", "resource_3"],
    ["599", "user_1", "resource_3"],
    ["900", "user_1", "resource_3"],
    ["1199", "user_1", "resource_3"],
    ["1200", "user_1", "resource_3"],
    ["1201", "user_1", "resource_3"],
    ["1202", "user_1", "resource_3"]
]
i -> 1
j -> 3



Map<String, Integer> lookupMap
resource_3, 599


Map<String, Integer> countMap
resource_3, 2




Example 3:
logs3 = [
    ["300", "user_10", "resource_5"]
]

Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.

Expected Output:
most_requested_resource(logs1) # => ('resource_3', 3) [resource_3 is accessed at 53760, 54001, and 54060]
most_requested_resource(logs2) # => ('resource_3', 4) [resource_3 is accessed at 1199, 1200, 1201, and 1202]
most_requested_resource(logs3) # => ('resource_5', 1) [resource_5 is accessed at 300]

Complexity analysis variables:

n: number of logs in the input
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1 {
    public static void main(String[] argv) {
        String[][] logs1 = new String[][] {
                { "58523", "user_1", "resource_1" },
                { "62314", "user_2", "resource_2" },
                { "54001", "user_1", "resource_3" },
                { "200", "user_6", "resource_5" },
                { "215", "user_6", "resource_4" },
                { "54060", "user_2", "resource_3" },
                { "53760", "user_3", "resource_3" },
                { "58522", "user_22", "resource_1" },
                { "53651", "user_5", "resource_3" },
                { "2", "user_6", "resource_1" },
                { "100", "user_6", "resource_6" },
                { "400", "user_7", "resource_2" },
                { "100", "user_8", "resource_6" },
                { "54359", "user_1", "resource_3"},
        };

        String[][] logs2 = new String[][] {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

        String[][] logs3 = new String[][] {
                {"300", "user_10", "resource_5"}
        };

        System.out.println(calculateResourceUsed(logs1));
    /*Map<String, List<Integer>> lookup = getInfo(logs3);
    for(Map.Entry<String, List<Integer>> e : lookup.entrySet()){
      System.out.println(e.getKey()+":"+e.getValue());
    }*/
    }


    private static String calculateResourceUsed(String[][] logs){
        if(logs.length == 1){
            return logs[0][2]+" "+1;
        }
        Map<String, Integer> lookup = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        int i = 0;
        int j = 0;

        Arrays.sort(logs, (o1,o2) -> Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));
        int max = 0;
        String resource = "";
        while ( j < logs[0].length ){
            if(!lookup.containsKey(logs[j][2])){
                lookup.put(logs[j][2], Integer.parseInt(logs[j][0]));
                count.put(logs[j][2], 1);
                if(max <= count.get(logs[j][2])){
                    max = Integer.max(count.get(logs[j][2]), max);
                    resource = logs[j][2];
                }
            } else {
                if(lookup.get(logs[j][2]) - Integer.parseInt(logs[j][0]) > 300){
                    while (i <= j && lookup.get(logs[i][2]) - Integer.parseInt(logs[i][0]) > 300){
                        int c = count.get(logs[i][2]);
                        if(c == 1){
                            count.remove(logs[i][2]);
                            lookup.remove(logs[i][2]);
                        } else {
                            count.put(logs[i][2], count.get(logs[i][2]) - 1);
                        }
                        i++;
                    }
                } else {
                    count.put(logs[j][2], count.get(logs[j][2]) + 1);
                    if(max <= count.get(logs[j][2])){
                        max = Integer.max(count.get(logs[j][2]), max);
                        resource = logs[j][2];
                    }
                    j++;
                }
            }
        }
        return resource + " "+max;
    }




    private static Map<String, List<Integer>> getInfo(String[][] logs){
        Map<String, List<Integer>> lookup = new HashMap<>();
        for(String[] s : logs){
            if(s.length != 3){
                System.out.println("Incorrect");
                return null;
            }
            if(!lookup.containsKey(s[1])){
                int timestamp = Integer.parseInt(s[0]);
                lookup.put(s[1], new ArrayList<>(Arrays.asList(timestamp, timestamp)));
            } else {
                List<Integer> lookupList = lookup.get(s[1]);
                int num = Integer.parseInt(s[0]);
                int min = Integer.min(num, lookupList.get(0));
                int max = Integer.max(num, lookupList.get(1));
                lookup.put(s[1], new ArrayList<>(Arrays.asList(min, max)));
            }
        }
        return lookup;
    }
}