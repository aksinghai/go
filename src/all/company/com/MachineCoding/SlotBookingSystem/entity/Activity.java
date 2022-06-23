package all.company.com.MachineCoding.SlotBookingSystem.entity;

import java.util.ArrayList;
import java.util.List;


public class Activity {
    private static int activityIndex = 1;

    private Integer id;
    private String name;
    private List<Integer> slotIds;

    public Activity(final String name) {
        this.id = activityIndex++;
        this.name = name;
        this.slotIds = new ArrayList<>();
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

    public List<Integer> getSlotIds() {
        return slotIds;
    }

    public void setSlotIds(final List<Integer> slotIds) {
        this.slotIds = slotIds;
    }

    @Override public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slots=" + slotIds +
                '}';
    }
}
