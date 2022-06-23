package all.company.com.MachineCoding.FoodKart.entity;

public class OrderItem {

    private Integer id;

    private Integer itemId;

    private String name;

    private Double unitPrice;

    private Double totalPrice;

    private Integer quantity;

    public OrderItem(final Integer id, final Integer itemId, final String name,
            final Double unitPrice,
            final Double totalPrice, final Integer quantity) {
        this.id = id;
        this.itemId = itemId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(final Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(final Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    @Override public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                ", quantity=" + quantity +
                '}';
    }
}
