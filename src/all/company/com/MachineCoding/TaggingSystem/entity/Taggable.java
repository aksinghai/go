package all.company.com.MachineCoding.TaggingSystem.entity;

import java.util.HashSet;
import java.util.Set;


public class Taggable {

    final private Set<Tag> tagSet;
    private Boolean showTag;

    public Taggable() {
        this.tagSet = new HashSet<>();
    }

    public Set<Tag> getTagSet() {
        return tagSet;
    }

    public void addTagsToSet(Set<Tag> tags) {
        this.tagSet.addAll(tags);
    }

    public void removeTagsFromSet(Set<Tag> tags){
        this.tagSet.removeAll(tags);
    }

    public Boolean getShowTag() {
        return showTag;
    }

    public void setShowTag(final Boolean showTag) {
        this.showTag = showTag;
    }

    @Override public String toString() {
        return "Taggable{" +
                "tagSet=" + tagSet +
                ", showTag=" + showTag +
                '}';
    }
}
