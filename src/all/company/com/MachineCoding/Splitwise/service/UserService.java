package all.company.com.MachineCoding.Splitwise.service;

import java.util.List;
import java.util.Map;
import all.company.com.MachineCoding.Splitwise.entity.User;
import all.company.com.MachineCoding.Splitwise.entity.UserCredit;


public interface UserService {

    Map<String, UserCredit> getUserCreditLookup();

    User createUser(String name);

    User getUser(Integer userId);

    List<UserCredit> getUserCredit(Integer userId);
}
