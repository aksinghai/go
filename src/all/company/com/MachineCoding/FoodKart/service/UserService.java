package all.company.com.MachineCoding.FoodKart.service;

import all.company.com.MachineCoding.FoodKart.entity.Order;
import all.company.com.MachineCoding.FoodKart.entity.User;


public interface UserService {

    User registerUser(String name, String gender, String phoneNumber, String pincode);

    User getUser(Integer userId);

    Order placeOrder(Integer userId, String restaurantName, Integer quantity);

}
