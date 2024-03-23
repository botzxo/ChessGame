/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a3chessengine.Pieces;

import com.mycompany.a3chessengine.Alliance;
import com.mycompany.a3chessengine.Board;
import com.mycompany.a3chessengine.MyList;
import com.mycompany.a3chessengine.Move;
/**
 *
 * @author shahe
 */
public abstract class Piece {
    protected int piecePostionX, piecePostionY;
    protected Alliance pieceAlliance; 
    
    public Piece(int piecePosX, int piecePosY, Alliance pieceAlliance){
        this.piecePostionX = piecePosX;
        this.piecePostionY = piecePosY;
        this.pieceAlliance = pieceAlliance;
        
    }
    
    public Alliance getAlliance(){
        return pieceAlliance; 
    }
    
    public int getPiecePosX(){
        return this.piecePostionX;
    }
    
    public int getPiecePosY(){
        return this.piecePostionY;
    }
    
    public void setPiecePosX(int posX){
        this.piecePostionX = posX;
    }
    
    public void setPiecePosY(int posY){
        this.piecePostionY = posY;
    }
    
    
    public boolean isValidPieceCoordinate(int coordX, int coordY){
        return coordX>=0 && coordX<8 && coordY>=0 && coordY<8;
    }
    
    public abstract MyList<Move> calculateLegalMoves(Board board);
    
    public abstract String toString();
    
    @Override
    public boolean equals(Object obj) {
        // Self check
        if (this == obj) return true;
    
        // Null check and type check
        if (obj == null || getClass() != obj.getClass()) return false;
    
        // Cast to Piece
        Piece otherPiece = (Piece) obj;
    
        // Field comparison
        return piecePostionX == otherPiece.piecePostionX &&
            piecePostionY == otherPiece.piecePostionY &&
            pieceAlliance == otherPiece.pieceAlliance;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + piecePostionX;
        result = 31 * result + piecePostionY;
        result = 31 * result + (pieceAlliance != null ? pieceAlliance.hashCode() : 0);
        return result;
    }
}
