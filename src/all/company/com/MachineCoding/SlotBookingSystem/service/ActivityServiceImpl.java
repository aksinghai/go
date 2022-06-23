package all.company.com.MachineCoding.SlotBookingSystem.service;

import java.util.HashMap;
import java.util.Map;
import all.company.com.MachineCoding.SlotBookingSystem.entity.Activity;


public class ActivityServiceImpl implements ActivityService {

    private Map<Integer, Activity> activityLookup;

    public ActivityServiceImpl() {
         activityLookup = new HashMap<>();
    }

    @Override public Activity createActivity(final String activityName) {
        if(activityName == null || activityName.isEmpty()){
            throw new RuntimeException("Invalid Value");
        }
        Activity activity = new Activity(activityName);
        activityLookup.put(activity.getId(), activity);
        return activity;
    }

    @Override public Activity getActivity(final Integer activityId) {
        if(!activityLookup.containsKey(activityId)){
            throw new RuntimeException("Invalid Value");
        }
        return activityLookup.get(activityId);
    }
}
