package com.javaTTT;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class UnbeatableAiPlayerTest {

    Board testBoardObject = new BoardImpl(3);
    UnbeatableAiPlayer testPlayer = new UnbeatableAiPlayer(testBoardObject, "O");
    HashMap<Integer, String> testBoard = new HashMap<Integer, String>();

    private HashMap<Integer, String> clearBoard() {
        for(int i=0; i<9; i++) {
            testBoard.put(i, " ");
        }
        return testBoard;
    }

    @Test
    public void testClaimsWinner() {
        clearBoard();
        testBoard.put(3, "O");
        testBoard.put(4, "O");
        int winningMove = testPlayer.getMove(testBoard, "X", "O");
        assertEquals(5, winningMove);
    }

    @Test
    public void testBlocksLoss() {
        clearBoard();
        testBoard.put(3, "X");
        testBoard.put(4, "X");
        int lossBlockingMove = testPlayer.getMove(testBoard, "X", "O");
        assertEquals(5, lossBlockingMove);
    }

    @Test
    // This test is passing, and therefore lying
    public void testBlocksLossAtIndex6() {
        clearBoard();
        testBoard.put(0, "0");
        testBoard.put(4, "X");
        testBoard.put(1, "O");
        testBoard.put(2, "X");
        int lossBlockingMove = testPlayer.getMove(testBoard, "X", "O");
        assertEquals(6, lossBlockingMove);
    }

    @Test
    public void testClaimsFork() {
        clearBoard();
        testBoard.put(0, "O");
        testBoard.put(1, "X");
        testBoard.put(4, "O");
        testBoard.put(8,  "X");
        int forkClaimingMove = testPlayer.getMove(testBoard, "X", "O");
        assertEquals(3, forkClaimingMove);
    }

    @Test
    public void testBlocksFork() {
        clearBoard();
        testBoard.put(0, "X");
        testBoard.put(4, "O");
        testBoard.put(8, "X");
        int forkBlockingMove = testPlayer.getMove(testBoard, "X", "O");
        assertNotEquals(2, forkBlockingMove);
        assertNotEquals(6, forkBlockingMove);
    }

    @Test
    public void testFindsAvailableSpacesWithClaimsOnMiddleRow() {
        HashMap<Integer, String> testBoard = new HashMap<Integer, String>();
        for(int i=0; i<9; i++) {
            testBoard.put(i, " ");
        }
        testBoard.put(3, "O");
        testBoard.put(4, "O");
        int[] expectedSpaces = { 0, 1, 2, 5, 6, 7, 8 };
        int[] actualSpaces = testPlayer.availableSpaces(testBoard);
        assertArrayEquals(expectedSpaces, actualSpaces);
    }

    @Test
    public void testFindsAvailableSpacesWithClaimsOnTopRow() {
        HashMap<Integer, String> testBoard = new HashMap<Integer, String>();
        for (int i = 0; i < 9; i++) {
            testBoard.put(i, " ");
        }
        testBoard.put(0, "O");
        testBoard.put(1, "O");
        int[] expectedSpaces = { 2, 3, 4, 5, 6, 7, 8 };
        int[] actualSpaces = testPlayer.availableSpaces(testBoard);
        assertArrayEquals(expectedSpaces, actualSpaces);
    }
}