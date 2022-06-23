package all.company.com.MachineCoding.MultilevelCache.entity;

import java.util.Map;


public class RandomEviction implements Eviction{

    @Override public void getEvictedOnFull(Cache cache, String key) {
        String removeKey = getRandomKey(cache.getKeyValueLookup());
        if(removeKey == null){
            return;
        }
        cache.getKeyValueLookup().remove(removeKey);
        cache.getKeyFrequencyMap().remove(removeKey);

    }

    private String getRandomKey(Map<String, String> map){
        for(Map.Entry<String, String> entry : map.entrySet()){
            return entry.getKey();
        }
        return null;
    }
}
