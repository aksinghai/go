package all.company.com.MachineCoding.FoodKart.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Order {

    private Integer id;

    private Integer userId;

    private Double totalPrice;

    private Status status;

    private List<OrderItem> itemList;

    private Date createdAt;

    public Order(final Integer id, final Integer userId, final Double totalPrice, final Status status) {
        this.id = id;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = new Date();
        this.itemList = new ArrayList<OrderItem>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(final List<OrderItem> itemList) {
        this.itemList = itemList;
    }

    @Override public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", itemList=" + itemList +
                ", createdAt=" + createdAt +
                '}';
    }
}
