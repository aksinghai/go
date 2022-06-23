package all.company.com.MachineCoding.TicTacToe.service;

import java.util.HashMap;
import java.util.Map;
import all.company.com.MachineCoding.TicTacToe.entity.Player;


public class PlayerServiceImpl implements PlayerService {
    private Map<Integer, Player> playerLookup;

    public PlayerServiceImpl() {
        playerLookup = new HashMap<>();
    }

    @Override public Player createPlayer(final String name, final Character symbol) {
        if(name == null || name.isEmpty()){
            throw new RuntimeException("Invalid input");
        }
        Player player = new Player(name, symbol);
        playerLookup.put(player.getId(), player);
        return player;
    }

    @Override public Player getPlayer(final Integer playerId) {
        if(playerId == null || playerId == 0){
            throw new RuntimeException("Invalid input");
        }
        return playerLookup.get(playerId);
    }
}
