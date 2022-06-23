package all.company.com.MachineCoding.SnakeAndLadder.service;

import all.company.com.MachineCoding.SnakeAndLadder.entity.Box;
import all.company.com.MachineCoding.SnakeAndLadder.entity.Player;


public interface GameService {

    void init();

    Box move(Player player, int dice);

    boolean isWon(Player player);
}
