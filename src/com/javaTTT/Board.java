package com.javaTTT;

import java.util.HashMap;

abstract class Board {
    int boardSize;
    int boardLength;
    HashMap board;
    abstract int calculateBoardLength();
    abstract HashMap createEmptyBoard();
    abstract HashMap getBoard();
    abstract void setMove(int move, String player);
    abstract boolean spaceAvailable(int move);
    abstract int[][] rows();
    abstract int[][] columns();
    abstract int[][] leftToRightDiagonal();
    abstract int[][] rightToLeftDiagonal();
    abstract int[][] winningCombinations();
    abstract boolean playerWins(HashMap board, String playerMove);
    abstract boolean tieGame();
    abstract boolean gameOver(String player1Move, String player2Move);
}
