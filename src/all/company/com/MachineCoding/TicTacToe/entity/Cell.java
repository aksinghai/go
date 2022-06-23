package all.company.com.MachineCoding.TicTacToe.entity;

public class Cell {
    private static int cellIndex = 0;

    private Integer id;
    private Integer player;

    public Cell(final Integer player) {
        this.id = cellIndex++;
        this.player = player;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getPlayer() {
        return player;
    }

    public void setPlayer(final Integer player) {
        this.player = player;
    }

    @Override public String toString() {
        return "Cell{" +
                "id=" + id +
                ", player=" + player +
                '}';
    }
}
