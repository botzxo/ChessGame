/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a3chessengine.Pieces;

import com.mycompany.a3chessengine.Alliance;
import com.mycompany.a3chessengine.Board;
import com.mycompany.a3chessengine.MyList;
import com.mycompany.a3chessengine.Move;
import com.mycompany.a3chessengine.Move.normalMove;
import com.mycompany.a3chessengine.Move.attackMove;
import com.mycompany.a3chessengine.Tile;



/**
 *
 * @author shahe
 */
public class Queen extends Piece{
    private static int[] moveCoordinatesX = {0, 0, 1, -1, 1, 1, -1, -1};
    private static int[] moveCoordinatesY = {1, -1, 0, 0, 1, -1, -1, 1};

    public Queen(int piecePosX, int piecePosY, Alliance pieceAlliance) {
        super(piecePosX, piecePosY, pieceAlliance);
    }

    @Override
    public MyList<Move> calculateLegalMoves(Board board) {
        int pieceDestinationX, pieceDestinationY;
        MyList<Move> movesList = new MyList<>();
        
        for(int i = 0; i<4; i++){
            pieceDestinationX = this.piecePostionX; 
            pieceDestinationY = this.piecePostionY; 
                    
            while(super.isValidPieceCoordinate(pieceDestinationX, pieceDestinationY)){
                
                pieceDestinationX += moveCoordinatesX[i];
                pieceDestinationY += moveCoordinatesY[i];
                
                if(super.isValidPieceCoordinate(pieceDestinationX, pieceDestinationY)){ //isValidCoordinate
                    Tile destinationTile = board.getTile(pieceDestinationX, pieceDestinationY);
                    
                    if(!destinationTile.isOccupied()){ //if piece is not occupied
                        movesList.add(new normalMove(this, board, pieceDestinationX, pieceDestinationY));
                    
                    }else{ //if there is an opponent piece on the occupied tile
                        Piece pieceAtDestination = destinationTile.getPiece();
                        Alliance pieceAtDestinationAlliance = pieceAtDestination.getAlliace();
                        
                        if(this.pieceAlliance != pieceAtDestinationAlliance){
                            movesList.add(new attackMove(this, pieceAtDestination, board, pieceDestinationX, pieceDestinationY));
                        }
                                
                    }
                }
            }
        }
        return  movesList;
    }

    @Override
    public String toString() {
        return "Q";
    }
    
    
}
