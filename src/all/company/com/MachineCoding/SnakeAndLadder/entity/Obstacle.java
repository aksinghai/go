package all.company.com.MachineCoding.SnakeAndLadder.entity;

public class Obstacle {
    private static Integer obstacleIndex = 0;

    private Integer id;
    private Integer sourceXAxis;
    private Integer sourceYAxis;
    private Integer destinationXAxis;
    private Integer destinationYAxis;
    private ObstacleType type;

    public Obstacle(final Integer sourceXAxis, final Integer sourceYAxis, final Integer destinationXAxis,
            final Integer destinationYAxis, ObstacleType type) {
        this.id = ++obstacleIndex;
        this.sourceXAxis = sourceXAxis;
        this.sourceYAxis = sourceYAxis;
        this.destinationXAxis = destinationXAxis;
        this.destinationYAxis = destinationYAxis;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getSourceXAxis() {
        return sourceXAxis;
    }

    public void setSourceXAxis(final Integer sourceXAxis) {
        this.sourceXAxis = sourceXAxis;
    }

    public Integer getSourceYAxis() {
        return sourceYAxis;
    }

    public void setSourceYAxis(final Integer sourceYAxis) {
        this.sourceYAxis = sourceYAxis;
    }

    public Integer getDestinationXAxis() {
        return destinationXAxis;
    }

    public void setDestinationXAxis(final Integer destinationXAxis) {
        this.destinationXAxis = destinationXAxis;
    }

    public Integer getDestinationYAxis() {
        return destinationYAxis;
    }

    public void setDestinationYAxis(final Integer destinationYAxis) {
        this.destinationYAxis = destinationYAxis;
    }

    public ObstacleType getType() {
        return type;
    }

    public void setType(final ObstacleType type) {
        this.type = type;
    }

    @Override public String toString() {
        return "Obstacle{" +
                "id=" + id +
                ", sourceXAxis=" + sourceXAxis +
                ", sourceYAxis=" + sourceYAxis +
                ", destinationXAxis=" + destinationXAxis +
                ", destinationYAxis=" + destinationYAxis +
                ", type=" + type +
                '}';
    }
}
