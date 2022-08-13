package all.company.com.ReadyForDocumentation.ParkingLot.entity;

import java.util.HashMap;
import java.util.Map;


public class Parking {

    private static int index = 1;

    private Integer id;

    private String name;

    private Map<Integer, ParkingFloor> parkingFloors;

    public Parking(final String name) {
        this.id = index++;
        this.name = name;
        this.parkingFloors = new HashMap<>();
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

    public Map<Integer, ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(
            final Map<Integer, ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    @Override public String toString() {
        return "Parking{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parkingFloors=" + parkingFloors +
                '}';
    }
}
