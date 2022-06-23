package all.company.com.MachineCoding.Tinder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AppDriverTest {
    public static void main(String[] args) {
        List<String> commandList = new ArrayList<>(Arrays.asList(
                "create_account", "user_A", "2", "3", "23", "Male",
                "create_account", "user_B", "3", "4", "45", "Female",
                "create_account", "user_C", "4", "6", "32", "Female",
                "create_account", "user_D", "7", "8", "23", "Male",
                "create_account", "user_E", "8", "12", "23", "Female",
                "potential_match", "user_A",
                "like", "user_A", "user_B",
                "like", "user_A", "user_C",
                "potential_match", "user_B",
                "like", "user_B", "user_A",
                "show_match", "user_A",
                "potential_match", "user_E",
                "like", "user_E", "user_D",
                "potential_match", "user_D",
                "like", "user_D", "user_E",
                "show_all_matches",
                "potential_match", "user_C",
                "like", "user_C", "user_A",
                "show_all_matches",
                "delete_account","user_A",
                "show_all_matches",
                "exit"
        ));
        passCmdArgs(commandList);
        AppDriver.main(new String[]{"test"});
    }

    private static void passCmdArgs(final List<String> commandList) {
        if(commandList == null || commandList.isEmpty()){
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(commandList.get(0));
        for(int i = 1; i < commandList.size(); i++){
            stringBuilder.append(System.lineSeparator()).append(commandList.get(i));
        }
        System.setIn(new ByteArrayInputStream(stringBuilder.toString().getBytes()));
    }

}
