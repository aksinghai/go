package all.company.com.top;

public class Q38_CountAndSay {
    public static void main(String[] args) {
        getString("1", 1, 4);
    }

    private static String getString(String s, int a, int n){
        if(a == n){
            return s;
        }
        int ctr = 1;
        StringBuilder ss= new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                ctr++;
            } else {
                ss.append(ctr).append((int) s.charAt(i) - '0');
                ctr = 1;
            }
        }
        return getString(ss.toString(), a+1, n);
    }
}
