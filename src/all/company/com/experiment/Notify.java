package all.company.com.experiment;

import java.util.ArrayList;
import java.util.List;


class Listener {
    public Integer id;
    public String name;
}

public class Notify {


    public static void main(String[] args) {
        List<Listener> listeners = new ArrayList<>();
        Listener l1 = new Listener();
        l1.id = 1;
        l1.name = "Akshay";
        Listener l2 = new Listener();
        l2.id = 2;
        l2.name = "Singhai";
        listeners.add(l1);
        listeners.add(l2);
        for(Listener l : listeners) {
            System.out.println(l.id);
        }
    }
}
