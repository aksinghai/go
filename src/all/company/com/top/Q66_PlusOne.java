package all.company.com.top;

import java.util.Arrays;


public class Q66_PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }

    public static int[] plusOne(int[] digits) {
        int i = digits.length;
        int c = 1;
        boolean changed = false;
        while(i-->0){
            if(digits[i] + c > 9){
                int r = digits[i] + c;
                c = (int)r / 10;
                digits[i] = r % 10;
                System.out.println(c);
            } else {
                digits[i] += c;
                c = 0;
            }
        }
        if(c == 0) {
            return digits;
        } else {
            int[] dgts = new int[digits.length+1];
            dgts[0] = c;
            for(int j = 1; j <= digits.length ; j++){
                dgts[j] = digits[j-1];
            }
            return dgts;
        }
    }
}
