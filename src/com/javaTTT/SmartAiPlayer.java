package com.javaTTT;

import java.util.Random;

public class SmartAiPlayer extends Player {
    Board board;
    int boardLength;
    int middleSpace;

    SmartAiPlayer(Board board) {
        this.board = board;
        boardLength = board.boardLength;
        middleSpace = boardLength/2;
    }

    // assumes ai is player2
    @Override
    int getMove(String player1Move, String player2Move) {
        for(int index=0; index<boardLength; index++) {
            if(canClaimWin(index, player1Move, player2Move)) {
                return winningMove(index, player1Move, player2Move);
            } else if(canBlockLoss(index, player1Move, player2Move)) {
                return blockLoss(index, player1Move, player2Move);
            }
        }
        if(middleSpaceAvailable()) return middleSpace;
        else return randomSpace();
    }

    private boolean middleSpaceAvailable() {
        return board.spaceAvailable(boardLength/2);
    }

    private boolean canClaimWin(int index, String player1Move, String player2Move) {
        return winningMove(index, player1Move, player2Move) != -1;
    }

    private boolean canBlockLoss(int index, String player1Move, String player2Move) {
        return blockLoss(index, player1Move, player2Move) != -1;
    }

    private int winningMove(int index, String player1Move, String player2Move) {
        if(board.spaceAvailable(index)) {
            board.setMove(board.board, index, player2Move);
            if(board.gameOver(board.board, player1Move, player2Move)) {
                board.setMove(board.board, index, " ");
                return index;
            } else {
                board.setMove(board.board, index, " ");
            }
        }
        return -1;
    }

    private int blockLoss(int index, String player1Move, String player2Move) {
        if(board.spaceAvailable(index)) {
            board.setMove(board.board, index, player1Move);
            if(board.gameOver(board.board, player1Move, player2Move)) {
                board.setMove(board.board, index, " ");
                return index;
            } else {
                board.setMove(board.board, index, " ");
            }
        }
        return -1;
    }

    private int randomSpace() {
        Random rand = new Random();
        return rand.nextInt(boardLength-1);
    }
}
