package Models;

import Models.ENUMs.PLAYERTYPE;

public class Player {
    private String name;
    private Symbol symbol;
    private PLAYERTYPE playerType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PLAYERTYPE getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PLAYERTYPE playerType) {
        this.playerType = playerType;
    }
}
