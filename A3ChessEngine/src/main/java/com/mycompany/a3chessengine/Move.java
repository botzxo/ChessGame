/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a3chessengine;

import com.mycompany.a3chessengine.Pieces.Piece;

/**
 *
 * @author shahe
 */
public abstract class Move {
    private Piece movedPiece;
    private Board  board;
    private int destinationCoordX;
    private int destinationCoordY;
    private static boolean isAttack;
    
    private Move(Piece movedPiece, Board board, int nextCoordX, int nextCoordY){
        this.movedPiece = movedPiece;
        this.board = board;
        this.destinationCoordX = nextCoordX;
        this.destinationCoordY = nextCoordY;
    }
    
    
    public static  class normalMove extends Move{
        public normalMove(Piece movedPiece, Board board, int nextCoordX, int nextCoordY){
            super(movedPiece, board, nextCoordX, nextCoordY);
            isAttack = false;
        }
    }
    
    public static  class attackMove extends Move{
        Piece attackedPiece;
        
        public attackMove(Piece movedPiece, Piece attackedPiece, Board board, int nextCoordX, int nextCoordY){
            super(movedPiece, board, nextCoordX, nextCoordY);
            this.attackedPiece = attackedPiece;
            isAttack = true;
        }
        
       public Piece getAttackedPiece(){
           return attackedPiece;
       }
    }
    
    public Piece getPiece(){
        return movedPiece;
    }
    
    public boolean isAttack(){
        return isAttack;
    }
    
    public int getDestinationX(){
        return destinationCoordX;
    }
    
    public int getDestinationY(){
        return destinationCoordY;
    } 
     @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Move)) {
            return false;
        }
        final Move otherMove = (Move) other;
        return getPiece().getPiecePosX() == otherMove.getPiece().getPiecePosX() &&
               getPiece().getPiecePosY() == otherMove.getPiece().getPiecePosY() &&
               getDestinationX() == otherMove.getDestinationX() &&
               getDestinationY() == otherMove.getDestinationY() &&
               getPiece().equals(otherMove.getPiece());
    }
}

