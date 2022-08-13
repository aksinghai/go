package all.company.com.MachineCoding.SnakeAndLadder;

import static all.company.com.MachineCoding.SnakeAndLadder.Command.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import all.company.com.MachineCoding.SnakeAndLadder.entity.Box;
import all.company.com.MachineCoding.SnakeAndLadder.entity.Player;
import all.company.com.MachineCoding.SnakeAndLadder.service.GameService;
import all.company.com.MachineCoding.SnakeAndLadder.service.GameServiceImpl;
import all.company.com.MachineCoding.SnakeAndLadder.service.PlayerService;
import all.company.com.MachineCoding.SnakeAndLadder.service.PlayerServiceImpl;


public class SnackAndLadderDriver {

    static PlayerService playerService = new PlayerServiceImpl();
    static GameService gameService = new GameServiceImpl();

    public static void main(String[] args) {

        System.out.println("---------- SNACK AND LADDER ---------");
        Scanner sc = new Scanner(System.in);
        List<Integer> playerIds = new ArrayList<>();
        int chance = 0;
        int iteration = 0;
        while (true) {
            System.out.println("Command : ");
            Command cmd = valueOf(sc.nextLine());
            switch (cmd) {
                case init: {
                    gameService.init();
                    System.out.println("Enter Number of players");
                    int n = Integer.parseInt(sc.nextLine());
                    for(int i = 0; i < n; i++){
                        System.out.println("Name of Player "+(i+1)+" :");
                        String name = sc.nextLine();
                        Player player = playerService.createPlayer(name);
                        playerIds.add(player.getId());
                    }
                    for(int playerId : playerIds){
                        System.out.print(playerService.getPlayer(playerId).getName()+" ");
                    }
                    System.out.print(" are playing, chances are in sequence");
                    break;
                }
                case run:
                    while(true){
                        int six = 0;
                        while(six < 3){
                            int dice = ((int)(Math.random() * 100) % 6) + 1;
                            Player player = playerService.getPlayer(playerIds.get(chance));
                            System.out.println(player.getName()+" : "+ dice);
                            Box box = gameService.move(player,dice);
                            if(gameService.isWon(player)){
                                System.out.println(player.getName() + " Won the game !!!");
                                return;
                            }
                            if(box != null){
                                System.out.println(
                                        player.getName() + " is on " +box.getBoxNum());
                            } else {
                                System.out.println(player.getName() + " is Not open");
                            }
                            if(dice == 6){
                                six++;
                            } else {
                                chance = (++iteration % playerIds.size());
                                break;
                            }
                        }
                    }
                case exit:
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + cmd);
            }
        }
    }
}
