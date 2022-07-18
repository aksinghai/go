package all.company.com.Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;


public class Q7_MaxSubStringAfterReplacement {
    public static void main(String[] args) {
        String s =
                "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        int K = 4;
        System.out.println(maxSubStringAfterReplacementOfSameChar(s, K));
    }

    private static int maxSubStringAfterReplacementOfSameChar(final String s, final int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        char maxFrequency = '\u0000';
        while (j < s.length()){
            if(map.containsKey(s.charAt(j)) && (maxFrequency == s.charAt(j) || (j - i) - map.get(maxFrequency) < k)){
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                j++;
                max = Integer.max(max, (j-i));
                maxFrequency = checkMaxFrequency(map);
            } else {
                if(map.size() < 2){
                    map.put(s.charAt(j++), 1);
                    max = Integer.max(max, (j-i));
                    maxFrequency = checkMaxFrequency(map);
                } else {
                    int c = map.get(s.charAt(i));
                    if(c == 1){
                        map.remove(s.charAt(i));
                    } else {
                        map.put(s.charAt(i), c-1);
                    }
                    maxFrequency = checkMaxFrequency(map);
                    i++;
                }
            }
        }
        return max;
    }

    private static char checkMaxFrequency(Map<Character, Integer> map) {
        int max = 0;
        char c = '\u0000';
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(max < entry.getValue()){
                max = entry.getValue();
                c = entry.getKey();
            }
        }
        return c;
    }
}
