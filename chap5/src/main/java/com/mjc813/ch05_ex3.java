package com.mjc813;

public class ch05_ex3 {
    public void FI_EX3() {
        char[][] chInput = {
                {'*', '*', '*', '*', ' '},
                {'*', '*', ' ', ' ', ' '},
                {'*', ' ', '*', '*', '*'}
        };
        char[][] chOutput = new char[chInput[0].length][chInput.length];
        for ( int row = 0; row < chInput.length; row++ ) {
            // 1차원 배열 반복
            for ( int col = 0; col < chInput[row].length; col++ ) {
                chOutput[col][row] = chInput[row][col];
            }
        }
    }
}

