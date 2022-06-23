package all.company.com.MachineCoding.MultilevelCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import all.company.com.MachineCoding.MultilevelCache.entity.EvictionStrategy;
import all.company.com.MachineCoding.MultilevelCache.service.MultilevelCache;
import all.company.com.MachineCoding.MultilevelCache.service.MultilevelCacheImpl;


public class Driver {
    public static MultilevelCache multilevelCache;

    static {
        multilevelCache = new MultilevelCacheImpl();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------- Multilevel Cache -----------");
        while (true){
            System.out.println("Command :");
            Command cmd = Command.valueOf(sc.nextLine());
            switch (cmd){
                case init:{
                    System.out.println("Levels : ");
                    int levels = Integer.parseInt(sc.nextLine());
                    System.out.println("Capacities : ");
                    String[] capacityStr = sc.nextLine().split(",");
                    List<Integer> capacities = new ArrayList<>();
                    for(String c : capacityStr){
                        capacities.add(Integer.parseInt(c));
                    }
                    System.out.println(multilevelCache.init(levels, capacities));
                    break;
                }
                case get: {
                    System.out.println("Key : ");
                    String key = sc.nextLine();
                    String value =  multilevelCache.getValue(key);
                    System.out.println(value == null ? "Value Not found" : value);
                    break;
                }
                case contains:{
                    System.out.println("Key : ");
                    String key = sc.nextLine();
                    System.out.println(multilevelCache.contains(key) ? " Key "+key+" Found " : "Key "+key+ " Not "
                            + "found");
                    break;
                }
                case set: {
                    System.out.println("Key : ");
                    String key = sc.nextLine();
                    System.out.println("Value : ");
                    String value = sc.nextLine();
                    System.out.println(multilevelCache.setValue(key, value) ? "Value set" : "failed to set");
                    break;
                }
                case delete: {
                    System.out.println("Key : ");
                    String key = sc.nextLine();
                    System.out.println(multilevelCache.removeKey(key) ? "Value set" : "failed to set");
                    break;
                }
                case set_eviction:{
                    System.out.println("Eviction Strategy : ");
                    EvictionStrategy evictionStrategy = EvictionStrategy.valueOf(sc.nextLine());
                    multilevelCache.setEviction(evictionStrategy);
                    break;
                }
                case get_eviction: {
                    multilevelCache.getEviction();
                    break;
                }
                case exit : {
                    return;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + cmd);
            }
        }

    }
}
