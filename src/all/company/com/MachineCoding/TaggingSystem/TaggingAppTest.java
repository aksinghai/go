package all.company.com.MachineCoding.TaggingSystem;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TaggingAppTest {
    public static void main(String[] args) {
        List<String> commands = new ArrayList<>(Arrays.asList(
                "post","This is my #india and I love my #country",
                "get_post", "1",
                "get_tags",
                "exit"
        ));
        passConsoleInput(commands);
        TaggingApp.main(new String[]{});
    }

    private static void passConsoleInput(final List<String> commands) {
        if(commands == null || commands.size() == 0){
            return;
        }
        StringBuilder sb = new StringBuilder(commands.get(0));
        for(int i = 1; i < commands.size(); i++) {
            sb.append(System.lineSeparator()).append(commands.get(i));
        }
        System.setIn(new ByteArrayInputStream(sb.toString().getBytes()));
    }
}
