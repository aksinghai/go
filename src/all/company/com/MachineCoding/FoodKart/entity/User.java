package all.company.com.MachineCoding.FoodKart.entity;

import java.util.ArrayList;
import java.util.List;


public class User {
    private Integer id;
    private String name;
    private String gender;
    private String pincode;
    private String phoneNumber;
    private List<Order> orderList;

    public User(final Integer id, final String name, final String gender, final String pincode,
            final String phoneNumber) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.pincode = pincode;
        this.phoneNumber = phoneNumber;
        orderList = new ArrayList<>();
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

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(final String pincode) {
        this.pincode = pincode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(final List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", pincode='" + pincode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
