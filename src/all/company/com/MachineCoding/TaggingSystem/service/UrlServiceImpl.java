package all.company.com.MachineCoding.TaggingSystem.service;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import all.company.com.MachineCoding.TaggingSystem.entity.Tag;
import all.company.com.MachineCoding.TaggingSystem.entity.Taggable;
import all.company.com.MachineCoding.TaggingSystem.entity.Url;
import all.company.com.MachineCoding.TaggingSystem.exception.TagException;


public class UrlServiceImpl implements UrlService {

    private final static Map<Integer, Url> urlMap = new HashMap<>();
    private static TagService tagService = TagServiceImpl.getInstance();

    @Override public Url createUrl(final String url, final Set<Tag> tagSet) {
        if(url == null || url.isEmpty()){
            throw new TagException("Invalid Input");
        }
        Url url1 = new Url(url, new Date());
        urlMap.put(url1.getId(), url1);
        url1.addTagsToSet(tagSet);
        for(Tag tag : tagSet){
            tag.addToTaggableSet(url1);
        }
        return url1;
    }

    @Override public Url addTags(final Integer id, final Set<Tag> tagSet) {
        if(id == 0 || tagSet == null || tagSet.size() == 0){
            throw new TagException("Invalid Input");
        }
        if(!urlMap.containsKey(id)){
            throw new TagException("Tag not available");
        }
        Url url = urlMap.get(id);
        url.addTagsToSet(tagSet);
        for(Tag tag : tagSet){
            tag.addToTaggableSet(url);
        }
        return url;
    }

    @Override public Url removeTags(final Integer id, final Set<Tag> tagSet) {
        if(id  == 0 || tagSet == null || tagSet.size() == 0){
            throw new TagException("Invalid Input");
        }
        Url url = urlMap.get(id);
        if(url == null){
            throw new TagException("Url not available");
        }
        url.removeTagsFromSet(tagSet);
        for(Tag tag : tagSet){
            tag.removeFromTaggableSet(url);
        }
        return url;
    }

    @Override public Set<Url> getUrlWithTag(final Tag tag) {
        if(tag == null){
            throw new TagException("Tag not found");
        }
        Set<Url> urls = new HashSet<>();
        for(Taggable taggable : tag.getTaggableSet()){
            urls.add((Url) taggable);
        }
        return urls;
    }

    @Override public Set<Url> getAllUrlsWithTags() {
        return new HashSet<>(urlMap.values());
    }

    @Override public boolean deleteUrl(final Integer id) {
        if(id == null || id == 0){
            throw  new TagException("Invalid Value");
        }
        Url url = urlMap.get(id);
        for(Tag t : url.getTagSet()){

        }
        return true;
    }
}
