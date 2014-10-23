package com.javaTTT;

import java.util.HashMap;

public class MockBoard extends Board {

    boolean getBoardCalled = false;
    boolean setMoveCalled = false;
    boolean tieGameCalled = false;
    boolean spaceAvailableCalled = false;
    boolean playerWinsCalled = false;
    boolean gameOverCalled = false;

    @Override
    int calculateBoardSizeFromSideLength(int boardSize) {
        return 0;
    }

    @Override
    int calculateBoardSizeFromBoard(HashMap board) {
        return 0;
    }

    @Override
    int calculateBoardSideLengthFromBoard(HashMap board) {
        return 0;
    }

    @Override
    HashMap createEmptyBoard(int boardLength) { return null; }

    @Override
    HashMap getBoard() {
        getBoardCalled = true;
        return null;
    }

    @Override
    void setMove(HashMap board, int move, String player) { setMoveCalled = true; }

    @Override
    boolean spaceAvailable(HashMap board, int move) {
        spaceAvailableCalled = true;
        return false;
    }

    @Override
    int[][] rows(int boardSize) { return new int[0][]; }

    @Override
    int[][] columns(int boardSize) { return new int[0][]; }

    @Override
    int[][] leftToRightDiagonal(int boardSize) { return new int[0][]; }

    @Override
    public int[][] rightToLeftDiagonal(int boardSize) { return new int[0][]; }

    @Override
    public int[][] winningCombinations(int boardSize) { return new int[0][]; }

    @Override
    public boolean playerWins(HashMap board, String playerMove) {
        playerWinsCalled = true;
        return false;
    }

    @Override
    public boolean tieGame(HashMap board) {
        tieGameCalled = true;
        return false;
    }

    @Override
    boolean gameOver(HashMap board, String player1Move, String player2Move) {
        gameOverCalled = true;
        return false;
    }

    boolean getBoardCalled() { return getBoardCalled; }

    boolean setMoveCalled() { return setMoveCalled; }

    boolean tieGameCalled() { return tieGameCalled; }

    boolean spaceAvailableCalled() { return spaceAvailableCalled; }

    boolean playerWinsCalled() { return playerWinsCalled; }

    boolean gameOverCalled() { return gameOverCalled; }

}