package com.javaTTT;

import java.util.HashMap;

abstract class Display {

    abstract void introduceGame();

    abstract void displayBoard(HashMap boardArray);

    abstract void announceWinForX();

    abstract void announceWinForO();

    abstract void announceTieGame();

}
