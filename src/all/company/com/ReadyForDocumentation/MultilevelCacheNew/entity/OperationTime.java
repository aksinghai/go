package all.company.com.ReadyForDocumentation.MultilevelCacheNew.entity;

public class OperationTime {
    String cacheName;
    OperationType operationType;
    Integer timeTaken;

    public OperationTime(final String cacheName,
            final OperationType operationType, final Integer timeTaken) {
        this.cacheName = cacheName;
        this.operationType = operationType;
        this.timeTaken = timeTaken;
    }

    public String getCacheName() {
        return cacheName;
    }

    public void setCacheName(final String cacheName) {
        this.cacheName = cacheName;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(final OperationType operationType) {
        this.operationType = operationType;
    }

    public Integer getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(final Integer timeTaken) {
        this.timeTaken = timeTaken;
    }

    @Override public String toString() {
        return "OperationTime{" +
                "cacheName='" + cacheName + '\'' +
                ", operationType=" + operationType +
                ", timeTaken=" + timeTaken +
                '}';
    }
}
