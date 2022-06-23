package all.company.com.MachineCoding.SnakeAndLadder.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import all.company.com.MachineCoding.SnakeAndLadder.entity.Box;
import all.company.com.MachineCoding.SnakeAndLadder.entity.Obstacle;
import all.company.com.MachineCoding.SnakeAndLadder.entity.ObstacleType;
import all.company.com.MachineCoding.SnakeAndLadder.entity.Player;


public class GameServiceImpl implements GameService {

    private Box[][] board;
    private Integer boxes;
    private Integer openingDice;

    public void init(){
        int N = 10;
        openingDice = 1;
        board = new Box[N][N];
        boxes = N * N;
        boolean fwd = true;
        int index = 1;
        for(int i = 0; i < board.length; i++){
            if(fwd){
                for(int j = 0; j < board[i].length; j++){
                    board[i][j] = new Box(index++, null);
                }
            } else {
                for(int j = board[i].length -1; j >= 0; j--){
                    board[i][j] = new Box(index++, null);
                }
            }
            fwd = !fwd;
        }
        List<Obstacle> snacks = new ArrayList<Obstacle>(Arrays.asList(
                new Obstacle(5, 1, 1,2, ObstacleType.SNAKE),
                new Obstacle(9, 3, 7,2, ObstacleType.SNAKE),
                new Obstacle(9, 5, 5,4, ObstacleType.SNAKE),
                new Obstacle(8, 7, 2,3, ObstacleType.SNAKE),
                new Obstacle(3, 4, 0,5, ObstacleType.SNAKE),
                new Obstacle(4, 7, 2,5, ObstacleType.SNAKE),
                new Obstacle(3, 8, 0,9, ObstacleType.SNAKE)
        ));
        List<Obstacle> ladders = new ArrayList<>(Arrays.asList(
                new Obstacle(0,0,3,2, ObstacleType.LADDER),
                new Obstacle(0,3,1,6, ObstacleType.LADDER),
                new Obstacle(0,7,2,9, ObstacleType.LADDER),
                new Obstacle(2,0,4,1, ObstacleType.LADDER),
                new Obstacle(2,7,7,4, ObstacleType.LADDER),
                new Obstacle(4,9,6,6, ObstacleType.LADDER),
                new Obstacle(7,0,9,1, ObstacleType.LADDER),
                new Obstacle(7,9,9,8, ObstacleType.LADDER)
        ));

        for(Obstacle snake : snacks) {
            board[snake.getSourceXAxis()][snake.getDestinationYAxis()].setObstacle(snake);
        }

        for(Obstacle ladder : ladders) {
            board[ladder.getSourceXAxis()][ladder.getDestinationYAxis()].setObstacle(ladder);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j].getBoxNum()+" ");
            }
            System.out.println();
        }
    }

    @Override public Box move(final Player player, int dice) {
        if(player.getxAxis() == -1 && player.getyAxis() == -1 ){
            if(dice != openingDice){
                return null;
            } else {
                player.setxAxis(0);
                player.setyAxis(openingDice-1);
                board[0][openingDice-1].getPlayers().add(player);
                return board[0][openingDice];
            }
        }

        if((player.getxAxis() * 10) + (player.getyAxis()+1) + dice > boxes) {
            return board[player.getxAxis()][player.getyAxis()];
        }

        List<Player> playerList = board[player.getxAxis()][player.getyAxis()].getPlayers();
        playerList.remove(player);
        int i = player.getxAxis();
        int j = 0;
        for(; i < board.length; i++){
            if(i % 2 == 0) {
                for(j = player.getyAxis(); j < board[i].length; j++){
                    if(dice == 0){
                        break;
                    }
                    dice--;
                }
            } else {
                for(j = board[i].length-1; j >= 0; j--){
                    if(dice == 0){
                        break;
                    }
                    dice--;
                }
            }
            if(dice == 0){
                break;
            }
        }
        player.setxAxis(i);
        player.setyAxis(j);
        board[i][j].getPlayers().add(player);
        return board[i][j];
    }

    @Override public boolean isWon(final Player player) {
        if(player.getxAxis() == (board.length-1) && player.getyAxis() == (board.length-1)){
            return true;
        }
        return false;
    }

    public Box getBox(int xAxis, int yAxis){
        return board[xAxis][yAxis];
    }
}
