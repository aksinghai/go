package all.company.com.MachineCoding.TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import all.company.com.MachineCoding.TicTacToe.entity.Game;
import all.company.com.MachineCoding.TicTacToe.entity.Player;
import all.company.com.MachineCoding.TicTacToe.service.GameService;
import all.company.com.MachineCoding.TicTacToe.service.GameServiceImpl;
import all.company.com.MachineCoding.TicTacToe.service.PlayerService;
import all.company.com.MachineCoding.TicTacToe.service.PlayerServiceImpl;


public class TicTacToeApplication {
    public static final PlayerService playerService;
    public static final GameService gameService;

    static {
        playerService = new PlayerServiceImpl();
        gameService = new GameServiceImpl();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------ TIC TAC TOE ------------");
        while (true) {
            System.out.println("Command : ");
            Command cmd = Command.valueOf(sc.nextLine());
            switch (cmd) {
                case play: {
                    List<Integer> players = new ArrayList<>();
                    System.out.println("Player 1 Name: ");
                    String name1 = sc.nextLine();
                    Player player1 = playerService.createPlayer(name1,'X');
                    System.out.println(player1);
                    System.out.println("Player 2 Name: ");
                    String name2 = sc.nextLine();
                    players.add(player1.getId());
                    Player player2 = playerService.createPlayer(name2, 'O');
                    System.out.println(player2);
                    players.add(player2.getId());
                    System.out.println("Grid size ?");
                    int gridSize = Integer.parseInt(sc.nextLine());
                    Game game = gameService.createGame(gridSize, players);
                    System.out.println(game);
                    int index = 0;
                    while (true) {
                        Player playerChance = playerService.getPlayer(players.get(index % 2));
                        System.out.println(playerChance.getName() + ":");
                        int xAxis = Integer.parseInt(sc.nextLine());
                        int yAxis = Integer.parseInt(sc.nextLine());
                        gameService.setMove(game.getId(), players.get(index%2), xAxis, yAxis);
                        gameService.printGrid(game.getId());
                        if(gameService.isWin(game.getId(), xAxis, yAxis)){
                            System.out.println(playerChance.getName()+" Won the game");
                            break;
                        } else if(gameService.noMoreMove(game.getId())) {
                            System.out.println("Game Tie, No one won the game.");
                            break;
                        }
                        index++;
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
