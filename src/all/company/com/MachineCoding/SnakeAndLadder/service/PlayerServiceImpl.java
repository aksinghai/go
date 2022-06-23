package all.company.com.MachineCoding.SnakeAndLadder.service;

import java.util.HashMap;
import java.util.Map;
import all.company.com.MachineCoding.SnakeAndLadder.entity.Player;


public class PlayerServiceImpl implements PlayerService {

    private Map<Integer, Player> playerMap = new HashMap<>();

    @Override public Player createPlayer(final String name) {
        return new Player(name, 0, 0);
    }

    @Override public Player getPlayer(final Integer id) {
        if(playerMap.containsKey(id)){
            return playerMap.get(id);
        }
        return null;
    }
}
