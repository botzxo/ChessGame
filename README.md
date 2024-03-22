# ChessGame

The whole Chess System has 4 packages: 
- Piece package has controls functions and attributes for each piece 
- Engine package controls basic chess game attributes like board/tile/team etc.
- Interface package for assignment interfaces
- Implementation package for implementing those interfaces

Interfaces
--------------------------------------------------------------
ChessController Interface - defines methods for managing the game logic.

GameDisplay Interface - defines methods for interacting with the game display and obtaining user input.

ChessPlayer Interface - defines methods for the AI Players.


Classes
----------------------------------------------------------------
Alliance - Defines the team of each chess player (black/white) and their attributes

Tile - Defines attributes of a singular tile in a board (occupied/piece/postion)

Piece - An abstract class which has many subclasses of every type of piece defining their functionality and legal moves.

Move - An abstract class with two subclasses for a normal and attack move, defining their properties/attributes

Board - Defines a standard board and all main changes and backend modifications of the game happens in this board class (Incomplete)

MyList - A custom list class according to the OOP assignment 

IMPLEMENTATION CLASSES:
GameLogic - Handles game logic, implements the chessController interface and manages interactions between players and the board. (incomplete)

AI 1 (Easy)- Basic AI player for a chess game. (have to make)

AI 2 (Hard)- Sophiscated AI Player for a chess game.  (have to make)

TextGameDisplay - Implements the gameDisplay interface and handles text-based input/output.  

Main - Starting and ending the game. (have to make)




