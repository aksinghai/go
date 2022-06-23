package all.company.com.MachineCoding.Tinder.service;

import java.util.List;
import all.company.com.MachineCoding.Tinder.Gender;
import all.company.com.MachineCoding.Tinder.entity.User;


public interface UserService {

    boolean createUser(String userName, Double xCoordinate, Double yCoordinate, Integer age, Gender gender);

    boolean deleteUser(String userName);

    User getUser(String userName);

    List<User> getAllUsers();
}
