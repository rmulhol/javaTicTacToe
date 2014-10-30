package com.javaTTT;

import java.util.HashMap;

abstract class Board {
    int boardSideLength;
    int boardSize;
    HashMap board;
    abstract int calculateBoardSizeFromSideLength(int boardSize);
    abstract int calculateBoardSizeFromBoard(HashMap<Integer, String> board);
    abstract int calculateBoardSideLengthFromBoard(HashMap<Integer, String> board);
    abstract HashMap createEmptyBoard(int boardLength);
    abstract HashMap getBoard();
    abstract void setMove(HashMap<Integer, String> board, int move, String player);
    abstract int[][] rows(int boardSize);
    abstract int[][] columns(int boardSize);
    abstract int[][] leftToRightDiagonal(int boardSize);
    abstract int[][] rightToLeftDiagonal(int boardSize);
    abstract int[][] winningCombinations(int boardSize);
    abstract boolean moveIsValid(HashMap<Integer, String> board, int move);
    abstract boolean spaceAvailable(HashMap<Integer, String> board, int move);
    abstract boolean spaceInRange(HashMap<Integer, String> board, int move);
    abstract boolean playerWins(HashMap<Integer, String> board, String playerMove);
    abstract boolean tieGame(HashMap<Integer, String> board);
    abstract boolean gameOver(HashMap<Integer, String> board, String player1Move, String player2Move);
}
