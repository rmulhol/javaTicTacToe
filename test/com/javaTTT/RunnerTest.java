package com.javaTTT;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RunnerTest {
    private MockDisplay mockDisplay = new MockDisplay();
    private MockBoard mockBoard = new MockBoard();
    private MockPlayer mockPlayer = new MockPlayer();

    private Runner newGame = new Runner(mockDisplay, mockBoard, mockPlayer);

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
        boolean boardDisplayed = mockDisplay.verifyDisplayBoard();
        assertEquals(true, boardDisplayed);
    }

    @Test
    public void testGetMove() {
        String gotMove = newGame.getMove();
        assertEquals("Get move called", gotMove);
    }

    @Test
    public void testSetMove() {
        String move = "test move";
        newGame.setMove(move);
        boolean setMoveRan = mockBoard.verifyMoveAdded();
        assertEquals(true, setMoveRan);
    }

    @Test
    public void testCheckSpaceAvailability() {
        String move = "test move";
        boolean spaceAvailabilityChecked = newGame.spaceAvailable(move);
        assertEquals(true, spaceAvailabilityChecked);
    }

    @Test
    public void testGameOver() {
        boolean gameOver = newGame.gameOver();
        assertEquals(true, gameOver);
    }

}