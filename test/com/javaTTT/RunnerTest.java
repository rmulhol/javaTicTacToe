package com.javaTTT;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
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
        String move = "1";
        newGame.setMove(move);
        boolean setMoveCalled = mockBoard.setMoveCalled();
        assertTrue(setMoveCalled);
    }

    @Test
    public void testAnnounceWinForX() {
        newGame.announceWinForX();
        boolean xWinAnnounced = mockDisplay.verifyXWinAnnounced();
        assertTrue(xWinAnnounced);
    }

    @Test
    public void testAnnounceWinForO() {
        newGame.announceWinForO();
        boolean oWinAnnounced = mockDisplay.verifyOWinAnnounced();
        assertTrue(oWinAnnounced);
    }

    @Test
    public void testAnnounceTieGame() {
        newGame.announceTieGame();
        boolean tieGameAnnounced = mockDisplay.tieGameAnnounced;
        assertTrue(tieGameAnnounced);
    }

    @Test
    public void testGetPlayer1Move() {
        String gotMove = newGame.getPlayer1Move();
        assertEquals("Get move called", gotMove);
    }

    @Test
    public void testGetPlayer2Move() {
        String gotMove = newGame.getPlayer2Move();
        assertEquals("Get move called", gotMove);
    }

    @Test
    public void testCheckSpaceAvailability() {
        String move = "1";
        newGame.spaceAvailable(move);
        boolean spaceAvailabilityChecked = mockBoard.spaceAvailableCalled();
        assertTrue(spaceAvailabilityChecked);
    }

    @Test
    public void testXWins() {
        newGame.xWins();
        boolean playerWinsCalled = mockBoard.playerWinsCalled();
        assertTrue(playerWinsCalled);
    }

    @Test
    public void testOWins() {
        newGame.oWins();
        boolean playerWinsCalled = mockBoard.playerWinsCalled();
        assertTrue(playerWinsCalled);
    }

    @Test
    public void testTieGame() {
        newGame.tieGame();
        boolean tieGameCalled = mockBoard.tieGameCalled();
        assertTrue(tieGameCalled);
    }

}