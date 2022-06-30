package all.company.com.top;

public class Q44_WildcardMatching {
    public static void main(String[] args) {
        String string = "aa";
        String pattern = "*";

        System.out.println(wildcardMatching(string, pattern, 0, 0, string.length(), pattern.length(), '\u0000'));;
    }

    private static boolean wildcardMatching(String string, String pattern, int i, int j, int m, int n, char lastChar){
        if(i == m && j == n){
            return true;
        } else if (i == m || j == n) {
            return false;
        }
        if(pattern.charAt(j) == '?'){
            return wildcardMatching(string, pattern, i+1, j+1, m, n, string.charAt(i));
        } else if(pattern.charAt(j) == '*'){
            if((lastChar == string.charAt(i) || lastChar == '\u0000') && i != m-1){
                return (wildcardMatching(string, pattern, i+1, j, m, n, lastChar));
            } else {
                return wildcardMatching(string, pattern, i+1, j+1, m, n, string.charAt(i));
            }
        } else {
            if(string.charAt(i) != pattern.charAt(j)){
                return false;
            } else {
                return wildcardMatching(string, pattern, i+1, j+1, m, n, string.charAt(i));
            }
        }
    }
}
