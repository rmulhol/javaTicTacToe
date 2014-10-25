package com.javaTTT;

import org.testng.annotations.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class SmartAiPlayerTest {

    private Board testBoard = new BoardImpl(3);
    private Player smartAiPlayer = new SmartAiPlayer(testBoard, "O");

    // necessary because all of these tests are dependent on the board class
    void clearBoard() {
        for(int i=0; i<6; i++) {
            testBoard.setMove(testBoard.board, i, " ");
        }
    }

    @Test
    public void testAiClaimsWinner() {
        clearBoard();
        testBoard.setMove(testBoard.board, 3, "O");
        testBoard.setMove(testBoard.board, 4, "O");
        int winningMove = smartAiPlayer.getMove("X", "O");
        assertEquals(5, winningMove);
    }

    @Test
    public void testAiBlocksLoser() {
        clearBoard();
        testBoard.setMove(testBoard.board, 3, "X");
        testBoard.setMove(testBoard.board, 4, "X");
        int blockingMove = smartAiPlayer.getMove("X", "O");
        assertEquals(5, blockingMove);
    }

    @Test
    public void testAiClaimsWinnerBeforeBlockingLoser() {
        clearBoard();
        testBoard.setMove(testBoard.board, 0, "X");
        testBoard.setMove(testBoard.board, 2, "X");
        testBoard.setMove(testBoard.board, 6, "O");
        testBoard.setMove(testBoard.board, 8, "O");
        int winningMove = smartAiPlayer.getMove("X", "O");
        assertEquals(7, winningMove);
    }

    @Test
    public void testAiClaimsMiddleByDefault() {
        clearBoard();
        int middleClaim = smartAiPlayer.getMove("X", "O");
        assertEquals(4, middleClaim);
    }
}