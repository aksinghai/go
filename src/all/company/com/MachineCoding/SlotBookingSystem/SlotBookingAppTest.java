package all.company.com.MachineCoding.SlotBookingSystem;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SlotBookingAppTest {

    public static void main(String[] args) {
        List<String> commands = new ArrayList<>(Arrays.asList(
                "create_user", "A1",
                "create_user", "A2",
                "create_user", "A3",
                "create_activity", "Yoga",
                "create_activity", "Gym",
                "create_activity", "Dance",
                "create_slot","1","Morning Slot", "2",
                "create_slot","2","Evening Slot", "1",
                "book_slot", "1","1",
                "book_slot", "1","2",
                "book_slot", "1","3",
                "book_slot", "2","1",
                "book_slot", "2","3",
                "cancel_slot", "1","1",
                "book_slot", "3","1",
                "exit"
        ));
        passParams(commands);
        SlotBookingApp.main(new String[]{"test"});

    }

    private static void passParams(final List<String> commands) {
        if(commands == null || commands.isEmpty()){
            return;
        }
        StringBuilder sb = new StringBuilder(commands.get(0));
        for(int i = 1; i < commands.size();i++){
            sb.append(System.lineSeparator()).append(commands.get(i));
        }
        System.setIn(new ByteArrayInputStream(sb.toString().getBytes()));
    }
}
