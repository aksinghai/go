package all.company.com.MachineCoding.MultilevelCache.service;

import java.util.List;
import all.company.com.MachineCoding.MultilevelCache.entity.Cache;
import all.company.com.MachineCoding.MultilevelCache.entity.Eviction;
import all.company.com.MachineCoding.MultilevelCache.entity.EvictionStrategy;
import all.company.com.MachineCoding.MultilevelCache.entity.LFUEviction;
import all.company.com.MachineCoding.MultilevelCache.entity.RandomEviction;


public class MultilevelCacheImpl implements MultilevelCache{

    private Cache firstCache;
    private EvictionStrategy evictionStrategy;
    private Eviction eviction;

    @Override public boolean init(final int level, final List<Integer> capacities) {
        if(level == 0 || capacities == null || capacities.size() != level){
            throw new RuntimeException("Invalid value");
        }
        Cache prev = null;
        for(int i = 0; i < level; i++){
            Cache cache = new Cache("Level_"+(i+1),capacities.get(i));
            if(prev != null){
                prev.setNextLevel(cache);
                cache.setPreviousLevel(prev);
            } else {
                firstCache = cache;
            }
            prev = cache;
        }
        evictionStrategy = EvictionStrategy.RANDOM;
        eviction = getEviction(evictionStrategy);
        return true;
    }

    @Override public String getValue(final String key) {
        validate();
        Cache seedCache = firstCache;
        while (seedCache != null){
            if(seedCache.getKeyValueLookup().containsKey(key)){
                seedCache.getKeyFrequencyMap().put(key, seedCache.getKeyFrequencyMap().get(key)+1);
                return seedCache.getKeyValueLookup().get(key);
            } else {
                seedCache = seedCache.getNextLevel();
            }
        }
        return null;
    }

    @Override public boolean contains(final String key) {
        validate();
        Cache seedCache = firstCache;
        while (seedCache != null){
            if(seedCache.getKeyValueLookup().containsKey(key)){
                return true;
            } else {
                seedCache = seedCache.getNextLevel();
            }
        }
        return false;
    }

    @Override public boolean setValue(final String key, final String value) {
        validate();
        Cache seedCache = firstCache;
        while (seedCache != null){
            if(seedCache.getKeyValueLookup().containsKey(key)){
                seedCache.getKeyFrequencyMap().put(key, seedCache.getKeyFrequencyMap().get(key)+1);
                seedCache.getKeyValueLookup().put(key, value);
                return true;
            }
            seedCache = seedCache.getNextLevel();
        }

        seedCache = firstCache;
        while (seedCache.getNextLevel() != null && seedCache.getKeyValueLookup().size() == seedCache.getCapacity()){
            seedCache = seedCache.getNextLevel();
        }

        if(seedCache.getNextLevel() == null && seedCache.getKeyValueLookup().size() == seedCache.getCapacity() ){
            eviction.getEvictedOnFull(firstCache, key);
            seedCache = firstCache;
            while (seedCache != null){
                if(seedCache.getCapacity() > seedCache.getKeyValueLookup().size()){
                    seedCache.getKeyFrequencyMap().put(key, 1);
                    seedCache.getKeyValueLookup().put(key, value);
                    return true;
                }
                seedCache = seedCache.getNextLevel();
            }
        } else {
            seedCache.getKeyFrequencyMap().put(key, 1);
            seedCache.getKeyValueLookup().put(key, value);
        }
        return true;
    }

    @Override public boolean removeKey(final String key) {
        validate();
        Cache seedCache = firstCache;
        while (seedCache != null){
            if(seedCache.getKeyValueLookup().containsKey(key)){
                seedCache.getKeyFrequencyMap().remove(key);
                seedCache.getKeyValueLookup().remove(key);
                return true;
            } else {
                seedCache = seedCache.getNextLevel();
            }
        }
        return false;
    }

    @Override public boolean setEviction(final EvictionStrategy evictionStrategy) {
        this.evictionStrategy = evictionStrategy;
        this.eviction = getEviction(evictionStrategy);
        return true;
    }

    @Override public String getEviction() {
        return this.evictionStrategy.toString();
    }

    private void validate(){
        if(firstCache == null){
            throw new RuntimeException("Cache is not initialized");
        }
    }


    private Eviction getEviction(EvictionStrategy evictionStrategy){
        switch (evictionStrategy){
            case LFU: {
                return new LFUEviction();
            }
            case RANDOM: {
                return new RandomEviction();
            }
        }
        return null;
    }
}
