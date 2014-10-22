package com.javaTTT;

import java.util.HashMap;

abstract class Display {

    abstract void introduceGame();

    abstract void announceGameWillNotBegin();

    abstract void displayBoard(HashMap boardArray);

    abstract void announceWinForPlayer1(String player1Move);

    abstract void announceWinForPlayer2(String player2Move);

    abstract void announceTieGame();

    abstract void printLine(String string);

    abstract void printNoLine(String string);

}
