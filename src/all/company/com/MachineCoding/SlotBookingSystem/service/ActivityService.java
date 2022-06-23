package all.company.com.MachineCoding.SlotBookingSystem.service;

import all.company.com.MachineCoding.SlotBookingSystem.entity.Activity;


public interface ActivityService {

    Activity createActivity(String activityName);

    Activity getActivity(Integer activityId);

}
