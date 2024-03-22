/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a3chessengine.Implementations;

import com.mycompany.a3chessengine.Interfaces.ChessController;
import com.mycompany.a3chessengine.Move;
import com.mycompany.a3chessengine.Pieces.Piece;

/**
 *
 * @author shahe
 */
public class GameLogic implements ChessController {
    
    private TextGameDisplay display;

    @Override
    public boolean movePiece(Move move) {
        return true;
    }
    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void playGame() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//    private GameDisplay currDisplay;
}
