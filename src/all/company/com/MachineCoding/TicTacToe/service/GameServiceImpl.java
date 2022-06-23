package all.company.com.MachineCoding.TicTacToe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import all.company.com.MachineCoding.TicTacToe.TicTacToeApplication;
import all.company.com.MachineCoding.TicTacToe.entity.Game;
import all.company.com.MachineCoding.TicTacToe.entity.Player;


public class GameServiceImpl implements GameService {
    Map<Integer, Game> gameLookup;

    public GameServiceImpl() {
        gameLookup = new HashMap<>();
    }

    @Override public Game createGame(final int gridSize, final List<Integer> playerIds) {
        if(gridSize <= 2){
            throw new RuntimeException("Invalid Grid Size");
        }
        Game game = new Game(playerIds, gridSize);
        gameLookup.put(game.getId(), game);
        return game;
    }

    @Override public Game setMove(final int gameId, final int playerId, final int xAxis, final int yAxis) {
        Game game = gameLookup.get(gameId);
        if(game == null){
            throw new RuntimeException("Invalid Game");
        }
        if(xAxis >= game.getGridSize() || yAxis >= game.getGridSize()){
            throw new RuntimeException("Invalid Coordinate");
        }
        Player player = TicTacToeApplication.playerService.getPlayer(playerId);
        if(player == null){
            throw new RuntimeException("Player not found");
        }
        if(game.getBoard()[xAxis][yAxis] != null){
            throw new RuntimeException("Already Occupied");
        }
        System.out.println("Moved to "+xAxis+" and "+yAxis);
        game.getBoard()[xAxis][yAxis] = player.getSymbol();
        return game;
    }

    @Override public boolean isWin(final int gameId, final int xAxis, final int yAxis) {
        Game game = gameLookup.get(gameId);
        if(game == null){
            throw new RuntimeException("Invalid Game");
        }
        //LeftToRight
        int ctr = 0;
        char searchForChar = game.getBoard()[xAxis][yAxis];
        for(int j = 0; j < game.getGridSize(); j++){
            if(game.getBoard()[xAxis][j] != null && game.getBoard()[xAxis][j] == searchForChar){
                ctr++;
            }
        }
        if(ctr == 3){
            return true;
        }

        ctr = 0;
        //TopToBottom
        for(int i = 0; i < game.getGridSize(); i++){
            if(game.getBoard()[i][yAxis] != null && game.getBoard()[i][yAxis] == searchForChar){
                ctr++;
            }
        }
        if(ctr == 3){
            return true;
        }
        ctr = 0;
        //LeftToRight Diagonal
        for(int i = 0; i < game.getGridSize(); i++){
            if(game.getBoard()[i][i] != null && game.getBoard()[i][i] == searchForChar){
                ctr++;
            }
        }
        if(ctr == 3){
            return true;
        }
        ctr = 0;
        //RightToLeft Diagonal
        for(int i = game.getGridSize()-1; i >= 0; i--){
            if(game.getBoard()[i][i] != null && game.getBoard()[i][i] == searchForChar){
                ctr++;
            }
        }
        return ctr == 3;
    }

    public boolean noMoreMove(int gameId){
        Game game = gameLookup.get(gameId);
        for(int i = 0; i < game.getGridSize(); i++){
            for(int j = 0; j < game.getGridSize(); j++){
                if(game.getBoard()[i][j] == null){
                    return false;
                }
            }
        }
        return true;
    }

    public void printGrid(int gameId){
        Game game = gameLookup.get(gameId);
        for(int i = 0; i < game.getGridSize(); i++){
            for(int j = 0; j < game.getGridSize(); j++){
                if(game.getBoard()[i][j] == null){
                    System.out.print(" ");
                } else {
                    System.out.print(game.getBoard()[i][j]);
                }
            }
            System.out.println();
        }
    }
}
