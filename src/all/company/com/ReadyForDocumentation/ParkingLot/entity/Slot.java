package all.company.com.ReadyForDocumentation.ParkingLot.entity;

public class Slot {

    private static int index = 1;

    private Integer id;

    private String name;

    private Integer floorId;

    private Boolean isAvailable;

    private SpecialQuota specialQuota;

    private SlotType type;

    public Slot(final String name, final Boolean isAvailable, final SlotType type,
            final SpecialQuota specialQuota, final Integer floorId) {
        this.id = index++;
        this.name = name;
        this.floorId = floorId;
        this.isAvailable = isAvailable;
        this.specialQuota = specialQuota;
        this.type = type;
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

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(final Boolean available) {
        isAvailable = available;
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

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(final Integer floorId) {
        this.floorId = floorId;
    }

    @Override public String toString() {
        return "Slot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", floorId=" + floorId +
                ", isAvailable=" + isAvailable +
                ", specialQuota=" + specialQuota +
                ", type=" + type +
                '}';
    }
}
