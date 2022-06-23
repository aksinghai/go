package all.company.com.MachineCoding.SlotBookingSystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Slot {
    private static int slotIndex = 1;

    private Integer id;
    private Integer activityId;
    private String slotName;
    private Date fromTime;
    private Date toTime;
    private Set<Integer> bookedUser;
    private List<Integer> waitingUser;
    private Integer capacity;

    public Slot(final Integer activityId, final String slotName, final Date fromTime, final Date toTime, final Integer capacity) {
        this.id = slotIndex++;
        this.activityId = activityId;
        this.slotName = slotName;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.bookedUser = new HashSet<>();
        this.waitingUser = new ArrayList<>();
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(final Integer activityId) {
        this.activityId = activityId;
    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(final String slotName) {
        this.slotName = slotName;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(final Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(final Date toTime) {
        this.toTime = toTime;
    }

    public Set<Integer> getBookedUser() {
        return bookedUser;
    }

    public void setBookedUser(final Set<Integer> bookedUser) {
        this.bookedUser = bookedUser;
    }

    public List<Integer> getWaitingUser() {
        return waitingUser;
    }

    public void setWaitingUser(final List<Integer> waitingUser) {
        this.waitingUser = waitingUser;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(final Integer capacity) {
        this.capacity = capacity;
    }

    @Override public String toString() {
        return "Slot{" +
                "id=" + id +
                ", activityId=" + activityId +
                ", slotName='" + slotName + '\'' +
                ", fromTime=" + fromTime +
                ", toTime=" + toTime +
                ", bookedUser=" + bookedUser +
                ", waitingUser=" + waitingUser +
                ", capacity=" + capacity +
                '}';
    }
}
