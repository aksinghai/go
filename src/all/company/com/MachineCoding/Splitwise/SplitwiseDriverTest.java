package all.company.com.MachineCoding.Splitwise;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;


public class SplitwiseDriverTest {

    public static void main(String[] args) {
        List<String> commandList = Arrays.asList(
                "create-user",
                "Akshay",
                "create-user",
                "Akanksha",
                "add-expense",
                "Lunch",
                "10",
                "1",
                "PERCENTAGE",
                "2",
                "1",
                "50",
                "2",
                "50",
                "user-view",
                "1",
                "user-view",
                "2",
                "exit"
        );
        passParams(commandList);
        SplitwiseDriver.main(new String[] { "test" });
    }

    private static void passParams(List<String> commandList) {
        if (commandList == null || commandList.isEmpty()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(commandList.get(0));
        int size = commandList.size();
        for (int i = 1; i < size; i++) {
            stringBuilder.append(System.getProperty("line.separator")).append(commandList.get(i));
        }
        System.setIn(new ByteArrayInputStream(stringBuilder.toString().getBytes()));
    }
}