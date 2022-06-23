package all.company.com.MachineCoding.SnakeAndLadderModified.service;

import java.util.List;
import java.util.Map;
import all.company.com.MachineCoding.SnakeAndLadderModified.entity.Cell;
import all.company.com.MachineCoding.SnakeAndLadderModified.entity.Game;
import all.company.com.MachineCoding.SnakeAndLadderModified.entity.Player;


public interface GameService {

    String createGame(int boardSize, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<Integer> playerId);

    Boolean holdDice(String gameId, int playerId);

    void rollDiceAndMove(String gameId, Cell[][] board,  Player player);

    Game getGameById(String gameId);

    boolean isWin(Player player, final Cell[][] board);
}
