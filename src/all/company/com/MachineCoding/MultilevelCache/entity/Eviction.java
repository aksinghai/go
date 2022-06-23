package all.company.com.MachineCoding.MultilevelCache.entity;

public interface Eviction {

    void getEvictedOnFull(Cache cache, String key);

}
