package all.company.com.MachineCoding.FoodKart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import all.company.com.MachineCoding.FoodKart.entity.Item;
import all.company.com.MachineCoding.FoodKart.entity.Order;
import all.company.com.MachineCoding.FoodKart.entity.OrderItem;
import all.company.com.MachineCoding.FoodKart.entity.Restaurant;
import all.company.com.MachineCoding.FoodKart.entity.Status;
import all.company.com.MachineCoding.FoodKart.entity.User;


public class UserServiceImpl implements UserService {

    private static UserService userService;

    private Integer userIndex = 0;
    private Integer orderIndex = 0;
    private Integer orderItemIndex = 0;
    private static final Map<Integer, User> userIdUserMap = new HashMap<>();

    private UserServiceImpl() { }

    public static UserService getInstance() {
        if(userService == null){
            synchronized (UserServiceImpl.class){
                if(userService == null){
                    userService = new UserServiceImpl();
                }
            }
        }
        return userService;
    }

    @Override public User registerUser(final String name, final String gender, final String phoneNumber,
            final String pincode) {
        User user = new User(++userIndex, name,gender,pincode,phoneNumber);
        userIdUserMap.put(user.getId(), user);
        return user;
    }

    @Override public User getUser(final Integer userId) {
        if(userIdUserMap.containsKey(userId)){
            return userIdUserMap.get(userId);
        }
        return null;
    }

    @Override public Order placeOrder(final Integer userId, final String restaurantName, final Integer quantity) {
        if(!RestaurantServiceImpl.restaurantNameToRestaurantMap.containsKey(restaurantName)){
            System.out.println("Restaurant Not Available");
            return null;
        }

        if(!userIdUserMap.containsKey(userId)){
            System.out.println("User Not Available");
            return null;
        }
        User user = userIdUserMap.get(userId);
        Restaurant restaurant = RestaurantServiceImpl.restaurantNameToRestaurantMap.get(restaurantName);
        Item item  = restaurant.getItems().get(0);
        if(quantity > item.getQuantity()){
            System.out.println("Quantity is not sufficient");
            return null;
        }
        Order order = new Order(++orderIndex, userId, quantity * item.getPrice(), Status.PLACED);
        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = new OrderItem(++orderItemIndex, item.getId(), item.getName(),
                item.getPrice(), quantity * item.getPrice(), quantity);
        orderItemList.add(orderItem);
        order.setItemList(orderItemList);
        item.setQuantity(item.getQuantity() - quantity);
        user.getOrderList().add(order);
        return order;
    }

}
