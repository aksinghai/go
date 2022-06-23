package all.company.com.MachineCoding.Tinder.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import all.company.com.MachineCoding.Tinder.Gender;


public class User {

    private static Integer userIndex = 0;

    private Integer id;
    private String userName;
    private Double xCoordinate;
    private Double yCoordinate;
    private Integer age;
    private Gender gender;
    private List<String> potentialMatches;
    private Set<String> ignoredUserIds;
    private Set<String> likeUserIds;
    private Set<String> likedUserIds;
    private Set<String> matchedUserIds;

    public User(final String userName, final Double xCoordinate, final Double yCoordinate,
            final Integer age,
            final Gender gender) {
        this.id = ++userIndex;
        this.userName = userName;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.age = age;
        this.gender = gender;
        this.potentialMatches = new ArrayList<>();
        this.ignoredUserIds = new HashSet<>();
        this.likeUserIds = new HashSet<>();
        this.likedUserIds = new HashSet<>();
        this.matchedUserIds = new HashSet<>();
    }

    public static Integer getUserIndex() {
        return userIndex;
    }

    public static void setUserIndex(final Integer userIndex) {
        User.userIndex = userIndex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public Double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(final Double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(final Double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    public List<String> getPotentialMatches() {
        return potentialMatches;
    }

    public void setPotentialMatches(final List<String> potentialMatches) {
        this.potentialMatches = potentialMatches;
    }

    public Set<String> getIgnoredUserIds() {
        return ignoredUserIds;
    }

    public Set<String> getLikedUserIds() {
        return likedUserIds;
    }

    public Set<String> getMatchedUserIds() {
        return matchedUserIds;
    }

    public Set<String> getLikeUserIds() {
        return likeUserIds;
    }

    @Override public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
