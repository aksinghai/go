package all.company.com.MachineCoding.LRU;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LRUCacheTest {
    public static void main(String[] args) {
        List<String> commandList = new ArrayList<>(Arrays.asList(
           "create-user", "Akshay",
           "create-user", "Akanksha",
            "create-user", "Allu",
            "create-user", "Aalishan",
            "create-user", "Abhishek",
            "create-user", "Shankar",
            "add-log", "1",
            "add-log", "2",
            "add-log", "3",
            "add-log", "4",
            "add-log", "5",
            "add-log", "6",
            "add-log", "1",
            "add-log", "2",
            "get-user",
            "exit"
        ));
        passParams(commandList);
        LRUCache.main(new String[]{"test"});
    }

    private static void passParams(List<String> commandList) {
        if(commandList == null || commandList.size() == 0){
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(commandList.get(0));
        for(int i = 1; i < commandList.size(); i++){
            stringBuilder.append(System.lineSeparator()).append(commandList.get(i));
        }
        System.setIn(new ByteArrayInputStream(stringBuilder.toString().getBytes()));
    }
}
