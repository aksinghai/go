package all.company.com.MachineCoding.SnakeAndLadderModified.service;

import all.company.com.MachineCoding.SnakeAndLadderModified.entity.Player;


public interface PlayerService {

    Player createPlayer(String name);

    Player getPlayer(int playerId);

}
