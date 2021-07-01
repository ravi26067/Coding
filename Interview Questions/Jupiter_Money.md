# Round 1

Coding text with 1 question out of 2 was expected.

# 2nd Round

Objective : Come up with the LLD and code out certain parts of it (if time permits)

# Problem Statement : Design an online chess game**


## Requirements
--------------------
User should make a move after start
Predefined termination strategies ( when they start game)
Any number of users
More than two colors
N x N


## Use Cases
---------------

### Actors
----------
Player 
System

### Usecases
------------

Player
Make a move

System
Add players
Remove
Update chess size

## Classes
------------

``` java

Player{
String name;
String color;
String Id;
String email
AccountStatus status;

}


Class Board{
	Box [][] boxes;
}


Class Box{
Piece piece;
Int x;
Int y;
}

Class abstract Piece{
String color;
Iskilled = false;

Abstract Move canMove(Board borad , Box start, Box end) ;
Abstract List<Box> possibleMoves(Board borad , Box start, Box end);
}

Class King extend Piece{
	Move canMove(Board borad , Box start, Box end) {
}
}

Class MoveDetails{
	Message;
	Box 
}

Class Move{
Player player;
Box start;
Box end;
Piece pieceMoved;
Piece pieceKilled;
}

ChessGame{
List<Player> players;
Board board;
Player currentPlayer;
List<Move> moves;
GameStatus status;
List<Rules> rules;

Void initializeBoard(){
}

Boolean playMove(Player player,int  startx,starty, endx,endy){

}


addPlayers(Player player){
}


Rules{
Piece pieceMoved;
Piece killed;
}

Enum GameStatus{
NOT_STARTED,
STARTED,
IN_PROGRESS,
ENDED
}

```

