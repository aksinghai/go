package all.company.com.MachineCoding.MultilevelCacheNew.service;

import java.util.ArrayList;
import java.util.List;
import all.company.com.MachineCoding.MultilevelCacheNew.entity.eviction.Cache;
import all.company.com.MachineCoding.MultilevelCacheNew.entity.eviction.CacheFactory;
import all.company.com.MachineCoding.MultilevelCacheNew.entity.eviction.CacheType;
import all.company.com.MachineCoding.MultilevelCacheNew.entity.OperationTime;
import all.company.com.MachineCoding.MultilevelCacheNew.entity.OperationType;


public class MultiLevelCacheServiceImpl<T> implements MultiLevelCacheService<T> {

    private final List<Cache<T>> cacheList = new ArrayList<>();

    @Override public void init(final int levels, final String[] type) {
        for(int i = 1; i <= levels; i++ ){
            cacheList.add(new CacheFactory<T>().getCache("Level "+i, CacheType.valueOf(type[i-1])));
        }
    }

    @Override public T get(final String key) {
        List<OperationTime> operationTimes = new ArrayList<>();
        int timeTaken = 0;
        System.out.println();
        System.out.println("Operation GET");
        T value = null;
        for(int i = 0; i < cacheList.size(); i++){
            value = cacheList.get(i).get(key);
            operationTimes.add(new OperationTime(cacheList.get(i).getName(), OperationType.GET,
                    cacheList.get(i).getReadTime()));
            timeTaken += cacheList.get(i).getReadTime();
            if (value == null) {
                continue;
            }
            for(int j = i-1; j >= 0; j--){
                cacheList.get(j).set(key, value);
                operationTimes.add(new OperationTime(cacheList.get(j).getName(), OperationType.SET,
                        cacheList.get(j).getWriteTime()));
                timeTaken += cacheList.get(j).getWriteTime();
            }
        }
        System.out.println("Logs");
        for(OperationTime op : operationTimes){
            System.out.println(op);
        }
        System.out.println("Time taken : " + timeTaken);
        return value;
    }

    @Override public void set(final String key, final T value) {
        List<OperationTime> operationTimes = new ArrayList<>();
        int timeTaken = 0;
        System.out.println();
        System.out.println("Operation SET");
        for(Cache<T> cache : cacheList){
            T v  = cache.get(key);
            operationTimes.add(new OperationTime(cache.getName(), OperationType.GET, cache.getReadTime()));
            timeTaken += cache.getReadTime();
            if(v != value){
                cache.set(key, value);
                operationTimes.add(new OperationTime(cache.getName(), OperationType.SET, cache.getWriteTime()));
                timeTaken += cache.getWriteTime();
            }
        }

        System.out.println("Logs");
        for(OperationTime op : operationTimes){
            System.out.println(op);
        }
        System.out.println("Time taken : " + timeTaken);
    }

    @Override public void delete(final String key) {
        List<OperationTime> operationTimes = new ArrayList<>();
        int timeTaken = 0;
        System.out.println();
        System.out.println("Operation DELETE");
        for(Cache<T> cache : cacheList){
            timeTaken += cache.getReadTime();
            operationTimes.add(new OperationTime(cache.getName(), OperationType.DELETE, cache.getDeleteTime()));
            cache.delete(key);
        }
        System.out.println("Logs");
        for(OperationTime op : operationTimes){
            System.out.println(op);
        }
        System.out.println("Time taken : " + timeTaken);
    }
}
