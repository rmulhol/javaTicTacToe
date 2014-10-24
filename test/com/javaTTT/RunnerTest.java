package com.javaTTT;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class RunnerTest {

    private MockDisplay mockDisplay = new MockDisplay();
    private MockBoard mockBoard = new MockBoard();
    private MockPlayer mockPlayer1 = new MockPlayer();
    private MockPlayer mockPlayer2 = new MockPlayer();

    private Runner newGame = new Runner(mockDisplay, mockBoard, mockPlayer1, mockPlayer2);

    @Test
    public void testIntroduceGame() {
        newGame.introduceGame();
        boolean gameIntroduced = mockDisplay.verifyGameIntroduced();
        assertTrue(gameIntroduced);
    }

    @Test
    public void testGetBoard() {
        newGame.getBoard();
        boolean gotBoard = mockBoard.getBoardCalled();
        assertTrue(gotBoard);
    }

    @Test
    public void testDisplayBoard() {
        HashMap emptyBoard = new HashMap();
        newGame.displayBoard(emptyBoard);
        boolean boardDisplayed = mockDisplay.verifyBoardDisplayed();
        assertTrue(boardDisplayed);
    }

    @Test
    public void testSetMove() {
        newGame.setMove(1);
        boolean setMoveCalled = mockBoard.setMoveCalled();
        assertTrue(setMoveCalled);
    }

    @Test
    public void testAnnounceWinForX() {
        newGame.announceWinForPlayer("X");
        boolean playerWinAnnounced = mockDisplay.playerWinAnnounced();
        assertTrue(playerWinAnnounced);
    }

    @Test
    public void testAnnounceTieGame() {
        newGame.announceTieGame();
        boolean tieGameAnnounced = mockDisplay.tieGameAnnounced();
        assertTrue(tieGameAnnounced);
    }

    @Test
    public void testGetPlayerMove() {
        newGame.getPlayerMove(mockPlayer1);
        boolean getMoveCalled = mockPlayer1.getMoveCalled();
        assertTrue(getMoveCalled);
    }

    @Test
    public void testCheckSpaceAvailability() {
        newGame.spaceAvailable(1);
        boolean spaceAvailabilityChecked = mockBoard.spaceAvailableCalled();
        assertTrue(spaceAvailabilityChecked);
    }

    @Test
    public void testCheckSpaceInRange() {
        newGame.spaceInRange(1);
        boolean spaceInRangeChecked = mockBoard.spaceInRangeCalled();
        assertTrue(spaceInRangeChecked);
    }

    @Test
    public void testXWins() {
        newGame.player1Wins();
        boolean playerWinsCalled = mockBoard.playerWinsCalled();
        assertTrue(playerWinsCalled);
    }

    @Test
    public void testOWins() {
        newGame.player2Wins();
        boolean playerWinsCalled = mockBoard.playerWinsCalled();
        assertTrue(playerWinsCalled);
    }

    @Test
    public void testTieGame() {
        newGame.tieGame();
        boolean tieGameCalled = mockBoard.tieGameCalled();
        assertTrue(tieGameCalled);
    }

    @Test
    public void testGameOver() {
        newGame.gameOver();
        boolean gameOverCalled = mockBoard.gameOverCalled();
        assertTrue(gameOverCalled);
    }

}