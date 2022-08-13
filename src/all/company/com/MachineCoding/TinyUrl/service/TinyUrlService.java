package all.company.com.MachineCoding.TinyUrl.service;

import java.util.Date;
import all.company.com.MachineCoding.TinyUrl.entity.Alias;


public interface TinyUrlService {

    Boolean isAliasAvailable(String alias);

    Alias createUrlAlias(String fullUrl, String alias, Date validFrom,
            Date validTill);

    Alias getAlias(String alias);

}
