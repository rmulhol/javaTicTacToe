package com.javaTTT;

/**
 * Created by robertmulholand on 10/10/14.
 */
public class MockBoard extends Board {
    private boolean moveAdded = false;

    public int[] createEmptyBoard() {
        return null;
    }

    @Override
    public int[] getBoard() {
        return new int[9];
    }

    @Override
    void addPlayerMove(String move) {
        moveAdded = true;
    }

    public boolean verifyMoveAdded() {
        return moveAdded;
    }

    @Override
    boolean gameOver() {
        return true;
    }

    @Override
    boolean checkSpaceAvailability(String move) {
        return true;
    }

    @Override
    boolean xWins() {
        return false;
    }

    @Override
    boolean oWins() {
        return false;
    }

}
