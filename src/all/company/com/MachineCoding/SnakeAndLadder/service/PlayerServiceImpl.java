package all.company.com.MachineCoding.SnakeAndLadder.service;

import java.util.HashMap;
import java.util.Map;
import all.company.com.MachineCoding.SnakeAndLadder.entity.Player;
import all.company.com.MachineCoding.SnakeAndLadder.exception.InvalidORMissingParamException;


public class PlayerServiceImpl implements PlayerService {

    private final Map<Integer, Player> playerMap = new HashMap<>();

    @Override public Player createPlayer(final String name) {
        if(name == null || name.isEmpty()){
            throw new InvalidORMissingParamException("Invalid Value");
        }
        Player player = new Player(name, -1, -1);
        playerMap.put(player.getId(), player);
        return player;
    }

    @Override public Player getPlayer(final Integer id) {
        if(playerMap.containsKey(id)){
            return playerMap.get(id);
        }
        return null;
    }
}
