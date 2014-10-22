package com.javaTTT;

import java.util.HashMap;
import java.util.Random;

public class SmartAiPlayer extends Player {
    Board boardObject;
    int boardLength;
    int middleSpace;

    SmartAiPlayer(Board boardObject) {
        this.boardObject = boardObject;
        boardLength = boardObject.boardLength;
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
        return spaceAvailable(boardObject.board, middleSpace);
    }

    private boolean canClaimWin(int index, String player1Move, String player2Move) {
        return winningMove(index, player1Move, player2Move) != -1;
    }

    private boolean canBlockLoss(int index, String player1Move, String player2Move) {
        return blockLoss(index, player1Move, player2Move) != -1;
    }

    private int winningMove(int index, String player1Move, String player2Move) {
        HashMap testBoard = cloneBoard(boardObject.board);
        if(spaceAvailable(testBoard, index)) {
            setMove(testBoard, index, player2Move);
            if(gameOver(testBoard, player1Move, player2Move)) {
                return index;
            }
        }
        return -1;
    }

    private int blockLoss(int index, String player1Move, String player2Move) {
        HashMap testBoard = cloneBoard(boardObject.board);
        if(spaceAvailable(testBoard, index)) {
            setMove(testBoard, index, player1Move);
            if(gameOver(testBoard, player1Move, player2Move)) {
                return index;
            }
        }
        return -1;
    }

    private int randomSpace() {
        Random rand = new Random();
        return rand.nextInt(boardLength-1);
    }

    private HashMap cloneBoard(HashMap board) {
        return new HashMap<Object, Object>(board);
    }

    private boolean spaceAvailable(HashMap board, int index) {
        return boardObject.spaceAvailable(board, index);
    }

    private boolean gameOver(HashMap board, String player1Move, String player2Move) {
        return boardObject.gameOver(board, player1Move, player2Move);
    }

    private void setMove(HashMap board, int index, String playerMove) {
        boardObject.setMove(board, index, playerMove);
    }

}
