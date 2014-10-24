package com.javaTTT;

import java.util.HashMap;
import java.util.Random;

public class SmartAiPlayer extends Player {
    Board boardObject;
    int boardSize;
    int middleSpace;
    String moveSignature;

    SmartAiPlayer(Board boardObject, String moveSignature) {
        this.boardObject = boardObject;
        boardSize = boardObject.boardSize;
        middleSpace = boardSize/2;
        this.moveSignature = moveSignature;
    }

    @Override
    int getMove(String otherPlayerMove, String thisAiPlayerMove) {
        for(int index=0; index<boardSize; index++) {
            if(canClaimWin(index, otherPlayerMove, thisAiPlayerMove)) {
                return winningMove(index, otherPlayerMove, thisAiPlayerMove);
            } else if(canBlockLoss(index, otherPlayerMove, thisAiPlayerMove)) {
                return blockLoss(index, otherPlayerMove, thisAiPlayerMove);
            }
        }
        if(middleSpaceAvailable()) return middleSpace;
        else return randomSpace();
    }

    @Override
    String getMoveSignature() {
        return moveSignature;
    }

    private boolean middleSpaceAvailable() {
        return spaceAvailable(boardObject.board, middleSpace);
    }

    private boolean canClaimWin(int index, String otherPlayerMove, String thisAiPlayerMove) {
        return winningMove(index, otherPlayerMove, thisAiPlayerMove) != -1;
    }

    private boolean canBlockLoss(int index, String otherPlayerMove, String thisAiPlayerMove) {
        return blockLoss(index, otherPlayerMove, thisAiPlayerMove) != -1;
    }

    private int winningMove(int index, String otherPlayerMove, String thisAiPlayerMove) {
        HashMap testBoard = cloneBoard(boardObject.board);
        if(spaceAvailable(testBoard, index)) {
            setMove(testBoard, index, thisAiPlayerMove);
            if(gameOver(testBoard, otherPlayerMove, thisAiPlayerMove)) {
                return index;
            }
        }
        return -1;
    }

    private int blockLoss(int index, String otherPlayerMove, String thisAiPlayerMove) {
        HashMap testBoard = cloneBoard(boardObject.board);
        if(spaceAvailable(testBoard, index)) {
            setMove(testBoard, index, otherPlayerMove);
            if(gameOver(testBoard, otherPlayerMove, thisAiPlayerMove)) {
                return index;
            }
        }
        return -1;
    }

    private int randomSpace() {
        Random rand = new Random();
        return rand.nextInt(boardSize-1);
    }

    private HashMap cloneBoard(HashMap board) { return new HashMap<Object, Object>(board); }

    private boolean spaceAvailable(HashMap board, int index) { return boardObject.spaceAvailable(board, index); }

    private boolean gameOver(HashMap board, String otherPlayerMove, String thisAiPlayerMove) {
        return boardObject.gameOver(board, otherPlayerMove, thisAiPlayerMove);
    }

    private void setMove(HashMap board, int index, String playerMove) { boardObject.setMove(board, index, playerMove); }

}
