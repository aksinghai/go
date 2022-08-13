package all.company.com.ReadyForDocumentation.ParkingLot;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.Parking;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.Slot;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.SlotType;
import all.company.com.ReadyForDocumentation.ParkingLot.entity.SpecialQuota;
import all.company.com.ReadyForDocumentation.ParkingLot.service.BookingService;
import all.company.com.ReadyForDocumentation.ParkingLot.service.BookingServiceImpl;
import all.company.com.ReadyForDocumentation.ParkingLot.service.ParkingService;
import all.company.com.ReadyForDocumentation.ParkingLot.service.ParkingServiceImpl;


public class ParkingLotApp {

    public static ParkingService parkingService;

    public static BookingService bookingService;

    static {
        parkingService = new ParkingServiceImpl();
        bookingService = new BookingServiceImpl();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------");
        while (true) {
            System.out.println("CMD :");
            Command cmd = Command.valueOf(sc.nextLine());
            System.out.println(cmd.toString());
            switch (cmd) {
                case create_parking: {
                    System.out.println("Name :");
                    String name = sc.nextLine();
                    System.out.println(parkingService.createParkingLot(name));
                    break;
                }
                case create_floor: {
                    System.out.println("Parking ID :");
                    int parkingId = Integer.parseInt(sc.nextLine());
                    System.out.println("Floor Name :");
                    String name = sc.nextLine();
                    System.out.println(parkingService.addFloor(parkingId, name));
                    break;
                }
                case all_available_slot :{
                    System.out.println("Parking ID :");
                    int parkingId = Integer.parseInt(sc.nextLine());
                    Map<SlotType, Map<SpecialQuota, List<Slot>>> availableSlots =
                            parkingService.getAllAvailableSlots(parkingId);
                    for(Map.Entry<SlotType, Map<SpecialQuota, List<Slot>>> entry : availableSlots.entrySet()){
                        System.out.println("# "+entry.getKey()+" #");
                        for(Map.Entry<SpecialQuota, List<Slot>> sql : entry.getValue().entrySet()){
                            System.out.println(" # "+sql.getKey()+" #");
                            for(int i = 0; i < sql.getValue().size(); i++){
                                System.out.println("      "+sql.getValue().get(i));
                            }
                        }
                    }
                    break;
                }
                case add_slot : {
                    System.out.println("Parking ID :");
                    int parkingId = Integer.parseInt(sc.nextLine());
                    System.out.println("Floor ID :");
                    int floorId = Integer.parseInt(sc.nextLine());
                    System.out.println("Slot Name :");
                    String slotName = sc.nextLine();
                    System.out.println("Slot type :");
                    SlotType slotType = SlotType.valueOf(sc.nextLine());
                    System.out.println("Quota :");
                    SpecialQuota quota = SpecialQuota.valueOf(sc.nextLine());
                    System.out.println(parkingService.addSlot(parkingId, floorId, slotName, slotType, quota));
                    break;
                }
                case do_booking: {
                    System.out.println("Parking ID :");
                    int parkingId = Integer.parseInt(sc.nextLine());
                    System.out.println("Slot type :");
                    SlotType slotType = SlotType.valueOf(sc.nextLine());
                    System.out.println("Quota :");
                    SpecialQuota quota = SpecialQuota.valueOf(sc.nextLine());
                    System.out.println("Registration Number :");
                    String registrationNo = sc.nextLine();
                    Parking parking = parkingService.getParkingLot(parkingId);
                    System.out.println(bookingService.in(parking, slotType, quota, registrationNo));
                    break;
                }
                case out: {
                    System.out.println("Booking ID :");
                    int bookingId = Integer.parseInt(sc.nextLine());
                    System.out.println(bookingService.out(bookingId));
                    break;
                }
                case exit: {
                    return;
                }
                default: {
                    throw new IllegalArgumentException("Invalid Command");
                }
            }
        }
    }
}
