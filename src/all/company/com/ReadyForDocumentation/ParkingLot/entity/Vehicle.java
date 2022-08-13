package all.company.com.ReadyForDocumentation.ParkingLot.entity;

public class Vehicle {
    private static int index = 0;

    private Integer id;

    private String registrationNo;

    private SlotType type;

    private SpecialQuota specialQuota;

    private Slot slot;

    public Vehicle(final String registrationNo, final SlotType type, final SpecialQuota specialQuota, final Slot slot) {
        this.id = index++;
        this.registrationNo = registrationNo;
        this.type = type;
        this.specialQuota = specialQuota;
        this.slot = slot;
    }

    public Integer getId() {
        return id;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(final String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public SlotType getType() {
        return type;
    }

    public void setType(final SlotType type) {
        this.type = type;
    }

    public SpecialQuota getSpecialQuota() {
        return specialQuota;
    }

    public void setSpecialQuota(final SpecialQuota specialQuota) {
        this.specialQuota = specialQuota;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(final Slot slot) {
        this.slot = slot;
    }

    @Override public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", registrationNo='" + registrationNo + '\'' +
                ", type=" + type +
                ", specialQuota=" + specialQuota +
                ", slot=" + slot +
                '}';
    }
}
