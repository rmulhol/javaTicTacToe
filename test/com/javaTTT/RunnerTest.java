package com.javaTTT;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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
        assertEquals(true, gameIntroduced);
    }

    @Test
    public void testGetBoard() {
        int[] actualBoard = newGame.getBoard();
        int[] expectedBoard = new int[9];
        Assert.assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testDisplayBoard() {
        int[] emptyBoard = new int[9];
        newGame.displayBoard(emptyBoard);
        boolean boardDisplayed = mockDisplay.verifyBoardDisplayed();
        assertEquals(true, boardDisplayed);
    }

    @Test
    public void testAnnounceSpaceTaken() {
        newGame.announceSpaceTaken();
        boolean spaceTakenAnnounced = mockDisplay.verifySpaceTakenAnnounced();
        assertEquals(true, spaceTakenAnnounced);
    }

    @Test
    public void testAnnounceWinForX() {
        newGame.announceWinForX();
        boolean xWinAnnounced = mockDisplay.verifyXWinAnnounced();
        assertEquals(true, xWinAnnounced);
    }

    @Test
    public void testAnnounceWinForO() {
        newGame.announceWinForO();
        boolean oWinAnnounced = mockDisplay.verifyOWinAnnounced();
        assertEquals(true, oWinAnnounced);
    }

    @Test
    public void testAnnounceTieGame() {
        newGame.announceTieGame();
        boolean tieGameAnnounced = mockDisplay.tieGameAnnounced;
        assertEquals(true, tieGameAnnounced);
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
        String move = "test move";
        boolean spaceAvailabilityChecked = newGame.spaceAvailable(move);
        assertEquals(true, spaceAvailabilityChecked);
    }

    @Test
    public void testSetMove() {
        String move = "test move";
        newGame.setMove(move);
        boolean setMoveRan = mockBoard.verifyMoveAdded();
        assertEquals(true, setMoveRan);
    }

    @Test
    public void testGameOver() {
        boolean gameOver = newGame.gameOver();
        assertEquals(true, gameOver);
    }

    @Test
    public void testXWins() {
        boolean xWins = newGame.xWins();
        assertEquals(true, xWins);
    }

    @Test
    public void testOWins() {
        boolean oWins = newGame.oWins();
        assertEquals(true, oWins);
    }

    @Test
    public void testTieGame() {
        boolean tieGame = newGame.tieGame();
        assertEquals(true, tieGame);
    }

}