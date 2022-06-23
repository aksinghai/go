package all.company.com.MachineCoding.SnakeAndLadder.entity;

public class Player {
    private static Integer userIndex = 0;

    private Integer id;
    private String name;
    private Integer xAxis;
    private Integer yAxis;

    public Player(final String name, final Integer xAxis, final Integer yAxis) {
        this.id = ++userIndex;
        this.name = name;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
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

    public Integer getxAxis() {
        return xAxis;
    }

    public void setxAxis(final Integer xAxis) {
        this.xAxis = xAxis;
    }

    public Integer getyAxis() {
        return yAxis;
    }

    public void setyAxis(final Integer yAxis) {
        this.yAxis = yAxis;
    }

    @Override public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", xAxis=" + xAxis +
                ", yAxis=" + yAxis +
                '}';
    }
}
