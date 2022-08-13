package all.company.com.Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;


public class Q9_PermutationInAString {
    public static void main(String[] args) {
        String string = "oidbcbfacbf";
        String pattern = "abc";
        System.out.println(permutePatternMatch(pattern, string));
    }

    private static boolean permutePatternMatch(String s1, String s2){
        Map<Character, Integer> patternCount = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            int c = 0;
            if(patternCount.containsKey(s1.charAt(i))){
                c = patternCount.get(s1.charAt(i));
            }
            patternCount.put(s1.charAt(i), c+1);
        }
        Map<Character, Integer> patternCopy = new HashMap<>(patternCount);
        int i = 0;
        int j = 0;
        while (j < s2.length()){
            if(patternCopy.containsKey(s2.charAt(j))){
                if(patternCopy.get(s2.charAt(j)) == 1){
                    patternCopy.remove(s2.charAt(j));
                } else {
                    patternCopy.put(s2.charAt(j), patternCopy.get(s2.charAt(j)) - 1);
                }
                if(patternCopy.isEmpty()){
                    return true;
                }
                j++;
            } else {
                int c = 0;
                if(patternCopy.containsKey(s2.charAt(i))){
                    c = patternCopy.get(s2.charAt(i));
                }
                if(patternCount.get(s2.charAt(i)) != null && c < patternCount.get(s2.charAt(i))) {
                    patternCopy.put(s2.charAt(i), c+1);
                } else {
                    j++;
                }
                i++;
            }
        }
        return false;
    }
}
