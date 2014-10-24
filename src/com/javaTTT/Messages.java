package com.javaTTT;

import java.util.HashMap;

abstract class Messages {

    abstract String introduceGame();

    abstract String offerCustomSettings();

    abstract String getBoardSize();

    abstract String getPlayerIdentity(int i);

    abstract String getPlayerMoveSignature(int i);

    abstract String displayBoardWithIndexes(int boardSize);

    abstract String boardWithIndexes(int boardSize);

    abstract String displayBoard(HashMap boardArray);

    abstract String announceWinForPlayer(String playerMove);

    abstract String announceTieGame();

    abstract String boardLine(int boardSideLength);

    abstract String announceInputError();



}
