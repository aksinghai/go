package all.company.com.MachineCoding.Splitwise.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import all.company.com.MachineCoding.Splitwise.entity.User;
import all.company.com.MachineCoding.Splitwise.entity.UserCredit;


public class UserServiceImpl implements UserService {

    private static UserService userService;
    static Integer userIndex = 0;
    static Map<Integer, User> userLookup = new HashMap<>();
    private static final Map<String, UserCredit> userCreditLookup = new HashMap<>();

    private UserServiceImpl() { }

    public static UserService getInstance() {
        if(userService == null){
            synchronized (UserServiceImpl.class) {
                if(userService == null){
                    userService = new UserServiceImpl();
                }
            }
        }
        return userService;
    }

    public Map<String, UserCredit> getUserCreditLookup(){
        return userCreditLookup;
    }

    @Override public User createUser(final String name) {
        User user = new User(userIndex+1,name);
        userLookup.put(userIndex+1, user);
        userIndex++;
        return user;
    }

    @Override public User getUser(final Integer userId) {
        if(userLookup.containsKey(userId)){
            return userLookup.get(userId);
        }
        return null;
    }

    @Override public List<UserCredit> getUserCredit(final Integer userId) {
        List<UserCredit> userCreditList = new ArrayList<>();
        for(Map.Entry<String, UserCredit> entry : userCreditLookup.entrySet()){
            UserCredit userCredit = entry.getValue();
            //Take
            if(userCredit.getUserId().equals(userId)){
                userCreditList.add(userCredit);
            }
            //Give
            if(userCredit.getCreditUserId().equals(userId)){
                userCreditList.add(userCredit);
            }
        }
        return userCreditList;
    }
}
