package all.company.com.MachineCoding.SlotBookingSystem.entity;

import java.util.ArrayList;
import java.util.List;


public class User {

    private static int userIndex = 1;

    private Integer id;
    private String name;
    private List<Integer> slotBooked;
    private List<Integer> waitingQueue;

    public User(final String name) {
        this.id = userIndex++;
        this.name = name;
        this.slotBooked = new ArrayList<>();
        this.waitingQueue = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Integer> getSlotBooked() {
        return slotBooked;
    }

    public void setSlotBooked(final List<Integer> slotBooked) {
        this.slotBooked = slotBooked;
    }

    public List<Integer> getWaitingQueue() {
        return waitingQueue;
    }

    public void setWaitingQueue(final List<Integer> waitingQueue) {
        this.waitingQueue = waitingQueue;
    }

    @Override public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slotBooked=" + slotBooked +
                ", waitingQueue=" + waitingQueue +
                '}';
    }
}
