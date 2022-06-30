package all.company.com.top;

public class Q43_MultiplyStrings {
    public static void main(String[] args) {

        System.out.println(multiply2("123","456"));
    }

    public static String multiply(String num1, String num2) {
        int m = num2.length();
        int n = num1.length();
        StringBuilder current = new StringBuilder();
        StringBuilder previous = new StringBuilder();
        for(int i = m-1; i >= 0 ;i--){
            for(int x = 0; x < m-i-1; x++){
                current.append("0");
            }
            int gCarry = 0;
            for(int j = n-1; j >= 0 ;j--){
                int k = (int)(num1.charAt(j) - '0');
                int l = (int)(num2.charAt(i) - '0');
                int r = (k * l) + gCarry;
                gCarry = 0;
                if(r > 9){
                    gCarry = (int)r/10;
                    r = r % 10;
                }
                current.insert(0, r);
            }
            if(gCarry != 0){
                current.insert(0, gCarry);
            }
            previous = stringSum(current,previous);
            current = new StringBuilder();
        }
        return previous.toString();
    }

    private static StringBuilder stringSum(final StringBuilder current, final StringBuilder previous) {
        int c = 0;
        int i = previous.length() - 1;
        int j = current.length() - 1;
        String result = "";
        while(i >= 0 && j >= 0){
            int a = Integer.parseInt(previous.charAt(i--)+"");
            int b = Integer.parseInt(current.charAt(j--)+"");
            int r = a+b+c;
            c = 0;
            if(r > 9){
                c = (int)r/10;
                r = r % 10;
            }
            result = r+result;
        }

        while(i >= 0){
            int a = Integer.parseInt(previous.charAt(i--)+"");
            int r = a+c;
            c = 0;
            if(r > 9){
                c = (int)r/10;
                r = r % 10;
            }
            result = r+result;
        }

        while (j >= 0){
            int b = Integer.parseInt(current.charAt(j--)+"");
            int r = b+c;
            c = 0;
            if(r > 9){
                c = (int)r/10;
                r = r % 10;
            }
            result = r+result;
        }

        if(c != 0){
            result = c+result;
        }

        return new StringBuilder(result);
    }


    public static String multiply2(String num1, String num2) {
        if(Integer.parseInt(num1) == 0 || Integer.parseInt(num2) == 0){
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();
        StringBuilder result = new StringBuilder();

        for(int i = l1-1; i >= 0; i--){
            StringBuilder currentProduct = new StringBuilder();
            int x = num1.charAt(i) - '0';
            for(int j = l2-1; j >= 0; j--){
                int y = num2.charAt(j) - '0';
                int r = x * y;
                currentProduct.append(r);
                for(int k = 0; k < ((l1-i-1) + (l2-j-1)); k++) {
                    currentProduct.append("0");
                }
                result = stringSum(currentProduct, result);
                currentProduct = new StringBuilder();
            }
        }
        return result.toString();
    }
}
