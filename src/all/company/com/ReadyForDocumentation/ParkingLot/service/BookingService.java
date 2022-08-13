package all.company.com.ReadyForDocumentation.ParkingLot.service;

import all.company.com.ReadyForDocumentation.ParkingLot.entity.Booking;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.Parking;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.SlotType;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.SpecialQuota;


public interface BookingService {

    Booking in(Parking parking, SlotType slotType, SpecialQuota specialQuota, String registrationNo);

    Booking out(int bookingId);

}
