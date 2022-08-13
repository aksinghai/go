package all.company.com.ReadyForDocumentation.MultilevelCacheNew.entity.eviction;

public enum CacheType {

    REDIS ("REDIS", 2),
    MEMCACHE ("MEMCACHE", 3);

    String cache;
    Integer capacity;

    CacheType(final String cache, final Integer capacity) {
        this.cache = cache;
        this.capacity = capacity;
    }

    String getCache() {
        return cache;
    }

    Integer getCapacity() {
        return capacity;
    }
}
