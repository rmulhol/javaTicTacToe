package com.javaTTT;

import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class SmartAiPlayerTest {

    private Board testBoard = new BoardImpl(3);
    private Player smartAiPlayer = new SmartAiPlayer(testBoard);

    // all of these tests are dependent on the board class

    @Test
    public void testAiClaimsWinner() {
        testBoard.setMove(testBoard.board, 3, "O");
        testBoard.setMove(testBoard.board, 4, "O");
        int winningMove = smartAiPlayer.getMove("X", "O");
        assertEquals(5, winningMove);
    }

    @Test
    public void testAiOnlyClaimsOneSpace() {
        testBoard.setMove(testBoard.board, 3, "O");
        testBoard.setMove(testBoard.board, 4, "O");
        int aiMove = smartAiPlayer.getMove("X", "O");
        testBoard.setMove(testBoard.board, aiMove, "O");
        boolean otherSpacesOpen = testBoard.spaceAvailable(testBoard.board, 0) &&
                testBoard.spaceAvailable(testBoard.board, 1) &&
                testBoard.spaceAvailable(testBoard.board, 2) &&
                testBoard.spaceAvailable(testBoard.board, 6) &&
                testBoard.spaceAvailable(testBoard.board, 7) &&
                testBoard.spaceAvailable(testBoard.board, 8);
        assertTrue(otherSpacesOpen);
    }

    @Test
    public void testAiBlocksLoser() {
        testBoard.setMove(testBoard.board, 3, "X");
        testBoard.setMove(testBoard.board, 4, "X");
        int blockingMove = smartAiPlayer.getMove("X", "O");
        assertEquals(5, blockingMove);
    }

    // Re-initializing board and player bc previous tests seem to interfere with board configuration (e.g. test below returns 5 instead of 4)
    @Test
    public void testAiClaimsMiddleByDefault() {
        Board newTestBoard = new BoardImpl(3);
        Player newSmartAiPlayer = new SmartAiPlayer(newTestBoard);
        int middleClaim = newSmartAiPlayer.getMove("X", "O");
        assertEquals(4, middleClaim);
    }
}