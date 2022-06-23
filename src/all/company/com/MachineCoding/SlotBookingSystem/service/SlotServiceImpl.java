package all.company.com.MachineCoding.SlotBookingSystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import all.company.com.MachineCoding.SlotBookingSystem.SlotBookingApp;
import all.company.com.MachineCoding.SlotBookingSystem.entity.Activity;
import all.company.com.MachineCoding.SlotBookingSystem.entity.Slot;
import all.company.com.MachineCoding.SlotBookingSystem.entity.User;


public class SlotServiceImpl implements SlotService {

    private static final int CANCEL_BUFFER_MINS = 30;
    private Map<Integer, Slot> slotLookup;
    private Map<Integer, List<Slot>> activitySlots;

    public SlotServiceImpl() {
        slotLookup = new HashMap<>();
        activitySlots = new HashMap<>();
    }

    @Override public Slot createSlots(final Integer activityId, final String slotName, final Date from, final Date to,
            final Integer capacity) {
        if(activityId == null || slotName == null || from == null
                || to == null || capacity == null || slotName.isEmpty() || capacity == 0){
            throw new RuntimeException("Invalid Value");
        }
        Activity activity = SlotBookingApp.activityService.getActivity(activityId);
        if(activity == null){
            throw new RuntimeException("Activity Not Available");
        }
        Slot slot = new Slot(activityId, slotName, from, to, capacity);
        slotLookup.put(slot.getId(), slot);

        List<Integer> slotList = activity.getSlotIds();
        slotList.add(slot.getId());
        List<Slot> slots;
        if(activitySlots.get(activityId) == null){
            slots = new ArrayList<>();
        } else {
            slots = activitySlots.get(activityId);
        }
        slots.add(slot);
        activity.setSlotIds(slotList);
        activitySlots.put(activityId, slots);
        return slot;
    }

    @Override public List<Slot> getSlots(final Integer activityId, boolean onlyFuture) {
        if(!onlyFuture){
            return activitySlots.get(activityId);
        }
        List<Slot> futureSlots = new ArrayList<>();
        for(Slot slot : activitySlots.get(activityId)){
            if(slot.getFromTime().getTime() > System.currentTimeMillis()){
                futureSlots.add(slot);
            }
        }
        return futureSlots;
    }

    @Override public Slot bookASlot(final Integer userId, final Integer slotId) {
        User user = SlotBookingApp.userService.getUser(userId);
        if(user == null){
            throw new RuntimeException("User Not found");
        }
        Slot slot = slotLookup.get(slotId);
        if(slot == null){
            throw new RuntimeException("Slot not available");
        }
        if(slot.getCapacity() > slot.getBookedUser().size()){
            slot.getBookedUser().add(userId);
            user.getSlotBooked().add(slotId);
        } else {
            slot.getWaitingUser().add(userId);
            user.getWaitingQueue().add(userId);
        }
        return slot;
    }

    @Override public Slot cancelSlotBooked(final Integer slotId, final Integer userId) {
        User user = SlotBookingApp.userService.getUser(userId);
        if(user == null){
            throw new RuntimeException("User Not found");
        }
        Slot slot = slotLookup.get(slotId);
        if(slot == null){
            throw new RuntimeException("Slot not available");
        }
        if((slot.getFromTime().getTime() - System.currentTimeMillis()) < (CANCEL_BUFFER_MINS * 60 * 1000)){
            throw new RuntimeException("Cancellation Not allowed before "+ CANCEL_BUFFER_MINS+" Minutes");
        }
        assert slot != null;
        Set<Integer> bookedUser = slot.getBookedUser();
        if(bookedUser.contains(userId)){
            bookedUser.remove(userId);
            assert user != null;
            user.getSlotBooked().remove(userId);
            Integer waitingUser = slot.getWaitingUser().get(0);
            if(waitingUser != null) {
                bookedUser.add(waitingUser);
                slot.getWaitingUser().remove(waitingUser);
                user.getWaitingQueue().remove(waitingUser);
                user.getSlotBooked().add(waitingUser);
            }
        }
        return slot;
    }
}
