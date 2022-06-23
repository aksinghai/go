package all.company.com.MachineCoding.SlotBookingSystem;

import java.util.Date;
import java.util.Scanner;
import all.company.com.MachineCoding.SlotBookingSystem.service.ActivityService;
import all.company.com.MachineCoding.SlotBookingSystem.service.ActivityServiceImpl;
import all.company.com.MachineCoding.SlotBookingSystem.service.SlotService;
import all.company.com.MachineCoding.SlotBookingSystem.service.SlotServiceImpl;
import all.company.com.MachineCoding.SlotBookingSystem.service.UserService;
import all.company.com.MachineCoding.SlotBookingSystem.service.UserServiceImpl;


public class SlotBookingApp {

    public static UserService userService;
    public static ActivityService activityService;
    public static SlotService slotService;

    static {
        userService = new UserServiceImpl();
        activityService = new ActivityServiceImpl();
        slotService = new SlotServiceImpl();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Slot Booking application");
        while (true){
            System.out.println("Enter Command ");
            Command cmd = Command.valueOf(sc.nextLine());
            switch (cmd) {
                case create_user: {
                    System.out.println("User Name:");
                    String name = sc.nextLine();
                    System.out.println(userService.createUser(name));
                    break;
                }
                case get_user: {
                    System.out.println("User ID:");
                    Integer userId = Integer.parseInt(sc.nextLine());
                    System.out.println(userService.getUser(userId));
                    break;
                }
                case create_activity: {
                    System.out.println("Activity Name:");
                    String activityName = sc.nextLine();
                    System.out.println(activityService.createActivity(activityName));
                    break;
                }

                case get_activity: {
                    System.out.println("Activity ID:");
                    Integer activityId = Integer.parseInt(sc.nextLine());
                    System.out.println(activityService.getActivity(activityId));
                    break;
                }

                case create_slot: {
                    System.out.println("Activity ID:");
                    Integer activityId = Integer.parseInt(sc.nextLine());
                    System.out.println("Slot Name:");
                    String slotName = sc.nextLine();
                    System.out.println("Capacity:");
                    Integer capacity = Integer.parseInt(sc.nextLine());
                    Date from = new Date(System.currentTimeMillis() + (60 * 60 * 1000));
                    Date to = new Date(System.currentTimeMillis() + (2 * 59 * 60 * 1000));
                    System.out.println(slotService.createSlots(activityId, slotName, from, to, capacity));
                    break;
                }

                case book_slot: {
                    System.out.println("Slot ID:");
                    Integer slotId = Integer.parseInt(sc.nextLine());
                    System.out.println("User ID:");
                    Integer userId = Integer.parseInt(sc.nextLine());
                    System.out.println(slotService.bookASlot(userId, slotId));
                    break;
                }

                case get_slot: {
                    System.out.println("Activity ID:");
                    Integer activityId = Integer.parseInt(sc.nextLine());
                    System.out.println(slotService.getSlots(activityId, false));
                    break;
                }
                case cancel_slot:{
                    System.out.println("Slot ID:");
                    Integer slotId = Integer.parseInt(sc.nextLine());
                    System.out.println("User ID:");
                    Integer userId = Integer.parseInt(sc.nextLine());
                    System.out.println(slotService.cancelSlotBooked(userId, slotId));
                    break;
                }
                case exit :{
                    return;
                }

            }
        }
    }
}
