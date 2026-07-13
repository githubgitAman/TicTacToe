package Strategies;

import Models.Board;
import Models.Move;

public interface WinningStrategy {
    boolean getWinningStrategy(Move move, Board board);
    void handleUndo(Move move, Board board);
}
