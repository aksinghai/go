package all.company.com.MachineCoding.MultilevelCacheNew.service;


public interface MultiLevelCacheService<T> {

    void init(final int levels);

    T get(String key);

    void set(String key, T value);

    void delete(String key);

}
