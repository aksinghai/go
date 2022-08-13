package all.company.com.MachineCoding.LRU.entity.eviction;

public interface Eviction {

    void keyAccessed(String key);

    void doEvict();

}
