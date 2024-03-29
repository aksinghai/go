package all.company.com.ReadyForDocumentation.MultilevelCacheNew.service;


public interface MultiLevelCacheService<T> {

    void init(final int levels, final String[] type);

    T get(String key);

    void set(String key, T value);

    void delete(String key);

}
