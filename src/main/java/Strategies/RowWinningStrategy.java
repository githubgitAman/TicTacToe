package Strategies;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {

    //Creating map of map to store count of each symbol across all rows
    //We can also use list of maps
    private Map<Integer, Map<Symbol, Integer>> rowMap = new HashMap<>();

    @Override
    public boolean getWinningStrategy(Move move, Board board) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!rowMap.containsKey(row)) {
            rowMap.put(row, new HashMap<>());
        }

        Map<Symbol, Integer> counter = rowMap.get(row);
        //Updating count for symbol across each column
        counter.put(symbol, counter.getOrDefault(symbol, 0) + 1);

        return counter.get(symbol) == board.getDimension();
    }

    @Override
    public void handleUndo(Move move, Board board) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol, Integer> counter = rowMap.get(row);
        counter.put(symbol, counter.get(symbol) - 1);
    }
}
