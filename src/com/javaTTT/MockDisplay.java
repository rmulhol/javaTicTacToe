package com.javaTTT;

import java.util.HashMap;

public class MockDisplay extends Display{

    boolean boardDisplayed = false;
    boolean player1WinAnnounced = false;
    boolean player2WinAnnounced = false;
    boolean tieGameAnnounced = false;
    boolean gameIntroduced = false;
    boolean printLineWasCalled = false;
    boolean printNoLineWasCalled = false;
    boolean gameWillNotBeginAnnounced = false;

    @Override
    void introduceGame() { gameIntroduced = true; }

    @Override
    void announceGameWillNotBegin() { gameWillNotBeginAnnounced = true; }

    @Override
    public void displayBoard(HashMap boardArray) { boardDisplayed = true; }

    @Override
    void announceWinForPlayer1(String player1Move) { player1WinAnnounced = true; }

    @Override
    void announceWinForPlayer2(String player2Move) { player2WinAnnounced = true; }

    @Override
    void announceTieGame() { tieGameAnnounced = true; }

    @Override
    void printLine(String string) { printLineWasCalled = true; }

    @Override
    void printNoLine(String string) { printNoLineWasCalled = true; }

    public boolean verifyGameIntroduced() { return gameIntroduced; }

    boolean verifyBoardDisplayed() { return boardDisplayed; }

    boolean player1WinAnnounced() { return player1WinAnnounced; }

    boolean player2WinAnnounced() { return player2WinAnnounced; }

    boolean tieGameAnnounced() { return tieGameAnnounced; }

}
