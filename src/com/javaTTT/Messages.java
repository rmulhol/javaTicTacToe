package com.javaTTT;

import java.util.HashMap;

abstract class Messages {

    abstract String introduceGame();

    abstract String displayBoardWithIndexes(int boardSize);

    abstract String boardWithIndexes(int boardSize);

    abstract String displayBoard(HashMap boardArray);

    abstract String announceWinForPlayer(String playerMove);

    abstract String announceTieGame();

    abstract String boardLine(int boardSideLength);



}
