package all.company.com.MachineCoding.LRU;

import java.util.Scanner;
import all.company.com.MachineCoding.LRU.service.LRUService;
import all.company.com.MachineCoding.LRU.service.UserService;


public class LRUCache {

    public static LRUService lruService = new LRUService();
    public static UserService userService = new UserService();

    public static void main(String[] args) {
        System.out.println("--------- LRU Cache ---------");
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter Command");
            String cmd = sc.next();
            switch (cmd){
                case "create-user" : {
                    System.out.println("Name :");
                    String name = sc.next();
                    System.out.println(userService.createUser(name));
                    break;
                }
                case "add-log" : {
                    System.out.println("Enter UserID:");
                    Integer userId = sc.nextInt();
                    lruService.addLog(userId);
                    break;
                }
                case "get-user" : {
                    System.out.println(lruService.getUser());
                    break;
                }
                case "exit" :{
                    return;
                }
            }
        }
    }
}
