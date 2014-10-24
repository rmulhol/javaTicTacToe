package com.javaTTT;

import java.util.HashMap;

abstract class Display {

    abstract void introduceGame();

    abstract void offerCustomSettings();

    abstract void getBoardSize();

    abstract void getPlayerIdentity(int i);

    abstract void getPlayerMoveSignature(int i);

    abstract void displayBoardWithIndexes(int boardSize);

    abstract void displayBoard(HashMap board);

    abstract void announceWinForPlayer(String playerMove);

    abstract void announceTieGame();

    abstract void announceInputError();

    abstract String getInput();

    abstract int getValidInteger(String regex);

}
