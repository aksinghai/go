package all.company.com.ReadyForDocumentation.SnakeAndLadderModified.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import all.company.com.ReadyForDocumentation.SnakeAndLadderModified.entity.Cell;
import all.company.com.ReadyForDocumentation.SnakeAndLadderModified.entity.Game;
import all.company.com.ReadyForDocumentation.SnakeAndLadderModified.entity.Ladder;
import all.company.com.ReadyForDocumentation.SnakeAndLadderModified.entity.Obstacle;
import all.company.com.ReadyForDocumentation.SnakeAndLadderModified.entity.Player;
import all.company.com.ReadyForDocumentation.SnakeAndLadderModified.entity.Snake;


public class GameServiceImpl implements GameService {

    private Map<String, Game> gameMap;
    private Map<String, Set<Integer>> gameChances = new HashMap<>();
    private Map<Integer, String> cellNoToIndexMap = new HashMap<>();
    private final int openingDice = 1;

    public GameServiceImpl() {
        this.gameMap = new HashMap<>();
    }

    @Override public String createGame(final int boardSize, final Map<Integer, Integer> snakes,
            final Map<Integer, Integer> ladders,
            final List<Integer> players) {

        Game game = new Game(players, boardSize);
        Cell[][] board = game.getBoard();

        int index = 1;
        for(int i = 0; i < board.length; i++){
            if(i % 2 == 0){
                for(int j = 0; j < board[i].length; j++){
                    board[i][j] = new Cell(index++, null);
                    cellNoToIndexMap.put(board[i][j].getCellNum(), i+"_"+j);
                    if(snakes.containsKey(board[i][j].getCellNum())){
                        Snake snake = new Snake(board[i][j].getCellNum(), snakes.get(board[i][j].getCellNum()));
                        board[i][j].setObstacle(snake);
                    } else if (ladders.containsKey(board[i][j].getCellNum())) {
                        Ladder ladder = new Ladder(board[i][j].getCellNum(), ladders.get(board[i][j].getCellNum()));
                        board[i][j].setObstacle(ladder);
                    }
                }
            } else {
                for(int j = board[i].length - 1; j >= 0 ; j--){
                    board[i][j] = new Cell(index++, null);
                    cellNoToIndexMap.put(board[i][j].getCellNum(), i+"_"+j);
                    if(snakes.containsKey(board[i][j].getCellNum())){
                        Snake snake = new Snake(board[i][j].getCellNum(), snakes.get(board[i][j].getCellNum()));
                        board[i][j].setObstacle(snake);
                    } else if (ladders.containsKey(board[i][j].getCellNum())) {
                        Ladder ladder = new Ladder(board[i][j].getCellNum(), ladders.get(board[i][j].getCellNum()));
                        board[i][j].setObstacle(ladder);
                    }
                }
            }
        }
        Set<Integer> chanceRemaining = new HashSet<>(players);
        gameChances.put(game.getId(), chanceRemaining);
        gameMap.put(game.getId(), game);
        return game.getId();
    }

    @Override public Boolean holdDice(final String gameId, final int playerId) {
        if(!gameChances.containsKey(gameId)){
            System.out.println("Issue");
            return false;
        }
        if(gameChances.get(gameId).contains(playerId)){
            gameChances.get(gameId).remove(playerId);
            if(gameChances.get(gameId).isEmpty()){
                gameChances.put(gameId,new HashSet<>(gameMap.get(gameId).getPlayers()));
            }
            return true;
        }
        return false;
    }

    @Override public void rollDiceAndMove(final String gameId, final Cell[][] board, final Player player) {
        int maxChance = 1;
        int currentChance = 1;
        while (currentChance <= maxChance){
            int dice = roleDiceRandom();
            if(dice == 6 && currentChance == 1 && player.getCellNo() != 0){
                maxChance = 2;
            } else if (dice == 6 && currentChance == 2 && player.getCellNo() != 0){
                maxChance = 3;
            }
            currentChance++;
            System.out.println(player.getName()+ " Got : ["+dice+"]");
            boolean moved = false;
            if(player.getCellNo() == 0) { //First Chance
                if(dice == openingDice) {
                    Cell expectedDestination  = getCellByNumber(board, (player.getCellNo() + dice));
                    if(expectedDestination.getPlayers().size() < expectedDestination.getCapacity()){
                        List<Player> players = expectedDestination.getPlayers();
                        players.add(player);
                        player.setCellNo(player.getCellNo() + dice);
                        moved = true;
                    }
                }
            } else { //Next Chance
                Cell currentCell = getCellByNumber(board, player.getCellNo());
                if(currentCell.getCellNum() + dice <= (board.length * board.length)){
                    Cell expectedDestination = getCellByNumber(board, currentCell.getCellNum() + dice);
                    if(expectedDestination.getPlayers().size() < expectedDestination.getCapacity()) {
                        List<Player> players = expectedDestination.getPlayers();
                        players.add(player);
                        player.setCellNo(player.getCellNo() + dice);
                        currentCell.getPlayers().remove(player);
                        moved = true;
                    }
                }
            }

            if(moved) {
                Obstacle obstacle = getCellByNumber(board, player.getCellNo()).getObstacle();
                if(obstacle != null){
                    Cell expectedDestination = getCellByNumber(board, obstacle.getEnd());
                    if(expectedDestination.getCapacity() > expectedDestination.getPlayers().size()){
                        getCellByNumber(board, player.getCellNo()).getPlayers().remove(player);
                        player.setCellNo(obstacle.getEnd());
                        if(obstacle instanceof Snake){
                            System.out.println(player.getName()+ " bitten by snake on : "+ obstacle.getFrom()+ " reached "
                                    + "to: "+obstacle.getEnd());
                        } else {
                            System.out.println(player.getName()+ " got Ladder on : "+ obstacle.getFrom()+ " reached "
                                    + "to: "+obstacle.getEnd());
                        }
                    }
                }
                System.out.println(player.getName()+ " Reached "+player.getCellNo());
            } else {
                System.out.println(player.getName()+ " Not Moved, still on "+player.getCellNo());
            }
            System.out.println();
        }
    }

    private int roleDiceRandom() {
        return (int) (1 + ((Math.random() * 100) % 6));
    }

    @Override public Game getGameById(final String gameId) {
        return gameMap.get(gameId);
    }

    @Override public boolean isWin(final Player player, final Cell[][] board) {
        return player.getCellNo() == (board.length * board.length);
    }

    private Cell getCellByNumber(Cell[][] board, Integer number){
        String[] index = cellNoToIndexMap.get(number).split("_");
        return board[Integer.parseInt(index[0])][Integer.parseInt(index[1])];
    }
}
