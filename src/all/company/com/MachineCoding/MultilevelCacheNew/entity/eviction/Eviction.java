package all.company.com.MachineCoding.MultilevelCacheNew.entity.eviction;

public interface Eviction {

    void keyAccess(String Key);

    void evict();

}
