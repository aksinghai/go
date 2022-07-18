package all.company.com.Patterns.SlidingWindow;

import java.util.HashSet;
import java.util.Set;


public class Q6_NonRepeatingSubString {
    public static void main(String[] args) {
        String str = "abccde";
        System.out.println(nonRepeatingSubString(str));
    }

    private static int nonRepeatingSubString(final String str) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        while (j < str.length()){
            if(!set.contains(str.charAt(j))){
                set.add(str.charAt(j));
                max = Integer.max(max, j-i+1);
                j++;
            } else {
                set.remove(str.charAt(i));
                i++;
            }
        }
        return max;
    }
}
