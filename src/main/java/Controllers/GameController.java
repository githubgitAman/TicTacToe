package Controllers;

import Exceptions.BotCountException;
import Exceptions.DuplicateSymbolException;
import Exceptions.PlayerCountException;
import Models.Game;

import java.util.ArrayList;

public class GameController {
    public Game startGame() throws PlayerCountException, DuplicateSymbolException, BotCountException {
        Game gameObject = Game.getBuilder()
                .setSize(1)
                .setPlayers(new ArrayList<>())
                .setWinningStrategy(new ArrayList<>())
                .build();

        return gameObject;
    }
    public void makeMove() {

    }
    public void checkStatus(){

    }
    public void printBoard(){

    }
    private void getWinner(){

    }

}
