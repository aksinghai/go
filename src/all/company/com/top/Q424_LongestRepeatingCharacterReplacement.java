package all.company.com.top;

public class Q424_LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s =
                "AABABBA";
        int K = 1;
        System.out.println(subStringAfterReplacement(s, K));
    }

    private static int subStringAfterReplacement(final String s, final int k) {
        int[] lookup = new int[26];
        int i = 0;
        int j = 0;
        int max = 0;
        int maxFreq = 0;
        while (j < s.length()){
            int index = s.charAt(j)-'A';
            lookup[index]++;
            maxFreq = Integer.max(lookup[index], maxFreq);
            if((j-i+1)-maxFreq > k){
                index = s.charAt(i++)-'A';
                lookup[index]--;
            }
            max = Integer.max(max, j-i+1);
            j++;
        }
        return max;
    }
}
