package all.company.com.MachineCoding.FoodKart.entity;

import java.util.ArrayList;
import java.util.List;


public class Restaurant {
    private Integer id;
    private String name;
    private List<String> pincodes;
    private List<Item> items;
    private List<Rating> ratings;
    private Double rate;

    public Restaurant(final Integer id, final String name, final List<String> pincodes,
            final List<Item> items) {
        this.id = id;
        this.name = name;
        this.pincodes = pincodes;
        this.items = items;
        ratings = new ArrayList<>();
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

    public List<String> getPincodes() {
        return pincodes;
    }

    public void setPincodes(final List<String> pincodes) {
        this.pincodes = pincodes;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(final List<Item> items) {
        this.items = items;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(final List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(final Double rate) {
        this.rate = rate;
    }

    @Override public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pincodes=" + pincodes +
                ", items=" + items +
                ", ratings=" + ratings +
                ", rate=" + rate +
                '}';
    }
}
