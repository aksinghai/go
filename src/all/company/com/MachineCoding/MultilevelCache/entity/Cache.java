package all.company.com.MachineCoding.MultilevelCache.entity;

import java.util.HashMap;
import java.util.Map;


public class Cache {
    private static int cacheIndex = 1;

    private Integer id;
    private String level;
    private Cache nextLevel;
    private Cache previousLevel;
    private Integer capacity;
    private Map<String, String> keyValueLookup;
    private Map<String, Integer> keyFrequencyMap;

    public Cache(final String level, final Integer capacity) {
        this.id = cacheIndex++;
        this.level = level;
        this.nextLevel =null;
        this.previousLevel = null;
        this.capacity = capacity;
        keyValueLookup = new HashMap<>(capacity);
        keyFrequencyMap = new HashMap<>(capacity);
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(final String level) {
        this.level = level;
    }

    public Cache getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(final Cache nextLevel) {
        this.nextLevel = nextLevel;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(final Integer capacity) {
        this.capacity = capacity;
    }

    public Map<String, String> getKeyValueLookup() {
        return keyValueLookup;
    }

    public void setKeyValueLookup(final Map<String, String> keyValueLookup) {
        this.keyValueLookup = keyValueLookup;
    }

    public Cache getPreviousLevel() {
        return previousLevel;
    }

    public void setPreviousLevel(final Cache previousLevel) {
        this.previousLevel = previousLevel;
    }

    public Map<String, Integer> getKeyFrequencyMap() {
        return keyFrequencyMap;
    }

    public void setKeyFrequencyMap(final Map<String, Integer> keyFrequencyMap) {
        this.keyFrequencyMap = keyFrequencyMap;
    }
}
