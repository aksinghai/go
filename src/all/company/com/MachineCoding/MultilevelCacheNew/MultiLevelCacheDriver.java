package all.company.com.MachineCoding.MultilevelCacheNew;

import all.company.com.MachineCoding.MultilevelCacheNew.service.MultiLevelCacheService;
import all.company.com.MachineCoding.MultilevelCacheNew.service.MultiLevelCacheServiceImpl;


public class MultiLevelCacheDriver {
    static MultiLevelCacheService<String> multiLevelCacheService = new MultiLevelCacheServiceImpl<>();
    public static void main(String[] args) {
        multiLevelCacheService.init(2, new String[]{"REDIS", "MEMCACHE"});
        multiLevelCacheService.set("test_k1","test_v1");
        multiLevelCacheService.set("test_k2","test_v2");
        multiLevelCacheService.set("test_k3","test_v3");
        System.out.println(multiLevelCacheService.get("test_k1"));
        System.out.println(multiLevelCacheService.get("test_k4"));
        multiLevelCacheService.delete("test_k1");
        System.out.println("Done");
    }
}
