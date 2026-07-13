package Models;

import Models.ENUMs.BOTDIFFICULTYLEVEL;
import Models.ENUMs.PLAYERTYPE;
import Strategies.BotPlayingStrategy;
import Strategies.BotPlayingStrategyFactory;

public class Bot extends Player {
    private BOTDIFFICULTYLEVEL difficulty;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name,
               Symbol symbol,
               Long id,
               BOTDIFFICULTYLEVEL difficulty) {
        super(name, symbol, id, PLAYERTYPE.BOT);
        this.difficulty = difficulty;
        this.botPlayingStrategy = BotPlayingStrategyFactory
                .getBotPlayingStrategy(difficulty);
    }

    public BOTDIFFICULTYLEVEL getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(BOTDIFFICULTYLEVEL difficulty) {
        this.difficulty = difficulty;
    }

    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}
