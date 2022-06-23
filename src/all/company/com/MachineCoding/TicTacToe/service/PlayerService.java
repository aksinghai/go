package all.company.com.MachineCoding.TicTacToe.service;

import all.company.com.MachineCoding.TicTacToe.entity.Player;


public interface PlayerService {

    Player createPlayer(String name, Character symbol);

    Player getPlayer(Integer playerId);

}
