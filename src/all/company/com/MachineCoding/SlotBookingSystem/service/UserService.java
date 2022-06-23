package all.company.com.MachineCoding.SlotBookingSystem.service;

import all.company.com.MachineCoding.SlotBookingSystem.entity.User;


public interface UserService {

    User createUser(String name);

    User getUser(Integer userId);

}
