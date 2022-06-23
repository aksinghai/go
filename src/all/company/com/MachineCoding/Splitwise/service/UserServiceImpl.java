package all.company.com.MachineCoding.Splitwise.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import all.company.com.MachineCoding.Splitwise.entity.User;
import all.company.com.MachineCoding.Splitwise.entity.UserCredit;


public class UserServiceImpl implements UserService {

    static Integer userIndex = 0;
    static Map<Integer, User> userLookup = new HashMap<>();
    public static Map<String, UserCredit> userCreditLookup = new HashMap<>();

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
