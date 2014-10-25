package com.javaTTT;

import java.util.HashMap;

public class MockDisplay extends Display{

    boolean gameIntroduced = false;
    boolean customSettingsOffered = false;
    boolean boardDisplayed = false;
    boolean playerWinAnnounced = false;
    boolean tieGameAnnounced = false;
    boolean indexesDisplayed = false;
    boolean getInputCalled = false;
    boolean getValidIntegerCalled = false;
    boolean announceInputErrorCalled = false;


    @Override
    void introduceGame() { gameIntroduced = true; }

    @Override
    void offerCustomSettings() { customSettingsOffered = true; }

    @Override
    void getBoardSize() {}

    @Override
    void getPlayerIdentity(int i) {}

    @Override
    void getPlayerMoveSignature(int i) {}

    @Override
    void displayBoardWithIndexes(int boardSize) { indexesDisplayed = true; }

    @Override
    void displayBoard(HashMap boardArray) { boardDisplayed = true; }

    @Override
    void announcePlayerWin(String playerMove) { playerWinAnnounced = true; }

    @Override
    void announceTieGame() { tieGameAnnounced = true; }

    @Override
    void announceInputError() { announceInputErrorCalled = true; }

    @Override
    String getInput() {
        getInputCalled = true;
        // returning X instead of null bc configuration test loops until valid move signature
        return "X";
    }

    @Override
    int getValidInteger(String regex) {
        getValidIntegerCalled = true;
        return 0;
    }

    boolean verifyIntroduceGameCalled() { return gameIntroduced; }

    boolean verifyOfferCustomSettingsCalled() { return customSettingsOffered; }

    boolean verifyDisplayBoardCalled() { return boardDisplayed; }

    boolean verifyDisplayBoardWithIndexesCalled() { return indexesDisplayed; }

    boolean verifyGetInputCalled() { return getInputCalled; }

    boolean verifyGetValidIntegerCalled() { return getValidIntegerCalled; }

    boolean verifyAnnounceInputErrorCalled() { return announceInputErrorCalled; }

    boolean verifyAnnouncePlayerWinCalled() { return playerWinAnnounced; }

    boolean verifyAnnounceTieGameCalled() { return tieGameAnnounced; }

}
