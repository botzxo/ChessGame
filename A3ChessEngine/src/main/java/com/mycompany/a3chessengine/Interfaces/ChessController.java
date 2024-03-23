/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.a3chessengine.Interfaces;

import com.mycompany.a3chessengine.Move;
import com.mycompany.a3chessengine.Pieces.Piece;

/**
 *
 * @author shahe
 */
public interface ChessController {
    public boolean movePiece(Move moves);
    public void reset();
    public void playGame();
}
