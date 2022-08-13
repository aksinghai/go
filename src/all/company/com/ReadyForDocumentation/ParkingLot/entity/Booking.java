package all.company.com.ReadyForDocumentation.ParkingLot.entity;

import java.util.Date;


public class Booking {

    private static int index = 1;

    private Integer id;

    private Integer vehicleId;

    private Integer parkingId;

    private Integer slotId;

    private Date startTime;

    private Date endTime;

    private Double price;

    private BookingStatus status;

    public Booking(final Integer vehicleId, final Integer slotId, final Integer parkingId) {
        this.id = index++;
        this.vehicleId = vehicleId;
        this.parkingId = parkingId;
        this.slotId = slotId;
        this.startTime = new Date(System.currentTimeMillis() - (3 * 60 * 60 * 1000));
        this.endTime = null;
        this.price = 0.0;
        this.status = BookingStatus.PARKED;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(final Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(final Integer parkingId) {
        this.parkingId = parkingId;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(final Integer slotId) {
        this.slotId = slotId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(final Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(final Date endTime) {
        this.endTime = endTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(final BookingStatus status) {
        this.status = status;
    }

    @Override public String toString() {
        return "Booking{" +
                "id=" + id +
                ", vehicleId=" + vehicleId +
                ", parkingId=" + parkingId +
                ", slotId=" + slotId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
