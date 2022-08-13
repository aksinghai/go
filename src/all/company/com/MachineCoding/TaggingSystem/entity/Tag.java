package all.company.com.MachineCoding.TaggingSystem.entity;

import java.util.HashSet;
import java.util.Set;


public class Tag {
    private static int identifier = 1; //Just to generate id

    private Integer id;

    private String key;

    private Set<Taggable> taggableSet;

    public Tag(final String key) {
        this.id = identifier++;
        this.key = key;
        this.taggableSet = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public Set<Taggable> getTaggableSet() {
        return taggableSet;
    }

    public void addToTaggableSet(final Taggable taggable) {
        this.taggableSet.add(taggable);
    }

    public void removeFromTaggableSet(final Taggable taggable) {
        this.taggableSet.remove(taggable);
    }

    @Override public String toString() {
        return "Tag{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", taggableSet=" + taggableSet +
                '}';
    }
}
