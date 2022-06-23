package all.company.com.MachineCoding.TicTacToe.service;

import java.util.List;
import all.company.com.MachineCoding.TicTacToe.entity.Game;


public interface GameService {

    Game createGame(int gridSize, List<Integer> playerIds);

    Game setMove(int gameId, int playerId, int xAxis, int yAxis);

    boolean isWin(int gameId, int xAxis, int yAxis);

    boolean noMoreMove(int gameId);

    void printGrid(int gameId);

}
