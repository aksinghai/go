package all.company.com.MachineCoding.MultilevelCacheNew;

import all.company.com.MachineCoding.MultilevelCacheNew.service.MultiLevelCacheService;
import all.company.com.MachineCoding.MultilevelCacheNew.service.MultiLevelCacheServiceImpl;


public class MultiLevelCacheDriver {
    static MultiLevelCacheService<String> multiLevelCacheService = new MultiLevelCacheServiceImpl<>();
    public static void main(String[] args) {
        multiLevelCacheService.init(2);
        multiLevelCacheService.set("test_k1","test_v1");
        multiLevelCacheService.set("test_k2","test_v2");
        multiLevelCacheService.set("test_k3","test_v3");
        multiLevelCacheService.set("test_k4","test_v4");
        System.out.println(multiLevelCacheService.get("test_k"));
    }
}
