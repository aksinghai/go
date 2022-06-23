package all.company.com.MachineCoding.FoodKart.service;

import java.util.List;
import all.company.com.MachineCoding.FoodKart.entity.Restaurant;


public interface RestaurantService {

    Restaurant registerRestaurant(String restaurantName, List<String> pincodes, String foodItemName,
            Double foodItemPrice, Integer quantity);

    Restaurant rateRestaurant(String restaurantName, Integer rating, String comment);

    Restaurant updateQuantity(String restaurantName, Integer quantityToAdd);

    List<Restaurant> searchRestaurants(String filter);

}
