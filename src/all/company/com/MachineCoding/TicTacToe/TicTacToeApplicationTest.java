package all.company.com.MachineCoding.TicTacToe;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeApplicationTest {

    public static void main(String[] args) {
        List<String> commands = new ArrayList<>(Arrays.asList(
                "play", "Akshay", "Akanksha", "3",
                "0","0",
                "0","1",
                "1","1",
                "0","2",
                "2", "2",
                "play", "Akshay", "Akanksha", "3",
                "0","0",
                "0","1",
                "1","1",
                "0","2",
                "2", "2"
        ));
        passParams(commands);
        TicTacToeApplication.main(new String[]{});
    }

    private static void passParams(final List<String> commands) {
        if(commands == null || commands.isEmpty()){
            return;
        }

        StringBuilder sb = new StringBuilder(commands.get(0));
        for(int i = 1; i < commands.size(); i++){
            sb.append(System.lineSeparator()).append(commands.get(i));
        }
        System.setIn(new ByteArrayInputStream(sb.toString().getBytes()));
    }

}
