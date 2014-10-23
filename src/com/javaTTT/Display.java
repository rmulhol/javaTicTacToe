package com.javaTTT;

import java.util.HashMap;

abstract class Display {

    abstract void introduceGame();

    abstract void displayBoardWithIndexes(int boardSize);

    abstract void displayBoard(HashMap board);

    abstract void announceWinForPlayer(String playerMove);

    abstract void announceTieGame();



}
