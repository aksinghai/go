package all.company.com.ReadyForDocumentation.MultilevelCacheNew.entity.eviction;

public interface Eviction {

    void keyAccess(String Key);

    void evict();

}
