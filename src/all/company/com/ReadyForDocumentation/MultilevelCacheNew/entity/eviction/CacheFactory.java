package all.company.com.ReadyForDocumentation.MultilevelCacheNew.entity.eviction;

import static all.company.com.ReadyForDocumentation.MultilevelCacheNew.entity.eviction.CacheType.*;
import all.company.com.ReadyForDocumentation.MultilevelCacheNew.entity.MemCache;
import all.company.com.ReadyForDocumentation.MultilevelCacheNew.entity.RedisCache;


public class CacheFactory<T> {

    public Cache<T> getCache(String name, CacheType type) {
        switch (type) {
            case REDIS: {
                return new RedisCache<>(name, REDIS.getCapacity());
            }
            case MEMCACHE: {
                return new MemCache<>(name, MEMCACHE.getCapacity());
            }
            default: {
                throw new IllegalStateException("Unexpected value: " + type);
            }
        }
    }

}
