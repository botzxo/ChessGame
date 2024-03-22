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
public class Tile {
    private boolean isOccupied;
    private int coordX;
    private int coordY;
    private Piece piece;
    
    //For an Occupied tile
    public Tile(boolean isOccupied, int coordX, int coordY, Piece piece){  
        this.isOccupied = isOccupied;
        this.coordX = coordX;
        this.coordY = coordY;
        this.piece = piece;
    }
    
    //For an Empty Tile
    public Tile(boolean isOccupied, int coordX, int coordY){
        this.isOccupied = isOccupied;
        this.coordX = coordX;
        this.coordY = coordY;
    }
    
    public boolean isOccupied(){
        return isOccupied;
    }
    
    public int getCoordX(){
        return coordX;
    }
    
    public int getCoordY(){
        return coordY;
    }
    
    public Piece getPiece(){
        return piece;
    }
    
    public void setOccupied(boolean occupied){
        this.isOccupied = occupied;
    }
    
    public void setPiece(Piece newPiece){
        this.piece = newPiece;
    }
    
    public String toString(){
        String value;
        if(!isOccupied){
            value = "-";
        }else{
            value = this.getPiece().toString();
        }
        return value;
    }
}
