package com.javaTTT;

import java.util.HashMap;
import java.util.Random;

public class SmartAiPlayer extends Player {
    Board board;
    int boardLength;

    SmartAiPlayer(Board board) {
        this.board = board;
        boardLength = board.boardLength;
    }

    // assumes ai is player2
    @Override
    int getMove(String player1Move, String player2Move) {
        for(int i=0; i<boardLength; i++) {
            if(board.spaceAvailable(i)) {
                board.setMove(i, player2Move);
                if(board.gameOver(player1Move, player2Move)) {
                    board.setMove(i, " ");
                    return i;
                } else {
                    board.setMove(i, " ");
                }
            }
            if(board.spaceAvailable(i)) {
                board.setMove(i, player1Move);
                if(board.gameOver(player1Move, player2Move)) {
                    board.setMove(i, " ");
                    return i;
                } else {
                    board.setMove(i, " ");
                }
            }
        }
        if(board.spaceAvailable(boardLength/2)) {
            return boardLength/2;
        }
        Random rand = new Random();
        return rand.nextInt(boardLength-1);
    }

}
