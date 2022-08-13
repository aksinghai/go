package all.company.com.MachineCoding.TaggingSystem.service;

import java.util.Set;
import all.company.com.MachineCoding.TaggingSystem.entity.Tag;


public interface TagService {

    Set<String> getAllTags();

    void tagToPost(String key, int postId);

    Tag createTag(String key);

    Tag getTagByKey(String key);

}
