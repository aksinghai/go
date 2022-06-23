package all.company.com.MachineCoding.SnakeAndLadderModified;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import all.company.com.MachineCoding.SnakeAndLadderModified.entity.Game;
import all.company.com.MachineCoding.SnakeAndLadderModified.entity.Player;
import all.company.com.MachineCoding.SnakeAndLadderModified.service.GameService;
import all.company.com.MachineCoding.SnakeAndLadderModified.service.GameServiceImpl;
import all.company.com.MachineCoding.SnakeAndLadderModified.service.PlayerService;
import all.company.com.MachineCoding.SnakeAndLadderModified.service.PlayerServiceImpl;


public class SnakeLadderGame {

    private static GameService gameService = new GameServiceImpl();
    private static PlayerService playerService = new PlayerServiceImpl();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------");
        while(true){
            System.out.println("Command : ");
            Command cmd = Command.valueOf(sc.nextLine());
            switch (cmd){
                case create_game: {
                    System.out.println("Board Size :");
                    int boardSize = Integer.parseInt(sc.nextLine());
                    System.out.println("Players :");
                    int playerCount = Integer.parseInt(sc.nextLine());
                    List<Integer> playerIdList = new ArrayList<>();
                    for(int i = 0; i < playerCount; i++){
                        Player player = playerService.createPlayer("Player"+(i+1));
                        playerIdList.add(player.getId());
                    }
                    Map<Integer, Integer> ladders = new HashMap<>();
                    ladders.put(4,14);
                    ladders.put(8,30);
                    ladders.put(21,42);
                    ladders.put(28,76);
                    ladders.put(50,67);
                    ladders.put(80,99);
                    ladders.put(71,92);

                    Map<Integer, Integer> snakes = new HashMap<>();
                    snakes.put(97,78);
                    snakes.put(95,56);
                    snakes.put(88,24);
                    snakes.put(62,18);
                    snakes.put(36,6);
                    snakes.put(32,10);
                    System.out.println(gameService.createGame(boardSize, snakes, ladders,playerIdList));
                    break;
                }
                case play:{
                    String gameId = sc.nextLine();
                    Game game = gameService.getGameById(gameId);
                    int index = 0;
                    while (true){
                        int playerId = (int) (index++ % game.getPlayers().size());
                        int pId = game.getPlayers().get(playerId);
                        Player player = playerService.getPlayer(pId);
                        if(gameService.holdDice(gameId, pId)){
                            gameService.rollDiceAndMove(gameId, game.getBoard(), player);
                            if(gameService.isWin(player, game.getBoard())){
                                System.out.println(player.getName()+" WON the GAME");
                                break;
                            }
                        }
                    }
                    break;
                }
                case exit: {
                    return;
                }
            }
        }
    }
}
