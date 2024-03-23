/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a3chessengine.Implementations;

import com.mycompany.a3chessengine.AI.EasyAI;
import com.mycompany.a3chessengine.Interfaces.ChessController;
import com.mycompany.a3chessengine.Move;
import com.mycompany.a3chessengine.Pieces.Piece;
import com.mycompany.a3chessengine.Board;

import java.util.Scanner;
/**
 *
 * @author shahe
 */
public class GameLogic implements ChessController {
    
    private TextGameDisplay display;
    private Board board;
    private EasyAI AI;
    
    public GameLogic(){
        board = new Board();
        display = new TextGameDisplay(board);
        AI = new EasyAI();
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
        playGame();
    }
    
    public int inputFunction(){
        //On -1 we make the user do the input moves again INVALID MOVE
        //On 0 we make the user have options to forfiet FORFIET
        //On 1 we repeat the input successfully VALID MOVE
        
        Move currentMove = display.promptForMove();

        Move AImove;
        if(currentMove != null){
            if(movePiece(currentMove)){
                display.summarizeMove(currentMove);
                display.displayBoard(board);
                
                AImove = AI.makeMove(board);
                if(AImove == null){
                    return -1;
                }
                display.summarizeMove(AImove);
                display.displayBoard(board);
            }else{
                return -1;
            }
        }else{
            return 0;
        }
        return 1;
    }

    @Override
    public void playGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the desired opponent difficulty, between 0 and 1, where 0 is easiest opponent and 1 is hardest opponent.");
        int difficulty = scanner.nextInt();
        
        while(difficulty > 1 || difficulty < 0){
            System.out.println("Please enter the desired opponent difficulty, between 0 and 1, where 0 is easiest opponent and 1 is hardest opponent.");
            difficulty = scanner.nextInt();
        }
        
       display.displayBoard(board);
       int inputCondition = inputFunction();
       while(inputCondition != 0){
            inputCondition = inputFunction();
           
            if(inputCondition == -1){
               System.out.println("Error! Please re enter move");
            }
       }
       
        if(inputCondition == 0){
           System.out.println("Game Finished! Would you like to play again? Enter 0 for yes and 1 for no");
           int restart = scanner.nextInt();
            if(restart == 0){
               reset();
            }
        }
    }
}
