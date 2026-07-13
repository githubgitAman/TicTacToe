## Project Structure

# Tic-Tac-Toe (Low Level Design)

A scalable, console-based Tic-Tac-Toe game built in Java. This project demonstrates object-oriented programming principles and low-level design patterns, featuring customizable board sizes, bot integration, and an undo move system.

## Features

* **Optimized Win Validation (O(1)):** Achieved O(1) time complexity for checking the winner using a nested Map of Maps approach, ensuring instantaneous validation even on massive NxN boards.
* **Dynamic Board Size:** Play on a standard 3x3 grid or scale up to NxN.
* **Human vs. Bot:** Includes a computer opponent with basic difficulty settings.
* **Undo Functionality:** Players can undo their last move.
* **Extensible Rules:** Built with the Strategy design pattern to easily add new winning configurations (Rows, Columns, Diagonals).
* **Robust Validation:** Custom exceptions to handle duplicate symbols, invalid bot counts, and incorrect player setups.

## Prerequisites

* Java Development Kit (JDK) 11 or higher (Tested on Java 21)
* A terminal or command prompt

The project follows a modular, object-oriented architecture:

```text
TicTacToe/
├── src/
│   ├── Client.java                  # Main execution class
│   ├── Controllers/
│   │   └── GameController.java      # Manages game flow and state
│   ├── Models/
│   │   ├── Game.java                # Core game entity (Uses Builder Pattern)
│   │   ├── Board.java               # NxN grid representation
│   │   ├── Player.java / Bot.java   # Player entities
│   │   ├── Move.java / Cell.java    # Grid units and tracking
│   │   ├── Symbol.java etc          # Player markers
│   │   └── ENUMs/                   # GAMESTATE, PLAYERTYPE, etc.
│   ├── Strategies/                  # Winning Logic (Strategy Pattern)
│   │   ├── WinningStrategy.java     # Interface for winning logic
│   │   ├── RowWinningStrategy.java
│   │   ├── ColWinningStrategy.java
│   │   └── DiagWinningStrategy.java # Optimized O(1) validations
│   └── Exceptions/                  # Custom validations
│       ├── BotCountException.java
│       ├── PlayerCountException.java
│       └── DuplicateSymbolException.java

## How to Run

1. **Clone the repository**
   ```bash
   git clone [https://github.com/githubgitAman/TicTacToe.git](https://github.com/githubgitAman/TicTacToe.git)
   cd TicTacToe
