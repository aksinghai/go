package all.company.com.top;

public class Q14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    /*
    Hint: Take first char from string one and check with other strings in sequence O(n*m)
     */
    private static String longestCommonPrefix(final String[] strs) {
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(true){
            if(j >= strs[0].length()){
                break;
            }
            char c = strs[0].charAt(j);
            boolean allMatch = true;
            for(int i = 1; i < strs.length; i++){
                if(j < strs[i].length()) {
                    if(c != strs[i].charAt(j)) {
                        allMatch = false;
                        break;
                    }
                } else {
                    allMatch = false;
                    break;
                }
            }
            if(!allMatch){
                break;
            } else {
                sb.append(c);
                j++;
            }
        }
        return sb.toString();
    }
}
