package all.company.com.MachineCoding.TinyUrl;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TinyUrlDriverTest {
    public static void main(String[] args) {
        List<String> commands = new ArrayList<>(Arrays.asList(
                "alias_available","akshay",
                "create_alias","akshay","https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/",
                "get_alias","akshay",
                "get_alias","akshay",
                "get_alias","akshay",
                "get_alias","akshay",
                "sleep","1000",
                "get_alias","akshay",
                "sleep","1000",
                "get_alias","akshay",
                "exit"
        ));
        passCommands(commands);
        TinyUrlDriver.main(new String[]{});
    }

    private static void passCommands(final List<String> commands) {
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
