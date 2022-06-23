package all.company.com.MachineCoding.MultilevelCache.entity;

import java.util.Map;


public class LFUEviction implements Eviction{

    @Override public void getEvictedOnFull(Cache cache, String key) {
        String minFreqKey = null;
        int minFreq = Integer.MAX_VALUE;
        Cache currentCache = cache;
        while (currentCache != null){
            for(Map.Entry<String, String> entry : currentCache.getKeyValueLookup().entrySet()){
                if(!entry.getKey().equals(key)){
                    if(currentCache.getKeyFrequencyMap().get(entry.getKey()) != null && minFreq > currentCache.getKeyFrequencyMap().get(entry.getKey())){
                        minFreq = currentCache.getKeyFrequencyMap().get(entry.getKey());
                        minFreqKey = entry.getKey();
                    }
                }
            }
            currentCache = currentCache.getNextLevel();
        }

        if(minFreqKey != null){
            currentCache = cache;
            while (currentCache != null){
                if(currentCache.getKeyValueLookup().containsKey(minFreqKey)){
                    currentCache.getKeyValueLookup().remove(minFreqKey);
                    currentCache.getKeyFrequencyMap().remove(minFreqKey);
                    return;
                }
                currentCache = currentCache.getNextLevel();
            }
        }
    }
}
