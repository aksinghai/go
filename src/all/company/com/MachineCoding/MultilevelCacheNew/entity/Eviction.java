package all.company.com.MachineCoding.MultilevelCacheNew.entity;

public interface Eviction {

    void keyAccess(String Key);

    void evict();

}
