package Models;

import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import Exceptions.DuplicateSymbolException;
import Models.ENUMs.GAMESTATE;
import Models.ENUMs.PLAYERTYPE;
import Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private GAMESTATE gameState;
    private Player winner;
    private int nextMovePlayerIndex;
    private List<WinningStrategy> winningStrategy;

    //Using builder we are forcing that user cannot create Game object without player and winning strategy attributes

    private Game(List<Player> players, int dimensionOfBoard, List<WinningStrategy> winningStrategy) {
        this.players = players;
        //Creating board using dimension
        this.board = new Board(dimensionOfBoard);
        this.winningStrategy = winningStrategy;
        this.moves = new ArrayList<>();
        this.gameState = GAMESTATE.IN_PROGRESS;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    //Before building game we need to
    // 1. Validate number of players
    // 2. Dimension of game
    // 3. The winning strategy
    public static class Builder{
        private List<Player> players;
        private int size;
        private List<WinningStrategy> winningStrategy;

        //Method to validate
        //TODO : add more validation to check if input is correct or not
        //TODO : move validation logic to a different class

        public void validatePlayerCount() throws PlayerCountException {
            if(players.size() != (size - 1)){
                throw new PlayerCountException();
            }
        }
        public void validateSymbolUniqueness() throws DuplicateSymbolException {
            Map<Symbol, Integer> countMap = new HashMap<>();
            for(Player player : players){
                Symbol symbol = player.getSymbol();
                //Checking freq of symbol for each player
                countMap.put(symbol, countMap.getOrDefault(symbol, 0) + 1);

                if(countMap.get(symbol) > 1){
                    throw new DuplicateSymbolException();
                }
            }
        }
        public void validateBotCount() throws BotCountException {
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType() == PLAYERTYPE.BOT){
                    botCount++;
                }
            }
            if(botCount > 1){
                throw new BotCountException();
            }
        }
        public void validate() throws PlayerCountException, DuplicateSymbolException, BotCountException {
            validatePlayerCount();
            validateSymbolUniqueness();
            validateBotCount();
        }

        //Build method returning game object
        public Game build() throws PlayerCountException, DuplicateSymbolException, BotCountException {
            validate();
            return new Game(players, size, winningStrategy);
        }

        public Builder(){
            this.players = new ArrayList<>();
            this.winningStrategy = new ArrayList<>();
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setWinningStrategy(List<WinningStrategy> winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }
    }

    /* GETTERS AND SETTER BELOW */
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GAMESTATE getGameState() {
        return gameState;
    }

    public void setGameState(GAMESTATE gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(List<WinningStrategy> winningStrategy) {
        this.winningStrategy = winningStrategy;
    }
}
