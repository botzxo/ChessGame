/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a3chessengine.AI;

import com.mycompany.a3chessengine.Alliance;
import com.mycompany.a3chessengine.Board;
import com.mycompany.a3chessengine.Interfaces.ChessPlayer;
import com.mycompany.a3chessengine.Move;
import com.mycompany.a3chessengine.Move.attackMove;
import com.mycompany.a3chessengine.Move.normalMove;
import com.mycompany.a3chessengine.Pieces.Piece;

import java.util.Random;

public class EasyAI implements ChessPlayer{
    private final Random random;

    public EasyAI() {
        random = new Random();
    }
    
    @Override
    public Move makeMove(Board board) {
        // Generate a random move
        // Moves a random piece to a random empty square
        int fromRow, fromCol, toRow, toCol;
        do {
            fromRow = random.nextInt(8);
            fromCol = random.nextInt(8);
            toRow = random.nextInt(8);
            toCol = random.nextInt(8);
        } while (!isValidMove(board, fromRow, fromCol, toRow, toCol));
        
        Move newMove;
        if(board.getTile(toRow, toRow).isOccupied()){
            newMove = new attackMove(board.getTile(fromRow, fromCol).getPiece(), board.getTile(toRow, toCol).getPiece(),
            board, toRow, toCol);
        }else{
            newMove = new normalMove(board.getTile(fromRow, fromCol).getPiece(), board, toRow, toCol);
        }
        if(board.isValidMove(newMove) && board.getTile(fromRow, fromRow).getPiece().getAlliance() == Alliance.WHITE){
            return newMove;
        }
        return null;
        
    }

    private boolean isValidMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        // Get the piece at the starting position
        Piece piece = board.getTile(fromRow, fromCol).getPiece();

        // Check if the piece exists and if it's the player's piece
        if (piece == null || piece.getAlliance() != Alliance.BLACK) {
            return false;
        }

        // Check if the destination is within the board bounds
        if (!piece.isValidPieceCoordinate(toRow, toCol)) {
            return false;
        }

        // Check if the destination tile is occupied by the player's piece
        Piece destinationPiece = board.getTile(toRow, toCol).getPiece();
        if (destinationPiece != null && destinationPiece.getAlliance() == piece.getAlliance()) {
            return false;
        }

        // If all conditions are met, the move is considered valid
        return true;
    }

    
   
    
}

