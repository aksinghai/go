package all.company.com.MachineCoding.Splitwise.entity;

public class Split {

    private Integer id;

    private Integer expenseId;

    private SplitType type;

    private Double splitValue;

    private Integer forUserId;

    private Double amount;

    public Split(final Integer id, final Integer expenseId, final SplitType type, final Double splitValue,
            final Integer forUserId,
            final Double amount) {
        this.id = id;
        this.expenseId = expenseId;
        this.type = type;
        this.splitValue = splitValue;
        this.forUserId = forUserId;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(final Integer expenseId) {
        this.expenseId = expenseId;
    }

    public SplitType getType() {
        return type;
    }

    public void setType(final SplitType type) {
        this.type = type;
    }

    public Double getSplitValue() {
        return splitValue;
    }

    public void setSplitValue(final Double splitValue) {
        this.splitValue = splitValue;
    }

    public Integer getForUserId() {
        return forUserId;
    }

    public void setForUserId(final Integer forUserId) {
        this.forUserId = forUserId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(final Double amount) {
        this.amount = amount;
    }

    @Override public String toString() {
        return "Split{" +
                "id=" + id +
                ", expenseId=" + expenseId +
                ", type=" + type +
                ", splitValue=" + splitValue +
                ", forUserId=" + forUserId +
                ", amount=" + amount +
                '}';
    }
}
