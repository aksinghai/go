package all.company.com.MachineCoding.TaggingSystem.entity;

import java.util.Date;


public class Url extends Taggable{

    private static int index = 1; //

    private Integer id;

    private String url;

    private Date createAt;

    public Url(final String url, final Date createAt) {
        this.id = index++;
        this.url = url;
        this.createAt = createAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(final Date createAt) {
        this.createAt = createAt;
    }

    @Override public String toString() {
        return "Url{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
