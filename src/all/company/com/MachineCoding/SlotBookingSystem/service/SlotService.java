package all.company.com.MachineCoding.SlotBookingSystem.service;

import java.util.Date;
import java.util.List;
import all.company.com.MachineCoding.SlotBookingSystem.entity.Slot;


public interface SlotService {

    Slot createSlots(Integer activityId, String slotName, Date from, Date to, Integer capacity);

    List<Slot> getSlots(Integer activityId, boolean onlyFuture);

    Slot bookASlot(Integer userId, Integer slotId);

    Slot cancelSlotBooked(Integer slotId, Integer userId);

}
