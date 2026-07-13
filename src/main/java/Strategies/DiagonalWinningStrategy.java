package Strategies;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {

    private Map<Symbol, Integer> leftDiagonal = new HashMap<>();

    private Map<Symbol, Integer> rightDiagonal = new HashMap<>();

    @Override
    public boolean getWinningStrategy(Move move, Board board) {
        Symbol symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row == col){
            leftDiagonal.put(symbol, leftDiagonal.getOrDefault(symbol, 0) + 1);

            if(leftDiagonal.get(symbol) == board.getDimension()){
                return true;
            }
        }
        if(row + col == board.getDimension() - 1){
            rightDiagonal.put(symbol, rightDiagonal.getOrDefault(symbol, 0) + 1);

            if(rightDiagonal.get(symbol) == board.getDimension()){
                return true;
            }
        }

        return false;
    }
    @Override
    public void handleUndo(Move move, Board board) {
        Symbol symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row == col){
            leftDiagonal.put(symbol, leftDiagonal.get(symbol) - 1);
        }

        if(row + col == board.getDimension() - 1){
            rightDiagonal.put(symbol, rightDiagonal.get(symbol) - 1);
        }
    }
}
