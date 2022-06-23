package all.company.com.MachineCoding.SnakeAndLadderModified.entity;

public class Player {

    private static Integer playerIndex = 0;

    private int id;
    private String name;
    private Integer cellNo;

    public Player(final String name, final Integer cellNo) {
        this.id = ++playerIndex;
        this.name = name;
        this.cellNo = cellNo;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getCellNo() {
        return cellNo;
    }

    public void setCellNo(final Integer cellNo) {
        this.cellNo = cellNo;
    }

    @Override public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cellNo=" + cellNo +
                '}';
    }
}
