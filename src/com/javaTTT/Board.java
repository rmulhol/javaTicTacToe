package com.javaTTT;

/**
 * Created by robertmulholand on 10/15/14.
 */
abstract class Board {

    abstract int[] getBoard();

    abstract void addPlayerMove(String move);

    abstract boolean checkSpaceAvailability(String move);

    abstract boolean gameOver();

    abstract int[] createEmptyBoard();

    abstract boolean xWins();

    abstract boolean oWins();

}
