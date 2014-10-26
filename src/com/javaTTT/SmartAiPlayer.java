package com.javaTTT;

import java.util.HashMap;
import java.util.Random;

public class SmartAiPlayer extends Player {
    Board boardObject;
    int middleSpace;
    String moveSignature;

    SmartAiPlayer(Board boardObject, String moveSignature) {
        this.boardObject = boardObject;
        this.moveSignature = moveSignature;
        middleSpace = boardObject.board.size() / 2;
    }

    @Override
    int getMove(HashMap board, String otherPlayerMove, String thisAiPlayerMove) {
        int boardSize = board.size();
        for(int index=0; index<boardSize; index++) {
            if (canClaimWin(board, index, otherPlayerMove, thisAiPlayerMove)) {
                return winningMove(board, index, otherPlayerMove, thisAiPlayerMove);
            }
        }
        for(int index=0; index<boardSize; index++) {
            if(canBlockLoss(board, index, otherPlayerMove, thisAiPlayerMove)) {
                return blockLossMove(board, index, otherPlayerMove, thisAiPlayerMove);
            }
        }
        if(middleSpaceAvailable(board)) return middleSpace;
        else return randomSpace(board);
    }

    @Override
    String getMoveSignature() {
        return moveSignature;
    }

    private boolean middleSpaceAvailable(HashMap board) {
        return spaceAvailable(board, middleSpace);
    }

    private boolean canClaimWin(HashMap board, int index, String otherPlayerMove, String thisAiPlayerMove) {
        return winningMove(board, index, otherPlayerMove, thisAiPlayerMove) != -1;
    }

    private boolean canBlockLoss(HashMap board, int index, String otherPlayerMove, String thisAiPlayerMove) {
        return blockLossMove(board, index, otherPlayerMove, thisAiPlayerMove) != -1;
    }

    private int winningMove(HashMap board, int index, String otherPlayerMove, String thisAiPlayerMove) {
        if(spaceAvailable(board, index)) {
            board.put(index, thisAiPlayerMove);
            if(gameOver(board, otherPlayerMove, thisAiPlayerMove)) {
                board.put(index, " ");
                return index;
            } else {
                board.put(index, " ");
            }
        }
        return -1;
    }

    private int blockLossMove(HashMap board, int index, String otherPlayerMove, String thisAiPlayerMove) {
        if(spaceAvailable(board, index)) {
            board.put(index, otherPlayerMove);
            if(gameOver(board, otherPlayerMove, thisAiPlayerMove)) {
                board.put(index, " ");
                return index;
            } else {
                board.put(index, " ");
            }
        }
        return -1;
    }

    private int randomSpace(HashMap board) {
        int boardSize = board.size();
        Random rand = new Random();
        return rand.nextInt(boardSize-1);
    }

    private boolean spaceAvailable(HashMap board, int index) { return boardObject.spaceAvailable(board, index); }

    private boolean gameOver(HashMap board, String otherPlayerMove, String thisAiPlayerMove) {
        return boardObject.gameOver(board, otherPlayerMove, thisAiPlayerMove);
    }

}
