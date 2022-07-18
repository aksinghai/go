package all.company.com.Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;


public class Q4_KDistinctCharacters {
    public static void main(String[] args) {
        String s = "aaaaaa";
        int K = 2;
        System.out.println(longestStringWithKDistinctChar(s, K));
    }

    private static int longestStringWithKDistinctChar(String s, int K){
        Map<Character, Integer> charLookup = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        while (j < s.length()){
            char headChar = s.charAt(j);
            if(charLookup.containsKey(headChar)){
                charLookup.put(headChar,charLookup.get(headChar)+1);
                max = Integer.max(max, (j-i+1));
                j++;
            } else {
                if(charLookup.size() == K) {
                    char backChar = s.charAt(i);
                    int c = charLookup.get(backChar);
                    if (c == 1) {
                        charLookup.remove(backChar);
                    } else {
                        charLookup.put(backChar, charLookup.get(backChar) - 1);
                    }
                    i++;
                } else {
                    charLookup.put(headChar, 1);
                    max = Integer.max(max, (j-i+1));
                    j++;
                }
            }
        }
        return max;
    }
}
