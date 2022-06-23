package all.company.com.MachineCoding.FoodKart.entity;

import java.util.Date;


public class Rating {

    private Integer id;

    private Integer restaurantId;

    private Integer rating;

    private String comment;

    private Date datetime;

    public Rating(final Integer id, final Integer restaurantId, final Integer rating, final String comment) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.rating = rating;
        this.comment = comment;
        this.datetime = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(final Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(final Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(final Date datetime) {
        this.datetime = datetime;
    }

    @Override public String toString() {
        return "Rating{" +
                "id=" + id +
                ", restaurantId=" + restaurantId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}
