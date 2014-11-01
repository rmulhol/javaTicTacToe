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
    int getMove(HashMap<Integer, String> board, String otherPlayerMove, String thisAiPlayerMove) {
        int boardSize = board.size();

        // try to win game
        for(int index=0; index<boardSize; index++) {
            if (canClaimWin(board, index, otherPlayerMove, thisAiPlayerMove)) {
                return winningMove(board, index, otherPlayerMove, thisAiPlayerMove);
            }
        }

        // try to block loss
        for(int index=0; index<boardSize; index++) {
            if(canBlockLoss(board, index, otherPlayerMove, thisAiPlayerMove)) {
                return blockLossMove(board, index, otherPlayerMove, thisAiPlayerMove);
            }
        }

        // try to claim middle
        if(middleSpaceAvailable(board)) return middleSpace;

        // try to create fork
        for(int index=0; index<boardSize; index++) {
            if(spaceAvailable(board, index)) {
                int counter = 0;
                board.put(index, thisAiPlayerMove);
                for(int subIndex = 0; subIndex<boardSize; subIndex++) {
                    if(spaceAvailable(board, subIndex)) {
                        board.put(subIndex, otherPlayerMove);
                        for (int superSubIndex = 0; superSubIndex < boardSize; superSubIndex++) {
                            if (canClaimWin(board, superSubIndex, otherPlayerMove, thisAiPlayerMove)) {
                                counter += 1;
                                if (counter == 2) {
                                    board.put(index, " ");
                                    board.put(subIndex, " ");
                                    return index;
                                }
                            }
                        }
                        counter = 0;
                        board.put(subIndex, " ");
                    }
                }
                board.put(index, " ");
            }
        }

        // try to block fork
        for(int index=0; index<boardSize; index++) {
            if(spaceAvailable(board, index)) {
                int counter = 0;
                board.put(index, thisAiPlayerMove);
                for(int subIndex = 0; subIndex<boardSize; subIndex++) {
                    if(spaceAvailable(board, subIndex)) {
                        board.put(subIndex, otherPlayerMove);
                        for (int superSubIndex = 0; superSubIndex < boardSize; superSubIndex++) {
                            if(canClaimWin(board, superSubIndex, thisAiPlayerMove, otherPlayerMove)) {
                                counter += 1;
                                if (counter == 2) {
                                    board.put(index, " ");
                                    board.put(subIndex, " ");
                                    return superSubIndex;
                                }
                            }
                        }
                        counter = 0;
                        board.put(subIndex, " ");
                    }
                }
                board.put(index, " ");
            }
        }

        // claim random space if all else fails
        return randomSpace(board);
    }

    @Override
    String getMoveSignature() {
        return moveSignature;
    }

    private boolean middleSpaceAvailable(HashMap<Integer, String> board) {
        return board.size() % 2 == 1 && spaceAvailable(board, middleSpace);
    }

    private boolean canClaimWin(HashMap<Integer, String > board, int index, String otherPlayerMove, String thisPlayerMove) {
        return winningMove(board, index, otherPlayerMove, thisPlayerMove) != -1;
    }

    private boolean canBlockLoss(HashMap<Integer, String> board, int index, String otherPlayerMove, String thisPlayerMove) {
        return blockLossMove(board, index, otherPlayerMove, thisPlayerMove) != -1;
    }

    private int winningMove(HashMap<Integer, String> board, int index, String otherPlayerMove, String thisPlayerMove) {
        if(spaceAvailable(board, index)) {
            board.put(index, thisPlayerMove);
            if(gameOver(board, otherPlayerMove, thisPlayerMove)) {
                board.put(index, " ");
                return index;
            } else {
                board.put(index, " ");
            }
        }
        return -1;
    }

    private int blockLossMove(HashMap<Integer, String> board, int index, String otherPlayerMove, String thisPlayerMove) {
        if(spaceAvailable(board, index)) {
            board.put(index, otherPlayerMove);
            if(gameOver(board, otherPlayerMove, thisPlayerMove)) {
                board.put(index, " ");
                return index;
            } else {
                board.put(index, " ");
            }
        }
        return -1;
    }

    private int randomSpace(HashMap<Integer, String> board) {
        int boardSize = board.size();
        Random rand = new Random();
        return rand.nextInt(boardSize-1);
    }

    private boolean spaceAvailable(HashMap<Integer, String> board, int index) { return boardObject.spaceAvailable(board, index); }

    private boolean gameOver(HashMap<Integer, String> board, String otherPlayerMove, String thisAiPlayerMove) {
        return boardObject.gameOver(board, otherPlayerMove, thisAiPlayerMove);
    }

}
