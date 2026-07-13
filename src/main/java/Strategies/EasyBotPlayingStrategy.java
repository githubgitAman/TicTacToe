package Strategies;

import Models.Board;
import Models.Cell;
import Models.ENUMs.CELLSTATE;
import Models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row : board.getBoard()){
            for(Cell cell : row){
                if(cell.getCellState().equals(CELLSTATE.EMPTY)){
                    return new Move(cell, null);
                }
            }
        }
        return null;
    }
}
