package all.company.com.MachineCoding.MultilevelCacheNew.entity;

import java.util.Map;


public abstract class Cache<T> {

    private static int cacheIndex = 1;

    private Integer id;
    private String name;
    private Map<String, Data<T>> keyValue;
    private Data<T> storage;
    private Integer maxCapacity;
    private Integer allocatedCapacity;

    protected Cache(final String name, final Integer maxCapacity) {
        this.id = cacheIndex++;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.allocatedCapacity = 0;
    }

    protected Integer getId() {
        return id;
    }

    protected void setId(final Integer id) {
        this.id = id;
    }

    protected String getName() {
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

    public abstract <T> String get(String key);

    public abstract boolean set(String key, T value);

    public abstract boolean delete(String key);

}
