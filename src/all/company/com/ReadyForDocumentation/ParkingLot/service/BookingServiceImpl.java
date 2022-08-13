package all.company.com.ReadyForDocumentation.ParkingLot.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import all.company.com.ReadyForDocumentation.ParkingLot.ParkingLotApp;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.Booking;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.BookingStatus;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.Parking;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.ParkingFloor;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.Slot;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.SlotType;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.SpecialQuota;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.Vehicle;
import all.company.com.ReadyForDocumentation.ParkingLot.exception.ParkingException;


public class BookingServiceImpl implements BookingService{

    private final static Map<Integer, Booking> bookingMap = new HashMap<>();
    private final static Map<Integer, Vehicle> vehicleMap = new HashMap<>();

    @Override public Booking in(final Parking parking, final SlotType slotType,
            final SpecialQuota specialQuota, final String registrationNo) {
        if(parking == null){
            throw new ParkingException("Parking not found");
        }
        for(Map.Entry<Integer, ParkingFloor> entry : parking.getParkingFloors().entrySet()) {
            if(!entry.getValue().getAvailableSlotTypeMap().get(slotType).get(specialQuota).isEmpty()){
                Slot slot = entry.getValue().getAvailableSlotTypeMap().get(slotType).get(specialQuota).get(0);
                slot.setAvailable(false);
                entry.getValue().getAvailableSlotTypeMap().get(slotType).get(specialQuota).remove(0);
                entry.getValue().getOccupiedSlotTypeListMap().put(slot.getId(), slot);
                Vehicle vehicle = new Vehicle(registrationNo, slotType, specialQuota, slot);
                vehicleMap.put(vehicle.getId(), vehicle);
                Booking booking = new Booking(vehicle.getId(), slot.getId(), parking.getId());
                bookingMap.put(booking.getId(), booking);
                return booking;
            }
        }
        throw new ParkingException("All slots are full");
    }


    @Override public Booking out(final int bookingId) {
        if (bookingId == 0){
            throw new ParkingException("Issue with booking ID");
        }
        Booking booking = bookingMap.get(bookingId);
        Slot slot = ParkingLotApp.parkingService.getSlotById(booking.getSlotId());
        booking.setEndTime(new Date());
        int hours =
                (int) Math.ceil((new Date().getTime()/(60*60*1000)) - (booking.getStartTime().getTime()/(60*60*1000))) + 1;
        booking.setPrice(hours * slot.getType().getPerHourCharges());
        boolean status = ParkingLotApp.parkingService.freeUpSlot(booking.getParkingId(), slot.getFloorId(), booking.getSlotId());
        booking.setStatus(BookingStatus.EXIT);
        if(status){
            System.out.println("Now slot "+ slot.getName() + " is available");
        }
        return booking;
    }

}
