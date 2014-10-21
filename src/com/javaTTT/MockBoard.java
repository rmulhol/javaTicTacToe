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
    int calculateBoardLength() { return 0; }

    @Override
    HashMap createEmptyBoard() { return null; }

    @Override
    HashMap getBoard() {
        getBoardCalled = true;
        return null;
    }

    @Override
    void setMove(int move, String player) { setMoveCalled = true; }

    @Override
    boolean spaceAvailable(int move) {
        spaceAvailableCalled = true;
        return false;
    }

    @Override
    int[][] rows() { return new int[0][]; }

    @Override
    int[][] columns() { return new int[0][]; }

    @Override
    int[][] leftToRightDiagonal() { return new int[0][]; }

    @Override
    public int[][] rightToLeftDiagonal() { return new int[0][]; }

    @Override
    public int[][] winningCombinations() { return new int[0][]; }

    @Override
    public boolean playerWins(String playerMove) {
        playerWinsCalled = true;
        return false;
    }

    @Override
    public boolean tieGame() {
        tieGameCalled = true;
        return false;
    }

    @Override
    boolean gameOver(String player1Move, String player2Move) {
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