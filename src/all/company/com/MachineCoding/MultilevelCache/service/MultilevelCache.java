package all.company.com.MachineCoding.MultilevelCache.service;

import java.util.List;
import all.company.com.MachineCoding.MultilevelCache.entity.EvictionStrategy;


public interface MultilevelCache {

    boolean init(int level, List<Integer> capacities);

    String getValue(String key);

    boolean contains(String key);

    boolean setValue(String key, String value);

    boolean removeKey(String key);

    boolean setEviction(EvictionStrategy evictionStrategy);

    String getEviction();
}
