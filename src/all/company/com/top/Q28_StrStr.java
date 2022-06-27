package all.company.com.top;

public class Q28_StrStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "llo";
        System.out.println(strstr(haystack, needle));
    }

    private static int strstr(final String haystack, final String needle) {
        int i = 0;
        while (i < haystack.length()){
            int j = 0;
            while (i+j < haystack.length() && j < needle.length() && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }
            if(needle.length() == j){
                return i;
            }
            i++;
        }
        return -1;
    }
}
