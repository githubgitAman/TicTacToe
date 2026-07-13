package Models;

import Models.ENUMs.PLAYERTYPE;

import java.util.Scanner;

public class Player {
    private Long id;
    private String name;
    private Symbol symbol;
    private PLAYERTYPE playerType;
    private Scanner scanner;

    public Player(String name, Symbol symbol, Long id, PLAYERTYPE playerType) {
        this.name = name;
        this.symbol = symbol;
        // TODO : Assuming id is given from outside
        this.id = id;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }
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

    public Move makeMove(Board board) {
        System.out.println("Please give the row where you want to make the move");
        int row = scanner.nextInt();
        System.out.println("Please give the column where you want to make the move");
        int column = scanner.nextInt();

        return new Move(new Cell(row, column), this);
    }
}
