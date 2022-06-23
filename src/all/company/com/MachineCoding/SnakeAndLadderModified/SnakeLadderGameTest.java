package all.company.com.MachineCoding.SnakeAndLadderModified;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SnakeLadderGameTest {

    public static void main(String[] args) {
        List<String> commands = new ArrayList<>(Arrays.asList(
                "create_game","10","4",
                "play", "game_1",
                "create_game","10","2",
                "play", "game_2",
                "exit"
        ));
        setParams(commands);
        SnakeLadderGame.main(new String[]{"test"});
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
