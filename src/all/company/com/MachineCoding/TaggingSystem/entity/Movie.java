package all.company.com.MachineCoding.TaggingSystem.entity;

import java.util.Date;


public class Movie extends Taggable {

    private static int identifier = 1; //for id generation

    private Integer id;

    private String name;

    private String description;

    private Date dateTime;

    public Movie(final String name, final String description, final Date dateTime) {
        super();
        this.id = identifier++;
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(final Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
