package all.company.com.top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        String string = "abbcabc";
        String pattern = "abc";
        System.out.println(permutePatternMatch(string, pattern));
    }

    private static List<Integer> permutePatternMatch(String s, String p){
        Map<Character, Integer> patternCount = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            int c = 0;
            if(patternCount.containsKey(p.charAt(i))){
                c = patternCount.get(p.charAt(i));
            }
            patternCount.put(p.charAt(i), c+1);
        }
        Map<Character, Integer> patternCopy = new HashMap<>(patternCount);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (j < s.length()){
            if(patternCopy.containsKey(s.charAt(j))){
                char c = s.charAt(j);
                if(patternCopy.get(s.charAt(j)) == 1){
                    patternCopy.remove(s.charAt(j));
                } else {
                    patternCopy.put(s.charAt(j), patternCopy.get(s.charAt(j)) - 1);
                }
                if(patternCopy.isEmpty()){
                    list.add(i);
                    if(patternCount.get(s.charAt(i)) != null) {
                        patternCopy.put(s.charAt(i), 1);
                    }
                    i++;
                }
                j++;
            } else {
                int c = 0;
                if(patternCopy.containsKey(s.charAt(i))){
                    c = patternCopy.get(s.charAt(i));
                }
                if(patternCount.get(s.charAt(i)) != null && c < patternCount.get(s.charAt(i))) {
                    patternCopy.put(s.charAt(i), c+1);
                } else {
                    j++;
                }
                i++;
            }
        }
        return list;
    }
}
