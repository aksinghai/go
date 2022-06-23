package all.company.com.MachineCoding.Splitwise.entity;

public class UserCredit {
    private Integer id;
    private Integer userId;
    private Integer creditUserId;
    private Double amount;

    public UserCredit(final Integer id, final Integer userId, final Integer creditUserId, final Double amount) {
        this.id = id;
        this.userId = userId;
        this.creditUserId = creditUserId;
        this.amount = amount;
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

    public Integer getCreditUserId() {
        return creditUserId;
    }

    public void setCreditUserId(final Integer creditUserId) {
        this.creditUserId = creditUserId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(final Double amount) {
        this.amount = amount;
    }

    @Override public String toString() {
        return "UserCredit{" +
                "id=" + id +
                ", userId=" + userId +
                ", creditUserId=" + creditUserId +
                ", amount=" + amount +
                '}';
    }
}
