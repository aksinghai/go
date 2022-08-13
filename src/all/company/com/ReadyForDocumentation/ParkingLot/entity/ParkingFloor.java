package all.company.com.ReadyForDocumentation.ParkingLot.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ParkingFloor {
    private static int index = 1;

    private Integer id;

    private String name;

    private Map<Integer, Slot> occupiedSlotTypeListMap;

    private Map<SlotType, Map<SpecialQuota, List<Slot>>> availableSlotTypeMap;

    public ParkingFloor(final String name) {
        this.id = index++;
        this.name = name;
        this.occupiedSlotTypeListMap = new HashMap<>();
        this.availableSlotTypeMap = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Map<Integer, Slot> getOccupiedSlotTypeListMap() {
        return occupiedSlotTypeListMap;
    }

    public void setOccupiedSlotTypeListMap(
            final Map<Integer, Slot> occupiedSlotTypeListMap) {
        this.occupiedSlotTypeListMap = occupiedSlotTypeListMap;
    }

    public Map<SlotType, Map<SpecialQuota, List<Slot>>> getAvailableSlotTypeMap() {
        return availableSlotTypeMap;
    }

    public void setAvailableSlotTypeMap(
            final Map<SlotType, Map<SpecialQuota, List<Slot>>> availableSlotTypeMap) {
        this.availableSlotTypeMap = availableSlotTypeMap;
    }

    @Override public String toString() {
        return "ParkingFloor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", occupiedSlotTypeListMap=" + occupiedSlotTypeListMap +
                ", availableSlotTypeMap=" + availableSlotTypeMap +
                '}';
    }
}
