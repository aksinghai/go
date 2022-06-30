package all.company.com.top;

public class Q415_AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("1234","1235"));
    }

    public static String addStrings(String num1, String num2) {
        int c = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        String result = "";
        while(i >= 0 && j >= 0){
            int a = Integer.parseInt(num1.charAt(i--)+"");
            int b = Integer.parseInt(num2.charAt(j--)+"");
            int r = a+b+c;
            c = 0;
            if(r > 9){
                c = (int)r/10;
                r = r % 10;
            }
            result = r+result;
        }

        while(i >= 0){
            int a = Integer.parseInt(num1.charAt(i--)+"");
            int r = a+c;
            c = 0;
            if(r > 9){
                c = (int)r/10;
                r = r % 10;
            }
            result = r+result;
        }

        while (j >= 0){
            int b = Integer.parseInt(num2.charAt(j--)+"");
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

        return result;
    }
}
