package all.company.com.MachineCoding.Splitwise.entity;

import java.util.Date;
import java.util.List;


public class Expense {

    private Integer id;

    private String name;

    private Double amount;

    private Integer paidByUserId;

    private Integer createdByUserId;

    private Date createdAt;

    private List<Split> splits;

    public Expense(final Integer id, final String name, final Double amount,
            final Integer paidByUserId, final Integer createdByUserId) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.paidByUserId = paidByUserId;
        this.createdByUserId = createdByUserId;
        this.createdAt = new Date();
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(final Double amount) {
        this.amount = amount;
    }

    public Integer getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(final Integer createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(final List<Split> splits) {
        this.splits = splits;
    }

    public Integer getPaidByUserId() {
        return paidByUserId;
    }

    public void setPaidByUserId(final Integer paidByUserId) {
        this.paidByUserId = paidByUserId;
    }

    @Override public String toString() {
        return "Expense{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", paidByUserId=" + paidByUserId +
                ", createdByUserId=" + createdByUserId +
                ", createdAt=" + createdAt +
                ", splits=" + splits +
                '}';
    }
}
