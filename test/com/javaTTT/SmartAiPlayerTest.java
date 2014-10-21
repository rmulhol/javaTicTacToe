package com.javaTTT;

import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class SmartAiPlayerTest {

    private Board testBoard = new BoardImpl(3);
    private Player smartAiPlayer = new SmartAiPlayer(testBoard);


    @Test
    public void testAiClaimsWinner() {
        testBoard.setMove(3, "O");
        testBoard.setMove(4, "O");
        int winningMove = smartAiPlayer.getMove("X", "O");
        assertEquals(5, winningMove);
    }

    @Test
    public void testAiOnlyClaimsOneSpace() {
        testBoard.setMove(3, "O");
        testBoard.setMove(4, "O");
        int aiMove = smartAiPlayer.getMove("X", "O");
        testBoard.setMove(aiMove, "O");
        boolean otherSpacesOpen = testBoard.spaceAvailable(0) &&
                testBoard.spaceAvailable(1) &&
                testBoard.spaceAvailable(2) &&
                testBoard.spaceAvailable(6) &&
                testBoard.spaceAvailable(7) &&
                testBoard.spaceAvailable(8);
        assertTrue(otherSpacesOpen);
    }

    @Test
    public void testAiBlocksLoser() {
        testBoard.setMove(3, "X");
        testBoard.setMove(4, "X");
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