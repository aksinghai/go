package all.company.com.MachineCoding.SlotBookingSystem.service;

import java.util.HashMap;
import java.util.Map;
import all.company.com.MachineCoding.SlotBookingSystem.entity.User;


public class UserServiceImpl implements UserService {

    private Map<Integer, User> userLookup;

    public UserServiceImpl() {
        userLookup = new HashMap<>();
    }

    @Override public User createUser(final String name) {
        if(name == null || name.isEmpty()){
            throw new RuntimeException("Invalid Value");
        }

        User user = new User(name);
        userLookup.put(user.getId(), user);
        return user;
    }

    @Override public User getUser(final Integer userId) {
        if(!userLookup.containsKey(userId)){
            return null;
        }
        return userLookup.get(userId);
    }
}
