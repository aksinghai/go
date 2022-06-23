package all.company.com.MachineCoding.Tinder;

import java.util.Scanner;
import all.company.com.MachineCoding.Tinder.service.DatingService;
import all.company.com.MachineCoding.Tinder.service.DatingServiceImpl;
import all.company.com.MachineCoding.Tinder.service.UserService;
import all.company.com.MachineCoding.Tinder.service.UserServiceImpl;


public class AppDriver {

    public static UserService userService;
    public static DatingService datingService;

    static {
        userService = new UserServiceImpl();
        datingService = new DatingServiceImpl();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- Tinder ---------");
        while (true){
            System.out.println("Enter Command : ");
            Command cmd = Command.valueOf(scanner.nextLine());
            switch (cmd){
                case create_account: {
                    System.out.println("UserName:");
                    String userName = scanner.nextLine();
                    System.out.println("X Coordinate:");
                    Double xCoordinate = Double.parseDouble(scanner.nextLine());
                    System.out.println("Y Coordinate:");
                    Double yCoordinate = Double.parseDouble(scanner.nextLine());
                    System.out.println("Age:");
                    Integer age = Integer.parseInt(scanner.nextLine());
                    System.out.println("gender:");
                    Gender gender = Gender.valueOf(scanner.nextLine().toLowerCase());
                    userService.createUser(userName,xCoordinate,yCoordinate,age,gender);
                    break;
                }
                case delete_account: {
                    System.out.println("UserName:");
                    String userName = scanner.nextLine();
                    System.out.println(userService.deleteUser(userName));
                    break;
                }
                case potential_match: {
                    System.out.println("UserName:");
                    String userName = scanner.nextLine();
                    System.out.println(datingService.getPotentialMatch(userName));
                    break;
                }
                case like:{
                    System.out.println("UserName:");
                    String userName = scanner.nextLine();
                    System.out.println("To UserName:");
                    String toUserName = scanner.nextLine();
                    System.out.println(datingService.likeUser(userName, toUserName));
                    break;
                }
                case ignore:{
                    System.out.println("UserName:");
                    String userName = scanner.nextLine();
                    System.out.println("To UserName:");
                    String toUserName = scanner.nextLine();
                    System.out.println(datingService.ignore(userName, toUserName));
                    break;
                }
                case show_match:{
                    System.out.println("UserName:");
                    String userName = scanner.nextLine();
                    System.out.println(datingService.showMatches(userName));
                    break;
                }
                case show_all_matches:{
                    System.out.println(datingService.showAllMatches());
                    break;
                }
                case exit: {
                    return;
                }
                default:{
                    throw new IllegalStateException("Unexpected value: " + cmd);
                }

            }

        }
    }
}
