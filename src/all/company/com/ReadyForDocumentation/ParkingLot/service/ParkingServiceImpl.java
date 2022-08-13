package all.company.com.ReadyForDocumentation.ParkingLot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.Parking;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.ParkingFloor;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.Slot;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.SlotType;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.SpecialQuota;
import all.company.com.ReadyForDocumentation.ParkingLot.exception.ParkingException;


public class ParkingServiceImpl implements ParkingService {

    Map<Integer, Parking> parkingMap = new HashMap<>();
    Map<Integer, ParkingFloor> parkingFloorMap = new HashMap<>();
    Map<Integer, Slot> slotMap = new HashMap<>();

    @Override public Parking createParkingLot(final String name) {
        if(name == null || name.isEmpty()){
            throw new ParkingException("Invalid Name");
        }
        Parking parking = new Parking(name);
        parkingMap.put(parking.getId(), parking);
        return parking;
    }

    @Override public List<Parking> getParkingLots() {
        List<Parking> parkingList = new ArrayList<>();
        for(Map.Entry<Integer, Parking> entry : parkingMap.entrySet()){
            parkingList.add(entry.getValue());
        }
        return parkingList;
    }

    @Override public Map<SlotType, Map<SpecialQuota, List<Slot>>> getAllAvailableSlots(final int parkingId) {
        if(parkingId == 0){
            throw new ParkingException("Invalid ID");
        }
        Parking parking = parkingMap.get(parkingId);
        Map<SlotType, Map<SpecialQuota, List<Slot>>> allAvailableSlots = new HashMap<>();
        for(Map.Entry<Integer, ParkingFloor> floorEntry : parking.getParkingFloors().entrySet()){
            for(Map.Entry<SlotType, Map<SpecialQuota, List<Slot>>> slotEntry :
                    floorEntry.getValue().getAvailableSlotTypeMap().entrySet()){
                for(Map.Entry<SpecialQuota, List<Slot>> entry : slotEntry.getValue().entrySet()){
                    if(allAvailableSlots.containsKey(slotEntry.getKey())){
                        if(allAvailableSlots.get(slotEntry.getKey()).containsKey(entry.getKey())){
                            allAvailableSlots.get(slotEntry.getKey()).get(entry.getKey()).addAll(entry.getValue());
                        } else {
                            allAvailableSlots.get(slotEntry.getKey()).put(entry.getKey(),
                                    new ArrayList<>(entry.getValue()));
                        }
                    } else {
                        allAvailableSlots.put(slotEntry.getKey(),new HashMap<>());
                        allAvailableSlots.get(slotEntry.getKey()).put(entry.getKey(),
                                new ArrayList<>(entry.getValue()));
                    }
                }
            }
        }
        return allAvailableSlots;
    }

    @Override public Parking getParkingLot(final int parkingId) {
        if(parkingId == 0){
            throw new ParkingException("Invalid ID");
        }
        Parking parking = parkingMap.get(parkingId);
        if(parking == null){
            throw new ParkingException("Parking not found");
        }
        return parking;
    }

    @Override public Parking addFloor(final int parkingId, final String name) {
        if(parkingId == 0){
            throw new ParkingException("Invalid parking id");
        }
        Parking parking = parkingMap.get(parkingId);
        if(parking == null){
            throw new ParkingException("Parking not found");
        }
        ParkingFloor floor = new ParkingFloor(name);
        parkingFloorMap.put(floor.getId(), floor);
        parking.getParkingFloors().put(floor.getId(), floor);
        return parking;
    }

    @Override public Parking addSlot(final int parkingId, final int floorId, final String name, final SlotType slotType,
            final SpecialQuota specialQuota) {
        if(parkingId == 0){
            throw new ParkingException("Invalid parking id");
        }
        Parking parking = parkingMap.get(parkingId);
        if(parking == null){
            throw new ParkingException("Parking not found");
        }
        ParkingFloor floor = parking.getParkingFloors().get(floorId);
        if(floor == null){
            throw new ParkingException("Floor not found");
        }
        Slot slot = new Slot(name, true, slotType, specialQuota, floor.getId());
        slotMap.put(slot.getId(), slot);
        if(floor.getAvailableSlotTypeMap().containsKey(slotType)){
            if(floor.getAvailableSlotTypeMap().get(slotType).containsKey(specialQuota)){
                floor.getAvailableSlotTypeMap().get(slotType).get(specialQuota).add(slot);
            } else {
                floor.getAvailableSlotTypeMap().get(slotType).put(specialQuota, new ArrayList<>(Arrays.asList(slot)));
            }
        } else {
            floor.getAvailableSlotTypeMap().put(slotType, new HashMap<>());
            floor.getAvailableSlotTypeMap().get(slotType).put(specialQuota, new ArrayList<>());
            floor.getAvailableSlotTypeMap().get(slotType).get(specialQuota).add(slot);
        }
        return parking;
    }

    @Override public boolean freeUpSlot(final int parkingId, final int floorId, final int slotId) {
        if(parkingId == 0){
            throw new ParkingException("Invalid parking id");
        }
        Parking parking = parkingMap.get(parkingId);
        if(parking == null){
            throw new ParkingException("Parking not found");
        }
        ParkingFloor floor = parking.getParkingFloors().get(floorId);
        if(floor == null){
            throw new ParkingException("Floor not found");
        }
        Slot slot = floor.getOccupiedSlotTypeListMap().get(slotId);
        if(slot == null){
            throw new ParkingException("Slot not booked");
        }
        slot.setAvailable(true);
        floor.getOccupiedSlotTypeListMap().remove(slotId);
        floor.getAvailableSlotTypeMap().get(slot.getType()).get(slot.getSpecialQuota()).add(slot);
        return true;
    }

    @Override public Slot getSlotById(final Integer slotId) {
        if(slotId == 0){
            throw new ParkingException("Invalid Slot ID");
        }
        Slot slot = slotMap.get(slotId);
        if(slot == null){
            throw new ParkingException("Slot not found");
        }
        return slot;
    }
}
