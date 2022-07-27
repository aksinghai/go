package all.company.com.MachineCoding.MultilevelCacheNew.entity.eviction;

import java.util.HashMap;
import java.util.Map;


public abstract class Cache<T> {

    private static int cacheIndex = 1;

    private Integer id;
    private String name;
    private Map<String, Data<T>> keyValue;
    private Data<T> head;
    private Data<T> tail;
    private Integer maxCapacity;
    private Integer allocatedCapacity;
    private Eviction eviction;
    private final Integer readTime;
    private final Integer writeTime;
    private final Integer deleteTime;

    protected Cache(final String name, final Integer maxCapacity, final Integer readTime, final Integer writeTime,
            final Integer deleteTime) {
        this.id = cacheIndex++;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.allocatedCapacity = 0;
        this.keyValue = new HashMap<>();
        this.eviction = new LRUEviction<T>(this);
        this.readTime = readTime;
        this.writeTime = writeTime;
        this.deleteTime = deleteTime;
    }

    protected Integer getId() {
        return id;
    }

    protected void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    protected void setName(final String name) {
        this.name = name;
    }

    protected Integer getMaxCapacity() {
        return maxCapacity;
    }

    protected void setMaxCapacity(final Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    protected Integer getAllocatedCapacity() {
        return allocatedCapacity;
    }

    protected void setAllocatedCapacity(final Integer allocatedCapacity) {
        this.allocatedCapacity = allocatedCapacity;
    }

    protected Map<String, Data<T>> getKeyValue() {
        return keyValue;
    }

    protected void setKeyValue(
            final Map<String, Data<T>> keyValue) {
        this.keyValue = keyValue;
    }

    protected Data<T> getHead() {
        return head;
    }

    protected void setHead(final Data<T> head) {
        this.head = head;
    }

    protected Data<T> getTail() {
        return tail;
    }

    protected void setTail(final Data<T> tail) {
        this.tail = tail;
    }

    protected Eviction getEviction() {
        return eviction;
    }

    protected void setEviction(final Eviction eviction) {
        this.eviction = eviction;
    }

    public Integer getReadTime() {
        return readTime;
    }

    public Integer getWriteTime() {
        return writeTime;
    }

    public Integer getDeleteTime() {
        return deleteTime;
    }

    public abstract T get(String key);

    public abstract boolean set(String key, T value);

    public abstract boolean delete(String key);

}
