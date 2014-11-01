package com.javaTTT;

import java.util.HashMap;

public class UnbeatableAiPlayer extends Player {
    Board boardObject;
    String moveSignature;

    UnbeatableAiPlayer(Board boardObject, String moveSignature) {
        this.boardObject = boardObject;
        this.moveSignature = moveSignature;
    }

    @Override
    int getMove(HashMap<Integer, String> board, String otherPlayerMove, String thisPlayerMove) {

        HashMap<Integer, String> originalBoard = new HashMap<Integer, String>(board);
        int[] availableSpaces = availableSpaces(originalBoard);
        double bestScore = -999.0;
        double thisScore;
        int bestMove = -1;

        if(originalBoard.size() == availableSpaces.length) {
            return 0;
        }

        if(isThisAiPlayer(thisPlayerMove)) {
            for(int availableSpace : availableSpaces) {
                originalBoard.put(availableSpace, thisPlayerMove);
                thisScore = minimax(originalBoard, thisPlayerMove, otherPlayerMove, -999, 999, 1);
                if (thisScore > bestScore) {
                    bestScore = thisScore;
                    bestMove = availableSpace;
                }
                originalBoard.put(availableSpace, " ");
            }

            return bestMove;
        } else {
            for(int availableSpace : availableSpaces) {
                originalBoard.put(availableSpace, otherPlayerMove);
                thisScore = minimax(originalBoard, otherPlayerMove, thisPlayerMove, -999.0, 999.0, 1);
                if (thisScore > bestScore) {
                    bestScore = thisScore;
                    bestMove = availableSpace;
                }
                originalBoard.put(availableSpace, " ");
            }

            return bestMove;
        }

    }


    @Override
    String getMoveSignature() {
        return moveSignature;
    }

    double minimax(HashMap<Integer, String> board, String otherPlayerMove, String thisPlayerMove, double alpha, double beta, double depth) {

        HashMap<Integer, String> originalBoard = new HashMap<Integer, String>(board);
        double thisScore;

        if (boardObject.gameOver(originalBoard, otherPlayerMove, thisPlayerMove)) {

            if(isThisAiPlayer(thisPlayerMove)) {
                return scoreBoard(originalBoard, otherPlayerMove, thisPlayerMove) / depth;
            } else {
                return scoreBoard(originalBoard, thisPlayerMove, otherPlayerMove) / depth;
            }

        } else {

            int[] availableSpaces = availableSpaces(originalBoard);

            if (isThisAiPlayer(thisPlayerMove)) {

                for (int availableSpace : availableSpaces) {

                    originalBoard.put(availableSpace, thisPlayerMove);
                    thisScore = minimax(originalBoard, thisPlayerMove, otherPlayerMove, alpha, beta, depth + 1);
                    if(thisScore > alpha) {
                        alpha = thisScore;
                    }
                    originalBoard.put(availableSpace, " ");
                    if(beta <= alpha) {
                        break;
                    }

                }

                return alpha;

            } else {

                for (int availableSpace : availableSpaces) {

                    originalBoard.put(availableSpace, thisPlayerMove);
                    thisScore = minimax(originalBoard, thisPlayerMove, otherPlayerMove, alpha, beta, depth + 1);
                    if(thisScore < beta) {
                        beta = thisScore;
                    }
                    originalBoard.put(availableSpace, " ");
                    if(beta <= alpha) {
                        break;
                    }
                }

                return beta;
            }
        }
    }

    double scoreBoard(HashMap<Integer, String > board, String otherPlayerMove, String thisPlayerMove) {
        if(boardObject.playerWins(board, thisPlayerMove)) {
            return 10.0;
        } else if(boardObject.playerWins(board, otherPlayerMove)) {
            return -10.0;
        } else {
            return 0.0;
        }
    }

    boolean isThisAiPlayer(String move) {
        return move.equals(moveSignature);
    }

    int[] availableSpaces(HashMap<Integer, String> board) {
        int emptySpacesCounter = 0;
        for(int i=0; i<board.size(); i++) {
            if(boardObject.spaceAvailable(board, i)) {
                emptySpacesCounter += 1;
            }
        }
        int[] emptySpaces = new int[emptySpacesCounter];
        int indexForEmptySpaces = 0;
        for(int i=0; i<board.size(); i++) {
            if(boardObject.spaceAvailable(board, i)) {
                emptySpaces[indexForEmptySpaces++] = i;
            }
        }
        return emptySpaces;
    }

}
