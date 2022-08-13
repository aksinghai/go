package all.company.com.ReadyForDocumentation.SnakeAndLadderModified.service;

import all.company.com.ReadyForDocumentation.SnakeAndLadderModified.entity.Player;


public interface PlayerService {

    Player createPlayer(String name);

    Player getPlayer(int playerId);

}
