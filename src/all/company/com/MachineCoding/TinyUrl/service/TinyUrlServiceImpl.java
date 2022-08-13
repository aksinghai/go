package all.company.com.MachineCoding.TinyUrl.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import all.company.com.MachineCoding.TinyUrl.enception.AliasException;
import all.company.com.MachineCoding.TinyUrl.entity.Alias;
import all.company.com.MachineCoding.TinyUrl.utils.RandomGenerator;


public class TinyUrlServiceImpl implements TinyUrlService {

    private final Map<String, Alias> aliasMap = new HashMap<>();

    @Override public Boolean isAliasAvailable(final String alias) {
        if(alias == null || alias.isEmpty()){
            throw new RuntimeException("Invalid Input");
        }
        return !aliasMap.containsKey(alias);
    }

    @Override public Alias createUrlAlias(final String fullUrl, String aliasName, Date validFrom,
            Date validTill) {
        if(fullUrl == null || (aliasName != null && aliasName.length() < 4) || (validTill != null && validTill.getTime() < System.currentTimeMillis())){
            throw new RuntimeException("Invalid Value");
        }
        if(aliasMap.containsKey(aliasName)){
            throw new RuntimeException("alias not available");
        } else {
            if(validFrom == null){
                validFrom = new Date();
            }
            if(validTill == null){
                validTill = new Date(System.currentTimeMillis()+ (2 * 1000));
            }
            synchronized (TinyUrlServiceImpl.class) {
                if(aliasName != null && aliasMap.containsKey(aliasName)){
                    throw new RuntimeException("alias not available");
                }
                if(aliasName == null){
                    aliasName = RandomGenerator.getString(6);
                    while (aliasMap.containsKey(aliasName)){
                        aliasName = RandomGenerator.getString(6);
                    }
                }
                Alias alias = new Alias(aliasName, fullUrl, validFrom, validTill);
                aliasMap.put(aliasName, alias);
            }
        }
        return aliasMap.get(aliasName);
    }

    @Override public Alias getAlias(final String aliasName) {
        if(aliasMap.containsKey(aliasName)){
            Alias alias = aliasMap.get(aliasName);
            if(!alias.getExpired() && alias.getValidTill().getTime() < System.currentTimeMillis()){
                alias.setExpired(true);
            }

            if(alias.getExpired()){
                throw new AliasException("Expired Alias");
            }
            synchronized (TinyUrlServiceImpl.class){
                alias.setAccessCount(alias.getAccessCount()+1);
            }
            return alias;
        }
        return null;
    }
}
