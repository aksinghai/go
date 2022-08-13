package all.company.com.MachineCoding.TaggingSystem.entity;

import java.util.Date;

public class Post extends Taggable {

    private static int identifier = 1;

    private Integer id;

    private String content;

    private Date dateTime;

    public Post(final String content) {
        super();
        this.id = identifier++;
        this.content = content;
        this.dateTime = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(final Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
