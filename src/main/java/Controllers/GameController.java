package Controllers;

import Exceptions.BotCountException;
import Exceptions.DuplicateSymbolException;
import Exceptions.PlayerCountException;
import Models.ENUMs.GAMESTATE;
import Models.Game;
import Models.Player;
import Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public Game startGame(List<Player> players, int size
            , List<WinningStrategy> winningStrategy) throws PlayerCountException, DuplicateSymbolException, BotCountException {

        Game gameObject = Game.getBuilder()
                .setSize(1)
                .setPlayers(new ArrayList<>())
                .setWinningStrategy(new ArrayList<>())
                .build();

        return gameObject;
    }
    public void makeMove(Game game) {
        game.makeMove();
    }
    public GAMESTATE checkStatus(Game game) {
        return game.getGameState();
    }
    public void printBoard(Game game) {
        game.printBoard();
    }
    private Player getWinner(Game game) {
       return game.getWinner();
    }
    public void undo(Game game) {
        game.undo();
    }
}
