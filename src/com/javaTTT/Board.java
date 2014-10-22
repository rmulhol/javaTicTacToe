package com.javaTTT;

import java.util.HashMap;

abstract class Board {
    int boardSideLength;
    int boardLength;
    HashMap board;
    abstract int calculateBoardLengthFromSideLength(int boardSize);
    abstract int calculateBoardSizeFromBoard(HashMap board);
    abstract int calculateBoardSideLengthFromBoard(HashMap board);
    abstract HashMap createEmptyBoard(int boardLength);
    abstract HashMap getBoard();
    abstract void setMove(HashMap board, int move, String player);
    abstract int[][] rows(int boardSize);
    abstract int[][] columns(int boardSize);
    abstract int[][] leftToRightDiagonal(int boardSize);
    abstract int[][] rightToLeftDiagonal(int boardSize);
    abstract int[][] winningCombinations(int boardSize);
    abstract boolean spaceAvailable(HashMap board, int move);
    abstract boolean playerWins(HashMap board, String playerMove);
    abstract boolean tieGame(HashMap board);
    abstract boolean gameOver(HashMap board, String player1Move, String player2Move);
}
