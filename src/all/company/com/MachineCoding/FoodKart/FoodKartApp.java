package all.company.com.MachineCoding.FoodKart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import all.company.com.MachineCoding.FoodKart.entity.User;
import all.company.com.MachineCoding.FoodKart.service.RestaurantService;
import all.company.com.MachineCoding.FoodKart.service.RestaurantServiceImpl;
import all.company.com.MachineCoding.FoodKart.service.UserService;
import all.company.com.MachineCoding.FoodKart.service.UserServiceImpl;


public class FoodKartApp {

    static RestaurantService restaurantService;
    static UserService userService;

    static {
        restaurantService = RestaurantServiceImpl.getInstance();
        userService = UserServiceImpl.getInstance();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- FOODKART ----------");
        User loggedInUser = null;
        while (true) {
            System.out.println("Enter Command :");
            String cmd = sc.nextLine();
            if(cmd.isEmpty()) continue;
            System.out.println(">>> "+cmd);
            switch (Command.valueOf(cmd)){
                case register_user: {
                    System.out.println("Enter Name :");
                    String name = sc.nextLine();
                    System.out.println("Enter Gender :");
                    String gender = sc.nextLine();
                    System.out.println("Enter phone Number :");
                    String phoneNumber = sc.nextLine();
                    System.out.println("Enter Pincode :");
                    String pincode = sc.nextLine();
                    System.out.println(userService.registerUser(name, gender, phoneNumber, pincode));
                    break;
                }
                case login_user: {
                    System.out.println("Enter User ID :");
                    Integer userId = sc.nextInt();
                    loggedInUser = userService.getUser(userId);
                    break;
                }
                case order_history : {
                    if(loggedInUser == null){
                        System.out.println("User not logged in");
                        break;
                    }
                    System.out.println(userService.getUser(loggedInUser.getId()));
                    break;
                }
                case register_restaurant: {
                    System.out.println("Enter Name :");
                    String restaurantName = sc.nextLine();
                    System.out.println("Serviceable Pincode (,) :");
                    String[] pincodes = sc.nextLine().split(",");
                    System.out.println("Item Name :");
                    String itemName = sc.nextLine();
                    System.out.println("Price :");
                    Double price = Double.parseDouble(sc.nextLine());
                    System.out.println("Initial Quantity :");
                    Integer quantity = Integer.parseInt(sc.nextLine());
                    System.out.println(restaurantService.registerRestaurant(restaurantName, new ArrayList<>(Arrays.asList(pincodes)),
                            itemName, price, quantity));
                    break;
                }
                case update_quantity: {
                    System.out.println("Enter Name :");
                    String restaurantName = sc.nextLine();
                    System.out.println("Enter Quantity to add :");
                    Integer quantity = Integer.parseInt(sc.nextLine());
                    System.out.println(restaurantService.updateQuantity(restaurantName, quantity));
                    break;
                }
                case rate_restaurant: {
                    System.out.println("Enter Name :");
                    String restaurantName = sc.nextLine();
                    System.out.println("Enter Rating (1-5) :");
                    Integer rating = Integer.parseInt(sc.nextLine());
                    System.out.println("Comment :");
                    String comment = sc.nextLine();
                    System.out.println(restaurantService.rateRestaurant(restaurantName, rating, comment));
                    break;
                }
                case show_restaurant: {
                    System.out.println("Based on (rating/price) : ");
                    String filter = sc.nextLine();
                    System.out.println(restaurantService.searchRestaurants(filter));
                    break;
                }
                case place_order: {
                    if(loggedInUser == null){
                        System.out.println("User not LoggedIn");
                        break;
                    }
                    System.out.println("Enter Restaurant Name :");
                    String restaurantName = sc.nextLine();
                    System.out.println("Quantity :");
                    Integer quantity = Integer.parseInt(sc.nextLine());
                    System.out.println(userService.placeOrder(loggedInUser.getId(), restaurantName, quantity));
                    break;
                }
                case exit:
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + Command.valueOf(cmd));
            }
        }
    }
}