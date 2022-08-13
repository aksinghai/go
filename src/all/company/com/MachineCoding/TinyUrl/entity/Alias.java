package all.company.com.MachineCoding.TinyUrl.entity;

import java.util.Date;


public class Alias {

    private static int index = 1;

    private Integer id;
    private String alias;
    private String fullUrl;
    private Integer accessCount;
    private Date validFrom;
    private Date validTill;
    private Boolean isExpired;

    public Alias(final String alias, final String fullUrl, final Date validFrom,
            final Date validTill) {
        this.id = index++;
        this.alias = alias;
        this.fullUrl = fullUrl;
        this.accessCount = 0;
        if(validFrom == null) {
            this.validFrom = new Date();
        } else {
            this.validFrom = validFrom;
        }
        this.validTill = validTill;
        this.isExpired = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(final String alias) {
        this.alias = alias;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(final String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public Integer getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(final Integer accessCount) {
        this.accessCount = accessCount;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(final Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(final Date validTill) {
        this.validTill = validTill;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(final Boolean expired) {
        isExpired = expired;
    }

    @Override public String toString() {
        return "Alias{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                ", fullUrl='" + fullUrl + '\'' +
                ", accessCount=" + accessCount +
                ", validFrom=" + validFrom +
                ", validTill=" + validTill +
                ", isExpired=" + isExpired +
                '}';
    }
}
