/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a3chessengine.Pieces;

import com.mycompany.a3chessengine.Alliance;
import com.mycompany.a3chessengine.Board;
import com.mycompany.a3chessengine.Move;
import com.mycompany.a3chessengine.Move.normalMove;
import com.mycompany.a3chessengine.Move.attackMove;
import com.mycompany.a3chessengine.Tile;
import com.mycompany.a3chessengine.MyList;

/**
 *
 * @author shahe
 */
public class Pawn extends Piece {
    
    private static int[] moveCoordinatesX = {0, 1, -1};
    private static int[] moveCoordinatesY = {1, 1, 1};
    
    public Pawn(int piecePosX, int piecePosY, Alliance pieceAlliance) {
        super(piecePosX, piecePosY, pieceAlliance);
    }

    @Override
    public MyList<Move> calculateLegalMoves(Board board) {
        int pieceDestinationX, pieceDestinationY;
        MyList<Move> movesList = new MyList<>();
        
        for(int i=0; i<1; i++){
            pieceDestinationX = this.piecePostionX + (this.getAlliace().getDirection()*moveCoordinatesX[i]);
            pieceDestinationY = this.piecePostionY + (this.getAlliace().getDirection()*moveCoordinatesY[i]);
            
            if(super.isValidPieceCoordinate(pieceDestinationX, pieceDestinationY)){
                continue;
            }
            Tile destinationTile = board.getTile(pieceDestinationX, pieceDestinationY);
            if(moveCoordinatesX[i]==0 && !destinationTile.isOccupied()){
                movesList.add(new normalMove(this, board, pieceDestinationX, pieceDestinationY));;
            }
            else if(moveCoordinatesX[i]==1 && !((this.piecePostionY == 0 && this.getAlliace()== Alliance.WHITE) || 
                    (this.piecePostionY == 7 && this.getAlliace() == Alliance.BLACK))){
                if(destinationTile.isOccupied()){
                    Piece pieceAtDestination = destinationTile.getPiece();
                    if(pieceAtDestination.getAlliace() != this.getAlliace()){
                        movesList.add(new attackMove(this, pieceAtDestination, board, pieceDestinationX, pieceDestinationY));
                    }
                }
            }else if(moveCoordinatesX[i]==-1 && !((this.piecePostionY == 7 && this.getAlliace()== Alliance.WHITE) || 
                    (this.piecePostionY == 0 && this.getAlliace() == Alliance.BLACK))){
                if(destinationTile.isOccupied()){
                    Piece pieceAtDestination = destinationTile.getPiece();
                    if(pieceAtDestination.getAlliace() != this.getAlliace()){
                        movesList.add(new attackMove(this, pieceAtDestination, board, pieceDestinationX, pieceDestinationY));
                    }
                }
            } 
        }           
        return movesList;
    }

    @Override
    public String toString() {
        return "P";
    }
    
}
