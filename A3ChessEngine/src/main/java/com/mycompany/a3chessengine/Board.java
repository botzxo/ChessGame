/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a3chessengine;

import com.mycompany.a3chessengine.Move.attackMove;
import com.mycompany.a3chessengine.Pieces.Bishop;
import com.mycompany.a3chessengine.Pieces.King;
import com.mycompany.a3chessengine.Pieces.Knight;
import com.mycompany.a3chessengine.Pieces.Pawn;
import com.mycompany.a3chessengine.Pieces.Piece;
import com.mycompany.a3chessengine.Pieces.Queen;
import com.mycompany.a3chessengine.Pieces.Rook;

/**
 *
 * @author shahe
 */
public class Board {
    private Alliance nextMoveMaker;
    private Tile[][] gameBoard;
    private MyList<Piece> whitePieces;
    private MyList<Piece> blackPieces;
    MyList<Move> blackLegalMoves;
    MyList<Move> whiteLegalMoves;
    
    
    public Board(){
        gameBoard = new Tile[8][8];
        createBoard();
        this.blackPieces = calculateActivePieces(this.gameBoard, Alliance.BLACK);
        this.whitePieces = calculateActivePieces(this.gameBoard, Alliance.WHITE);
        this.blackLegalMoves = calculateLegalMoves(this.blackPieces);
        this.whiteLegalMoves = calculateLegalMoves(this.whitePieces);
    }
    
    public Tile getTile(int coordX, int coordY){
        return gameBoard[coordX][coordY];
    }

    private void createBoard() {
        //Pawn creation
        for(int i=0; i<8; i++){
            gameBoard[1][i] = new Tile(true, 1, i, new Pawn(1, i, Alliance.BLACK));
            gameBoard[6][i] = new Tile(true, 6, i, new Pawn(1, i , Alliance.WHITE));
        }
        
        //Rook creation
        gameBoard[0][0] = new Tile(true, 0, 0, new Rook(0, 0, Alliance.BLACK));
        gameBoard[0][7] = new Tile(true, 0, 7, new Rook(0, 7, Alliance.BLACK));
        gameBoard[7][0] = new Tile(true, 7, 0, new Rook(7, 0, Alliance.WHITE));
        gameBoard[7][7] = new Tile(true, 7, 7, new Rook(7, 7, Alliance.WHITE));
        
        //Knight creation
        gameBoard[0][1] = new Tile(true, 0, 1, new Knight(0, 1, Alliance.BLACK));
        gameBoard[0][6] = new Tile(true, 0, 6, new Knight(0, 6, Alliance.BLACK));
        gameBoard[7][1] = new Tile(true, 7, 1, new Knight(7, 1, Alliance.WHITE));
        gameBoard[7][6] = new Tile(true, 7, 6, new Knight(7, 6, Alliance.WHITE));
        
        //Bishop creation
        gameBoard[0][2] = new Tile(true, 0, 2, new Bishop(0, 2, Alliance.BLACK));
        gameBoard[0][5] = new Tile(true, 0, 5, new Bishop(0, 5, Alliance.BLACK));
        gameBoard[7][2] = new Tile(true, 7, 2, new Bishop(7, 2, Alliance.WHITE));
        gameBoard[7][5] = new Tile(true, 7, 5, new Bishop(7, 5, Alliance.WHITE));
        
        //King and Queen creation
        gameBoard[0][3] = new Tile(true, 0, 3, new King(0, 3, Alliance.BLACK));
        gameBoard[0][4] = new Tile(true, 0, 4, new Queen(0, 4, Alliance.BLACK));
        gameBoard[7][3] = new Tile(true, 7, 3, new King(7, 3, Alliance.WHITE));
        gameBoard[7][4] = new Tile(true, 7, 4, new Queen(7, 4, Alliance.WHITE));
        
        //Empty Tiles creation
        for(int i=2; i<6; i++){
            for(int j=0; j<8; j++){
                gameBoard[i][j] = new Tile(false, i, j);
            }
        }
    }
    
  

    private MyList<Piece> calculateActivePieces(Tile[][] gameBoard, Alliance alliance) {
        MyList<Piece> activePieces = new MyList<>();
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(gameBoard[i][j].isOccupied()){
                    Piece piece = gameBoard[i][j].getPiece();
                    if(piece.getAlliance() == alliance){
                        activePieces.add(piece);
                    }
                }
            }
        }
        return activePieces;
    }

    private MyList<Move> calculateLegalMoves(MyList<Piece> pieces) {
        MyList<Move> totalLegalMoves = new MyList<>();
        for (int i = 0; i < pieces.size(); i++) {
            Piece currPiece = pieces.get(i);
            totalLegalMoves.addAll(currPiece.calculateLegalMoves(this));
   
        }
        
        return totalLegalMoves;
    }
    
    public boolean isValidMove(Move move){
        Alliance alliance = move.getPiece().getAlliance();
        if(alliance == Alliance.WHITE){
            return whiteLegalMoves.contains(move);
        }else{
            return blackLegalMoves.contains(move);
        }
    }
    
    public void executeMove(Move move){
        if(move == null || !isValidMove(move)){
            throw new IllegalArgumentException("Invalid Move!");
        }
        
        Piece currPiece = move.getPiece();
        Tile currTile = gameBoard[currPiece.getPiecePosX()][currPiece.getPiecePosY()];
        Tile destinationTile = gameBoard[move.getDestinationX()][move.getDestinationY()];
      
        //Modifying the postion and occupancy of current piece
        currTile.setOccupied(false);
        currPiece.setPiecePosX(move.getDestinationX());
        currPiece.setPiecePosY(move.getDestinationY());
            
        //Modifying the destinationTile
        destinationTile.setPiece(currPiece);
        destinationTile.setOccupied(true);
            
        //Modifying the moved Tile
        currTile.setPiece(null);
        currTile.setOccupied(false);
        
         //Removing attacked piece from the pieces and legal move list
        if(move.isAttack()){
            attackMove attackedMove = (attackMove)move;
            Piece attackedPiece = attackedMove.getAttackedPiece();
            
            MyList<Move> attackedPieceLegalMoves = attackedPiece.calculateLegalMoves(this);
            for(int i=0; i<attackedPieceLegalMoves.size(); i++){
                Move currMove = attackedPieceLegalMoves.get(i);
                
                if(attackedPiece.getAlliance() == Alliance.WHITE){
                    whiteLegalMoves.remove(currMove);
                }else{
                    blackLegalMoves.remove(currMove);
                }
            }
            if(attackedPiece.getAlliance() == Alliance.WHITE){
                whitePieces.remove(attackedPiece);
            }else{
                blackPieces.remove(attackedPiece);
            }
        }
           
    }
    
    public String printTileDetail(Tile newTile){
        if(newTile.isOccupied()){
            if(newTile.getPiece().getAlliance() == Alliance.BLACK){
                return newTile.toString().toLowerCase();
            }
        }
        return  newTile.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                value.append(printTileDetail(gameBoard[i][j])).append(" | ");
            }
            value.append("\n");
        }
        return value.toString();
    }

    
}
