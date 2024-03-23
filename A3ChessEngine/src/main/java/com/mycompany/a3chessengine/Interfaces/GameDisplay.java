/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.a3chessengine.Interfaces;

import com.mycompany.a3chessengine.Board;
import com.mycompany.a3chessengine.Move;

/**
 *
 * @author shahe
 */
public interface GameDisplay {
    public int promptForOpponentDifficulty(int maxDifficulty);
    public Move promptForMove();
    public void displayBoard(Board board);
    public void summarizeMove(Move lastMove);
    public void gameOver(int winner);
    public boolean promptPlayAgain();
    
}


