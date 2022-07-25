package all.company.com.MachineCoding.MultilevelCacheNew.service;

import java.util.ArrayList;
import java.util.List;
import all.company.com.MachineCoding.MultilevelCacheNew.entity.Cache;
import all.company.com.MachineCoding.MultilevelCacheNew.entity.RedisCache;


public class MultiLevelCacheServiceImpl<T> implements MultiLevelCacheService<T> {

    private List<Cache<T>> cacheList = new ArrayList<>();

    @Override public void init(final int levels) {
        for(int i = 1; i <= levels; i++ ){
            cacheList.add(new RedisCache<>("Level "+i, 3));
        }
    }

    @Override public T get(final String key) {
        for(Cache<T> cache : cacheList){
            T value = cache.get(key);
            if(value == null){
                continue;
            }
            return value;
        }
        return null;
    }

    @Override public void set(final String key, final T value) {
        cacheList.get(0).set(key, value);
    }

    @Override public void delete(final String key) {
        cacheList.get(0).delete(key);
    }
}
