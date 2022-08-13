package all.company.com.ReadyForDocumentation.ParkingLot;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ParkingLotAppTest {
    public static void main(String[] args) {
        List<String> commands = new ArrayList<>(Arrays.asList(
                "create_parking", "Parking 1",
                "create_floor", "1","G Floor",
                "create_floor", "1","1st Floor",
                "add_slot","1","1","A","CAR","GENERAL",
                "add_slot","1","1","B","CAR","GENERAL",
                "add_slot","1","1","C","CAR","HANDICAPPED",
                "add_slot","1","2","X","BIKE","GENERAL",
                "add_slot","1","2","Y","CAR","GENERAL",
                "add_slot","1","2","Z","BIKE","HANDICAPPED",
                "all_available_slot", "1",
                "do_booking","1","CAR","GENERAL","KA01HQ5385",
                "do_booking","1","CAR","GENERAL","KA01HQ5386",
                "out","1",
                "exit"
        ));
        passParams(commands);
        ParkingLotApp.main(new String[]{});
    }

    private static void passParams(final List<String> commands) {
        if(commands == null || commands.size() == 0){
            return;
        }
        StringBuilder sb = new StringBuilder(commands.get(0));
        for(int i = 1; i < commands.size(); i++){
            sb.append(System.lineSeparator()).append(commands.get(i));
        }
        System.setIn(new ByteArrayInputStream(sb.toString().getBytes()));
    }

}
