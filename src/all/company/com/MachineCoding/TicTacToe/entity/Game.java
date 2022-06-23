package all.company.com.MachineCoding.TicTacToe.entity;

import java.util.List;


public class Game {

    private static int gameIndex = 1;

    private Integer id;
    private List<Integer> playerIds;
    private Integer winner;
    private Integer gridSize;
    private Character[][] board;

    public Game(final List<Integer> playerIds, final Integer gridSize) {
        this.id = gameIndex++;
        this.playerIds = playerIds;
        this.gridSize = gridSize;
        this.board = new Character[gridSize][gridSize];
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public List<Integer> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(final List<Integer> playerIds) {
        this.playerIds = playerIds;
    }

    public Integer getWinner() {
        return winner;
    }

    public void setWinner(final Integer winner) {
        this.winner = winner;
    }

    public Integer getGridSize() {
        return gridSize;
    }

    public void setGridSize(final Integer gridSize) {
        this.gridSize = gridSize;
    }

    public Character[][] getBoard() {
        return board;
    }

    public void setBoard(final Character[][] board) {
        this.board = board;
    }

    @Override public String toString() {
        return "Game{" +
                "id=" + id +
                ", playerIds=" + playerIds +
                ", winner=" + winner +
                ", gridSize=" + gridSize +
                '}';
    }
}
