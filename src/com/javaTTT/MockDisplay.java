package com.javaTTT;

import java.util.HashMap;

public class MockDisplay extends Display{

    boolean boardDisplayed = false;
    boolean playerWinAnnounced = false;
    boolean tieGameAnnounced = false;
    boolean gameIntroduced = false;
    boolean indexesDisplayed = false;


    @Override
    void introduceGame() { gameIntroduced = true; }

    @Override
    void displayBoardWithIndexes(int boardSize) {
        indexesDisplayed = true;
    }

    @Override
    void displayBoard(HashMap boardArray) { boardDisplayed = true; }

    @Override
    void announceWinForPlayer(String playerMove) { playerWinAnnounced = true; }

    @Override
    void announceTieGame() { tieGameAnnounced = true; }

    boolean verifyGameIntroduced() { return gameIntroduced; }

    boolean verifyBoardDisplayed() { return boardDisplayed; }

    boolean playerWinAnnounced() { return playerWinAnnounced; }

    boolean tieGameAnnounced() { return tieGameAnnounced; }

}
