package all.company.com.top;
import java.util.HashSet;
import java.util.Set;


public class Q3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(longestSubstring(str));
    }

    //Hint: Using Hashset and keep checking
    private static int longestSubstring(final String str) {
        Set<Character> lookup = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = -1;
        while(j < str.length()){
            if(lookup.contains(str.charAt(j))){
                lookup.remove(str.charAt(i));
                i++;
            } else {
                lookup.add(str.charAt(j));
                j++;
                max = Integer.max(j-i, max);
            }
        }
        return max;
    }

}
