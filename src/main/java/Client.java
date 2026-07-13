import Controllers.GameController;
import Exceptions.BotCountException;
import Exceptions.DuplicateSymbolException;
import Exceptions.PlayerCountException;
import Models.ENUMs.GAMESTATE;
import Models.ENUMs.PLAYERTYPE;
import Models.Game;
import Models.Player;
import Models.Symbol;
import Strategies.ColumnWinningStrategy;
import Strategies.DiagonalWinningStrategy;
import Strategies.RowWinningStrategy;
import Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws PlayerCountException, DuplicateSymbolException, BotCountException {
        GameController gameController = new GameController();
        List<Player> playerList = new ArrayList<>();
        playerList.add(
                new Player("PlayerOne"
                        , new Symbol('@')
                        , 1L
                        , PLAYERTYPE.HUMAN));
        playerList.add(
                new Player("PlayerTwo"
                        , new Symbol('₹')
                        , 2L
                        , PLAYERTYPE.BOT));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.startGame(playerList, 3, winningStrategies);

        while(gameController.checkStatus(game) == GAMESTATE.IN_PROGRESS) {
            gameController.printBoard(game);
            gameController.makeMove(game);
        }

        if(gameController.checkStatus(game) == GAMESTATE.ENDED){
            System.out.println("Game Ended and Winner is " + game.getWinner());
        }
        else{
            System.out.println("Game has Drawn");
        }
    }
}
