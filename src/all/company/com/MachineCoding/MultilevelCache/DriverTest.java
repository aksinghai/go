package all.company.com.MachineCoding.MultilevelCache;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Test Class
public class DriverTest {
    public static void main(String[] args) {
        List<String> commands = new ArrayList<>(Arrays.asList(
                "init", "3" , "1,2,3",
                "get", "key1",
                "contains", "key1",
                "set_eviction", "LFU",
                "set", "key1", "val1",
                "get", "key1",
                "set", "key2", "val2",
                "set", "key3", "val3",
                "set", "key4", "val4",
                "set", "key5", "val5",
                "set", "key6", "val6",
                "set", "key7", "val7",
                "contains", "key7",
                "delete","key1",
                "get", "key1",
                "exit"
        ));
        passCLA(commands);
        Driver.main(new String[]{});
    }

    private static void passCLA(final List<String> commands) {
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
