package all.company.com.MachineCoding.FoodKart;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FoodKartAppTest {
    public static void main(String[] args) {
        List<String> cmds = new ArrayList<>(Arrays.asList(
                "register_user",
                "Akshay", "Male", "8858886252", "284403",
                "register_user",
                "Akanksha", "Female", "7709078228", "560068",
                "login_user","1",
                "register_restaurant", "Anand Bhojnalaya", "284403, 560068", "Sweetcorn", "10", "5",
                "register_restaurant", "Arihant", "284403, 560068, 560102", "Crispy Corn", "15", "10",
                "rate_restaurant", "Anand Bhojnalaya", "3", "Test",
                "place_order", "Anand Bhojnalaya", "2",
                "show_restaurant", "rating",
                "order_history",
                "exit"
        ));
        passCommands(cmds);
        FoodKartApp.main(new String[]{"test"});
    }

    private static void passCommands(final List<String> cmds) {
        if(cmds == null || cmds.size() == 0){
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(cmds.get(0));
        int n = cmds.size();
        for(int i = 1; i < n ;i++){
            stringBuilder.append(System.getProperty("line.separator")).append(cmds.get(i));
        }
        System.setIn(new ByteArrayInputStream(stringBuilder.toString().getBytes()));
    }
}
