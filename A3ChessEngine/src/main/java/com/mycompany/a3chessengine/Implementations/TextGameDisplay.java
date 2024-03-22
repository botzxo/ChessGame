/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a3chessengine.Implementations;

import com.mycompany.a3chessengine.Alliance;
import com.mycompany.a3chessengine.Board;
import com.mycompany.a3chessengine.Interfaces.GameDisplay;
import com.mycompany.a3chessengine.Move;
import com.mycompany.a3chessengine.Move.attackMove;
import com.mycompany.a3chessengine.Move.normalMove;
import com.mycompany.a3chessengine.Pieces.Piece;
import java.util.Scanner;
/**
 *
 * @author shahe
 */


public class TextGameDisplay implements GameDisplay {
    
    final static int maxDifficulty  = 3;
    private Board currBoard;
    
    public TextGameDisplay(Board board){
        this.currBoard = board;
    }

    @Override
    public int promptForOpponentDifficulty(int maxDifficulty) {
        if(maxDifficulty>2){
            return this.maxDifficulty;
        }else{
            return 1;
        }
    }

    @Override //Have to make the method return bool and work on it to call moveExecute
    public Move promptForMove() {
        Scanner scanner = new Scanner(System.in);
        Move newMove;
        
        System.out.println("Please enter the row of the piece you would like to move.  Enter 0 to forfeit game. ");
        int pieceCoordX = scanner.nextInt();
        if(pieceCoordX == 0){
            gameOver(-1);
        }
        
        System.out.println("Please enter the column of the piece you would like to move.");
        int pieceCoordY = scanner.nextInt();
        
        if(!(currBoard.getTile(pieceCoordX, pieceCoordY).isOccupied())){
            System.out.println("Your chosen piece is incorrect");
            return null;
        }
        
        System.out.println("Please enter the row of the destination.");
        int destinationX = scanner.nextInt();
        
        System.out.println("Please enter the column of the destination.");
        int destinationY = scanner.nextInt();
    
        if(currBoard.getTile(destinationX, destinationY).isOccupied()){
            Piece attackedPiece = currBoard.getTile(destinationX, destinationY).getPiece();
            Piece movedPiece = currBoard.getTile(pieceCoordX, pieceCoordY).getPiece();
            
            newMove = new attackMove(movedPiece, attackedPiece, currBoard, destinationX, destinationY);
        }
        else{
            Piece movedPiece = currBoard.getTile(pieceCoordX, pieceCoordY).getPiece();
            newMove = new normalMove(movedPiece, currBoard, destinationX, destinationY);
        }
        
        return newMove;
    }

    @Override //work on this and fix it
    public void displayBoard(Board board) {
        System.out.println(board.toString());
    }

    @Override
    public void summarizeMove(Move lastMove) {
        Piece piece = lastMove.getPiece();
        int coordX = piece.getPiecePosX();
        int coordY = piece.getPiecePosY();
        
        if(lastMove.isAttack()){
            attackMove attackMove = (attackMove)lastMove;
            Piece attackPiece = attackMove.getAttackedPiece();
            System.out.println(piece.toString() + " moved from ("+ coordX + coordY +") to (" + lastMove.getDestinationX() + lastMove.getDestinationY()
            + ") Captured " + attackPiece.toString());
        }else{
            System.out.println(piece.toString() + " moved from ("+ coordX + coordY +") to (" + lastMove.getDestinationX() + lastMove.getDestinationY()
            + ") Captured no pieces");
        }
    }

    @Override
    public void gameOver(int winner) {
        switch (winner) {
            case -1 -> System.out.println("Player forfieted, AI won!");
            case 0 -> System.out.println("The winner is AI!");
            case 1 -> System.out.println("The winner is player!");
            default -> {
            }
        }
    }

    @Override
    public boolean promptPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play again. Enter Yes or No: ");
        String output = scanner.nextLine();
        
        return output.equals("Yes");
    }
    
}
