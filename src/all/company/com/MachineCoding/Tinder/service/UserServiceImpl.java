package all.company.com.MachineCoding.Tinder.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import all.company.com.MachineCoding.Tinder.AppDriver;
import all.company.com.MachineCoding.Tinder.Gender;
import all.company.com.MachineCoding.Tinder.entity.User;


public class UserServiceImpl implements UserService{

    private Map<String, User> userMap;

    public UserServiceImpl() {
        userMap = new HashMap<>();
    }

    @Override public boolean createUser(final String userName, final Double xCoordinate, final Double yCoordinate,
            final Integer age,
            final Gender gender) {

        if(userMap.containsKey(userName)) {
            System.out.println("User Already available");
            return false;
        }

        User user = new User(userName, xCoordinate,yCoordinate,age,gender);
        userMap.put(userName, user);
        Thread t = new Thread(() -> AppDriver.datingService.setPotentialMatch(userName));
        t.start();
        return true;
    }

    @Override public boolean deleteUser(final String userName) {
        return false;
    }

    @Override public User getUser(final String userName) {
        if(!userMap.containsKey(userName)){
            System.out.println("User Not Available");
            return null;
        }
        return userMap.get(userName);
    }

    @Override public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for(Map.Entry<String, User> entry : userMap.entrySet()){
            users.add(entry.getValue());
        }
        return users;
    }
}
