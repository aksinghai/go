package test.junk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

//Atlessian
public class VotingQuestion {
    public static void main(String[] args) {
        Map<String, List<String>> voteList = new HashMap<>();
        voteList.put("A1", new ArrayList<>(Arrays.asList("P1", "P2", "P3")));
        voteList.put("A2", new ArrayList<>(Arrays.asList("P3", "P1", "P4")));
        voteList.put("A3", new ArrayList<>(Arrays.asList("P2", "P3", "P4")));
        castVote(voteList);
        printWinner();
        printAllParticipants();
    }

    static TreeMap<String, Integer> weightedVoteSortedMap = new TreeMap<>();
    static Map<String, Integer> weightedVoteMap = new HashMap<>();
    static int[] weights = new int[]{4,2,1};
    private static String castVote(Map<String, List<String>> voteList) {
        String winner = null;
        Integer maxVote = 0;
        for(Map.Entry<String, List<String>> entry : voteList.entrySet()){
            for(int i = 0; i < entry.getValue().size(); i++){
                int weightedVote = 0;
                String participant = entry.getValue().get(i);
                if(weightedVoteMap.containsKey(participant)){
                    weightedVote = weightedVoteMap.get(participant);
                }
                weightedVoteMap.put(participant, weightedVote + weights[i]);
                if(weightedVote+ weights[i] > maxVote){
                    maxVote = weightedVote + weights[i];
                    winner = participant;
                }
            }
        }
        return winner;
    }

    private static void printWinner(){
        if(weightedVoteMap.isEmpty()){
            return;
        }
        String winner = null;
        Integer weightedMaxVote = 0;
        for(Map.Entry<String, Integer> entry : weightedVoteMap.entrySet()){
            if(entry.getValue() > weightedMaxVote){
                weightedMaxVote = entry.getValue();
                winner = entry.getKey();
            }
        }
        System.out.println(winner);
    }

    //TODO
    private static void printAllParticipants() {
        List<String> list = new ArrayList<>();
        Map<String, Integer> sortedMap = new TreeMap<>(weightedVoteMap);
        System.out.println(entriesSortedByValues(sortedMap));
        SortedSet<Map.Entry<String, Integer>> entrySortedSet =
                new TreeSet<>(weightedVoteMap.entrySet());
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(entrySortedSet);
        Collections.sort(entries, (o1, o2) -> o2.getValue() - o1.getValue());
        System.out.println(entries);
    }



    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<>(
                new Comparator<Map.Entry<K, V>>() {
                    @Override public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                        int res = e2.getValue().compareTo(e1.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}




/*
a1 -> p2,p3,p4

p2 -> 4
p3 -> 2
p4 -> 1




 */


/*
u1 2*4
u2 2*2
 */