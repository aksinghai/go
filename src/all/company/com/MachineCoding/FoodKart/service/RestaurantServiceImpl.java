package all.company.com.MachineCoding.FoodKart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import all.company.com.MachineCoding.FoodKart.entity.Item;
import all.company.com.MachineCoding.FoodKart.entity.Rating;
import all.company.com.MachineCoding.FoodKart.entity.Restaurant;


public class RestaurantServiceImpl implements RestaurantService {

    private Integer restaurantIndex = 0;
    private Integer itemIndex = 0;
    private Integer ratingIndex = 0;

    public static Map<String, Restaurant> restaurantNameToRestaurantMap = new HashMap<>();
    public static Map<String, List<Restaurant>> pincodeToRestaurantMap = new HashMap<>();


    @Override public Restaurant registerRestaurant(final String restaurantName, final List<String> pincodes,
            final String foodItemName,
            final Double foodItemPrice, final Integer quantity) {
        if(restaurantNameToRestaurantMap.containsKey(restaurantName)){
            System.out.println("Name already exists");
            return null;
        }
        List<Item> itemList = new ArrayList<>();
        Item item = new Item(++itemIndex, foodItemName, quantity, foodItemPrice);
        itemList.add(item);
        Restaurant restaurant = new Restaurant(++restaurantIndex, restaurantName, pincodes, itemList);
        restaurantNameToRestaurantMap.put(restaurantName, restaurant);
        List<Restaurant> restaurantList = new ArrayList<>();
        for(String pincode : pincodes){
            if(pincodeToRestaurantMap.containsKey(pincode)){
                restaurantList = pincodeToRestaurantMap.get(pincode);
            }
            restaurantList.add(restaurant);
            pincodeToRestaurantMap.put(pincode,restaurantList);
        }
        return restaurant;
    }

    @Override public Restaurant rateRestaurant(final String restaurantName, final Integer rating,
            final String comment) {
        if(!restaurantNameToRestaurantMap.containsKey(restaurantName)){
            System.out.println("Restaurant not available");
        }
        Restaurant restaurant = restaurantNameToRestaurantMap.get(restaurantName);
        Rating rate = new Rating(++ratingIndex, restaurant.getId(), rating, comment);
        List<Rating> ratings = restaurant.getRatings();
        ratings.add(rate);
        int i = 0;
        int sum = 0;
        for(Rating rat : ratings){
            sum += rat.getRating();
            i++;
        }
        restaurant.setRate((double) (sum/i));
        return restaurant;
    }

    @Override public Restaurant updateQuantity(final String restaurantName, final Integer quantityToAdd) {
        if(!restaurantNameToRestaurantMap.containsKey(restaurantName)){
            System.out.println("Restaurant not available");
        }
        Restaurant restaurant = restaurantNameToRestaurantMap.get(restaurantName);
        List<Item> itemList = restaurant.getItems();
        itemList.get(0).setQuantity(itemList.get(0).getQuantity() + quantityToAdd);
        return restaurant;
    }

    @Override public List<Restaurant> searchRestaurants(final String filter) {
        List<Restaurant> restaurantList = new ArrayList<>();
        for(Map.Entry<String, Restaurant> entry : restaurantNameToRestaurantMap.entrySet()) {
            entry.getValue().getItems().get(0).getPrice();
            restaurantList.add(entry.getValue());
        }
        if(filter == "price"){
            restaurantList.sort((o1, o2) -> o1.getItems().get(0).getPrice().compareTo(o2.getItems().get(0).getPrice()));
        } else if(filter == "rating") {
            restaurantList.sort((o1, o2) -> o2.getRate().compareTo(o1.getRate()));
        }
        return restaurantList;
    }
}
