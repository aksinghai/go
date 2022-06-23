package all.company.com.top;

import java.util.Stack;


public class Q32_LongestValidParenthesis {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }

    public static int longestValidParentheses(String s) {
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j < s.length(); j++){
                if(isValidParentheses(s.substring(i, j+1))){
                    max = Integer.max(max, (j-i+1));
                }
            }
        }
        return max;
    }

    private static boolean isValidParentheses(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty() || stack.pop().equals(s.charAt(i))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
