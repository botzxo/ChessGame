/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.a3chessengine;

/**
 *
 * @author shahe
 */
public enum Alliance {
    WHITE{
        @Override
        public int getDirection() {
            return -1;
        }
    },
    BLACK{
        @Override
        public int getDirection() {
            return 1;
        }
        
    };
    
    public abstract int getDirection();
}
