package all.company.com.experiment;

import java.util.HashMap;
import java.util.Map;


public class SortedMapExperiment {
    public static void main(String[] args) {
        TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        q(3);
        q(12);
        q(25);
        q(15);
        q(24);
        q(8);
    }

    static Map<Integer, Map<Integer, Integer>> lookup = new HashMap<>();
    private static void TopVotedCandidate(int[] persons, int[] times) {
        for(int i = 0; i < persons.length; i++){
            Map<Integer, Integer> map;
            if(i != 0) {
                map = new HashMap<>(lookup.get(times[i - 1]));
                if(map.containsKey(persons[i])){
                    map.put(persons[i], map.get(persons[i])+1);
                } else {
                    map.put(persons[i], 1);
                }
            } else {
                map = new HashMap<>();
                map.put(persons[i], 1);
            }
            lookup.put(times[i], map);
        }
        //System.out.println(lookup);
    }

    public static int q(int t) {
        System.out.print("=>"+t);
        for(int i = t; i >=0; i--){
            if(lookup.containsKey(i)){
                int lead = -1;
                for(Map.Entry<Integer, Integer> entry : lookup.get(i).entrySet()){
                    if(lead == -1 || entry.getValue() >= lookup.get(i).get(lead)){
                        lead = entry.getKey();
                    }
                }
                System.out.println(" : "+lead);
                return lead;
            }
        }
        return -1;
    }
}
