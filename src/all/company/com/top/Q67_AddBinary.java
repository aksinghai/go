package all.company.com.top;

public class Q67_AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1101", "1111"));
    }

    public static String addBinary(String a, String b) {
        int m = a.length()-1;
        int n = b.length()-1;
        int c = 0;
        StringBuilder sum = new StringBuilder();
        while(m >= 0 && n >= 0){
            int r = ((int)a.charAt(m--)-'0') + ((int)b.charAt(n--)-'0') + c;
            c = 0;
            if(r > 1){
                if(r == 2) {
                    sum.insert(0,"0");
                } else {
                    sum.insert(0,"1");
                }
                c = 1;
            } else {
                sum.insert(0,r+"");
            }
        }
        while(m >= 0){
            int r = ((int)a.charAt(m--)-'0') + c;
            c = 0;
            if(r > 1){
                sum.insert(0,"0");
                c = 1;
            } else {
                sum.insert(0,r+"");
            }
        }

        while(n >= 0){
            int r = ((int)b.charAt(n--)-'0') + c;
            c = 0;
            if(r > 1){
                sum.insert(0,"0");
                c = 1;
            } else {
                sum.insert(0,r+"");
            }
        }

        if(c != 0){
            sum.insert(0,"1");
        }
        return sum.toString();
    }
}
