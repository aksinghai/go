package all.company.com.MachineCoding.LRU.entity;

import java.util.Map;
import all.company.com.MachineCoding.LRU.entity.eviction.Eviction;


public abstract class Cache<T> {

    private Integer capacity;
    private Integer allocation;
    private Map<T, DataNode<T>> dataStore;
    private DataNode<T> head;
    private DataNode<T> tail;
    private Eviction eviction;

    public Cache(final Integer capacity, final Integer allocation,
            final Map<T, DataNode<T>> dataStore) {
        this.capacity = capacity;
        this.allocation = allocation;
        this.dataStore = dataStore;
        this.head = null;
        this.tail = null;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(final Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getAllocation() {
        return allocation;
    }

    public void setAllocation(final Integer allocation) {
        this.allocation = allocation;
    }

    public Map<T, DataNode<T>> getDataStore() {
        return dataStore;
    }

    public void setDataStore(
            final Map<T, DataNode<T>> dataStore) {
        this.dataStore = dataStore;
    }

    public DataNode<T> getHead() {
        return head;
    }

    public void setHead(final DataNode<T> head) {
        this.head = head;
    }

    public DataNode<T> getTail() {
        return tail;
    }

    public void setTail(final DataNode<T> tail) {
        this.tail = tail;
    }

    protected Eviction getEviction() {
        return eviction;
    }

    protected void setEviction(final Eviction eviction) {
        this.eviction = eviction;
    }

    @Override public String toString() {
        return "Cache{" +
                "capacity=" + capacity +
                ", allocation=" + allocation +
                ", dataStore=" + dataStore +
                ", head=" + head +
                ", tail=" + tail +
                ", eviction=" + eviction +
                '}';
    }
}
