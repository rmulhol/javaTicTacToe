package com.javaTTT;

/**
 * Created by robertmulholand on 10/10/14.
 */
public class MockDisplay extends Display{

    boolean boardDisplayed = false;

    public boolean verifyDisplayBoard() {
        return boardDisplayed;
    }

    @Override
    public void displayBoard(int[] boardArray) {
        boardDisplayed = true;
    }

}
