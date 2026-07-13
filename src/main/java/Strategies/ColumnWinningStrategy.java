package Strategies;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {

    //Creating map of map to store count of each symbol across all columns
    //We can also use list of maps
    private Map<Integer, Map<Symbol, Integer>> columnMap = new HashMap<>();

    @Override
    public boolean getWinningStrategy(Move move, Board board) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!columnMap.containsKey(col)) {
            columnMap.put(col, new HashMap<>());
        }

        Map<Symbol, Integer> counter = columnMap.get(col);
        //Updating count for symbol across each column
        counter.put(symbol, counter.getOrDefault(symbol, 0) + 1);

        return counter.get(symbol) == board.getDimension();
    }

    @Override
    public void handleUndo(Move move, Board board) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol, Integer> counter = columnMap.get(col);
        counter.put(symbol, counter.get(symbol) - 1);
    }
}
