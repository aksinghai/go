package all.company.com.ReadyForDocumentation.ParkingLot.service;

import java.util.List;
import java.util.Map;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.Parking;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.Slot;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.SlotType;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.SpecialQuota;


public interface ParkingService {

    Parking createParkingLot(String name);

    List<Parking> getParkingLots();

    Map<SlotType, Map<SpecialQuota, List<Slot>>> getAllAvailableSlots(int parkingId);

    Parking getParkingLot(int parkingId);

    Parking addFloor(int parkingId, String name);

    Parking addSlot(int parkingId, int floorId, String name, SlotType slotType, SpecialQuota specialQuota);

    boolean freeUpSlot(int parkingId, int floorId, int slotId);

    Slot getSlotById(Integer slotId);
}
