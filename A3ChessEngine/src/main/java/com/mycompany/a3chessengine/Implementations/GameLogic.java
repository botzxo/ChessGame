/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a3chessengine.Implementations;

import com.mycompany.a3chessengine.Interfaces.ChessController;
import com.mycompany.a3chessengine.Move;
import com.mycompany.a3chessengine.Pieces.Piece;
import com.mycompany.a3chessengine.Board;
/**
 *
 * @author shahe
 */
public class GameLogic implements ChessController {
    
    private TextGameDisplay display;
    private Board board;
    
    public GameLogic(){
        board = new Board();
        display = new TextGameDisplay(board);
    }

    @Override
    public boolean movePiece(Move move) {
        if(board.executeMove(move)){
            return true;
        }else{
           return false; 
        }
    }
    @Override
    public void reset() {
        board = new Board();
    }

    @Override
    public void playGame() {
       
    }

}
