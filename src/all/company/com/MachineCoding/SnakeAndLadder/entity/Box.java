package all.company.com.MachineCoding.SnakeAndLadder.entity;

import java.util.ArrayList;
import java.util.List;


public class Box {

    private static int boxIndex = 0;

    private Integer id;
    private Integer boxNum;
    private List<Player> players;
    private Obstacle obstacle;

    public Box(final Integer boxNum, final Obstacle obstacle) {
        this.id = Box.boxIndex++;
        this.boxNum = boxNum;
        this.obstacle = obstacle;
        this.players = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(final Integer boxNum) {
        this.boxNum = boxNum;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(final List<Player> players) {
        this.players = players;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(final Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    @Override public String toString() {
        return "Box{" +
                "id=" + id +
                ", boxNum=" + boxNum +
                ", players=" + players +
                ", obstacle=" + obstacle +
                '}';
    }
}
