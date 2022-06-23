package all.company.com.MachineCoding.TicTacToe.entity;

public class Player {
    private static int playerIndex = 1;

    private Integer id;
    private String name;
    private Character symbol;

    public Player(final String name, final Character symbol) {
        this.id = playerIndex++;
        this.name = name;
        this.symbol = symbol;
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

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(final Character symbol) {
        this.symbol = symbol;
    }

    @Override public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}
