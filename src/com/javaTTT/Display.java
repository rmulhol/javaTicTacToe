package com.javaTTT;

/**
 * Created by robertmulholand on 10/15/14.
 */
abstract class Display {

    abstract void introduceGame();

    abstract void displayBoard(int[] boardArray);

    abstract void announceWinForX();

    abstract void announceWinForO();

    abstract void announceTieGame();

}
