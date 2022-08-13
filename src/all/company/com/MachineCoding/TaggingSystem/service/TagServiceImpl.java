package all.company.com.MachineCoding.TaggingSystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import all.company.com.MachineCoding.TaggingSystem.entity.Tag;
import all.company.com.MachineCoding.TaggingSystem.exception.TagException;


public class TagServiceImpl implements TagService {

    private final Map<String, Tag> tagMap = new HashMap<>();
    private final Map<String, List<Integer>> tagPostMap = new HashMap<>();

    private static TagService tagService;
    private static final PostService TAGGABLE_SERVICE = PostServiceImpl.getInstance();

    private TagServiceImpl() { }

    public static TagService getInstance(){
        if(tagService == null){
            synchronized (TagService.class){
                if(tagService == null){
                    tagService = new TagServiceImpl();
                }
            }
        }
        return tagService;
    }

    @Override public Set<String> getAllTags() {
        return new HashSet<>(tagMap.keySet());
    }

    @Override public void tagToPost(final String key, final int postId) {
        if(key == null || key.isEmpty() || postId == 0){
            throw new TagException("Invalid Input");
        }
        List<Integer> list;
        if(tagPostMap.containsKey(key)){
            list = tagPostMap.get(key);
        } else {
            list = new ArrayList<>();
        }
        list.add(postId);
        tagPostMap.put(key, list);
    }

    @Override public Tag createTag(final String key) {
        if(key == null || key.isEmpty()){
            throw new TagException("Invalid Input");
        }
        if(tagMap.containsKey(key)){
            throw new TagException("Already found");
        }
        Tag tag = new Tag(key);
        tagMap.put(tag.getKey(), tag);
        return tag;
    }

    @Override public Tag getTagByKey(final String key) {
        if(key == null || key.isEmpty()){
            throw new TagException("Invalid Input");
        }
        Tag tag = tagMap.get(key);
        if(tag == null){
            throw  new TagException("Not found");
        }
        return tag;
    }
}
