package all.company.com.MachineCoding.SnakeAndLadder.service;

import all.company.com.MachineCoding.SnakeAndLadder.entity.Player;


public interface PlayerService {

    Player createPlayer(String name);

    Player getPlayer(Integer id);

}
