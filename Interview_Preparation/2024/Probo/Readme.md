# Snake Ladder LLD

To design a Snakes and Ladders game in Java following SOLID principles and OOP principles, we can create classes to represent the game board, players, and the game itself. Here's a possible design:

1. **Square**: This class represents each square on the game board. It will have properties like position, type (normal, ladder, snake), and destination (if it's a ladder or a snake).

2. **Board**: This class represents the game board. It contains an array or a collection of Square objects. It provides methods to move players, check for ladder or snake encounters, etc.

3. **Player**: This class represents a player in the game. It will have properties like name and current position on the board. It will also have methods to move the player.

4. **Game**: This class represents the Snakes and Ladders game itself. It will have properties like the board, players, and methods to start and play the game.

Here's how the code might look:

```java
import java.util.HashMap;
import java.util.Map;

// Enum to represent types of squares (Normal, Ladder, Snake)
enum SquareType {
    NORMAL,
    LADDER,
    SNAKE
}

// Class to represent each square on the board
class Square {
    private int position;
    private SquareType type;
    private int destination; // Destination position for ladders or snakes

    public Square(int position, SquareType type) {
        this.position = position;
        this.type = type;
        this.destination = position; // By default, destination is the same as position
    }

    // Getters and setters
    // Method to set destination for ladders or snakes
    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getDestination() {
        return destination;
    }

    // Other methods as needed
}

// Class to represent the game board
class Board {
    private Square[] squares;

    public Board(int size) {
        squares = new Square[size];
        for (int i = 0; i < size; i++) {
            squares[i] = new Square(i, SquareType.NORMAL);
        }
    }

    // Method to add ladder
    public void addLadder(int start, int end) {
        squares[start].setDestination(end);
        squares[start].setType(SquareType.LADDER);
    }

    // Method to add snake
    public void addSnake(int start, int end) {
        squares[start].setDestination(end);
        squares[start].setType(SquareType.SNAKE);
    }

    // Other methods as needed
}

// Class to represent a player
class Player {
    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0; // Start position
    }

    // Method to move player
    public void move(int steps) {
        position += steps;
    }

    // Other methods as needed
}

// Class to represent the Snakes and Ladders game
class Game {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;

    public Game(int boardSize, int numPlayers) {
        board = new Board(boardSize);
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
        currentPlayerIndex = 0;
    }

    // Method to add ladder to the board
    public void addLadder(int start, int end) {
        board.addLadder(start, end);
    }

    // Method to add snake to the board
    public void addSnake(int start, int end) {
        board.addSnake(start, end);
    }

    // Method to move the current player
    public void moveCurrentPlayer(int steps) {
        Player currentPlayer = players[currentPlayerIndex];
        currentPlayer.move(steps);

        // Check if the player encountered a ladder or a snake
        Square currentSquare = board.getSquare(currentPlayer.getPosition());
        if (currentSquare.getType() == SquareType.LADDER || currentSquare.getType() == SquareType.SNAKE) {
            currentPlayer.setPosition(currentSquare.getDestination());
        }

        // Switch to the next player
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }

    // Other methods as needed
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create a game with a board of size 100 and 2 players
        Game game = new Game(100, 2);

        // Add ladders and snakes to the board
        game.addLadder(2, 15);
        game.addSnake(20, 5);

        // Play the game
        game.moveCurrentPlayer(6); // Move the current player by 6 steps
        // Continue playing...
    }
}
```

This design follows SOLID principles and OOP principles by encapsulating behavior within classes, using abstraction, and separating concerns. It provides flexibility to add features like adding ladders and snakes to the board, moving players, and playing the game.
