package all.company.com.MachineCoding.TaggingSystem.service;

import java.util.Set;
import all.company.com.MachineCoding.TaggingSystem.entity.Tag;
import all.company.com.MachineCoding.TaggingSystem.entity.Url;


public interface UrlService {

    Url createUrl(String url, Set<Tag> tagList);

    Url addTags(Integer id, Set<Tag> tagList);

    Url removeTags(Integer id, Set<Tag> tagList);

    Set<Url> getUrlWithTag(Tag tag);

    Set<Url> getAllUrlsWithTags();

    boolean deleteUrl(Integer id);

}
