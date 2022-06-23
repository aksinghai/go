package all.company.com.top;

public class Q5_LongestPalindromicSubString {
    public static void main(String[] args) {
        String str = "a";
        System.out.println(longestPalindromicSubstring(str));
    }

    /* Hint : Check both side if palindromic
     */
    private static String longestPalindromicSubstring(final String str) {
        int max = -1;
        String s = "";
        for(int i = 0; i < str.length(); i++){
            String ss = expand(str, i);
            int length = ss.length();
            if(max < length){
                s = ss;
                max = length;
            }
        }
        return s;
    }

    private static String expand(String str, int k){
        int i = k;
        int j = k;
        while(i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)){
            i--;
            j++;
        }
        return str.substring(i+1, j);
    }
}
