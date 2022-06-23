package all.company.com.MachineCoding.LRU.service;

import java.util.HashMap;
import java.util.Map;
import all.company.com.MachineCoding.LRU.entity.User;


public class UserService {

    private static Integer userIndex = 0;
    public static Map<Integer, User> userLookup = new HashMap<>();

    public User createUser(String name){
        User user = new User(userIndex+1, name);
        userLookup.put(userIndex+1, user);
        userIndex++;
        return user;
    }

    public User getUser(Integer userId){
        if(userLookup.containsKey(userId)){
            return userLookup.get(userId);
        }
        return null;
    }

}
