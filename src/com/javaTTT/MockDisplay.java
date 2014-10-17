package com.javaTTT;

/**
 * Created by robertmulholand on 10/10/14.
 */
public class MockDisplay extends Display{

    boolean boardDisplayed = false;
    boolean xWinAnnounced = false;
    boolean oWinAnnounced = false;
    boolean spaceTakenAnnounced = false;

    public boolean verifyBoardDisplayed() {
        return boardDisplayed;
    }

    @Override
    public void displayBoard(int[] boardArray) {
        boardDisplayed = true;
    }

    @Override
    void announceSpaceTaken() {
        spaceTakenAnnounced = true;
    }

    boolean verifySpaceTakenAnnounced() {
        return spaceTakenAnnounced;
    }

    @Override
    void announceWinForX() {
        xWinAnnounced = true;
    }

    boolean verifyXWinAnnounced() {
        return xWinAnnounced;
    }

    @Override
    void announceWinForO() {
        oWinAnnounced = true;
    }

    boolean verifyOWinAnnounced() {
        return oWinAnnounced;
    }

}
