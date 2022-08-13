package all.company.com.ReadyForDocumentation.ParkingLot.entity;

public enum SlotType {
    CAR(100.0),
    BIKE(50.0),
    TRUCK(150.0);

    private double perHourCharges;

    SlotType(final double perHourCharges) {
        this.perHourCharges = perHourCharges;
    }

    public double getPerHourCharges() {
        return perHourCharges;
    }
}
