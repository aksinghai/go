package all.company.com.MachineCoding.SnakeAndLadder.service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import all.company.com.MachineCoding.SnakeAndLadder.SnackAndLadderDriver;


public class SnakeAndLadderDriverTest {
    public static void main(String[] args) {
        List<String> commands = new ArrayList<>(Arrays.asList(
                "init",
                "2",
                "Akshay",
                "Akanksha",
                "run"
        ));
        setParams(commands);
        SnackAndLadderDriver.main(new String[]{});
    }

    private static void setParams(final List<String> commands) {
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
