package com.javaTTT;

import org.testng.annotations.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class SmartAiPlayerTest {

    private Board testBoardObject = new BoardImpl(3);
    private Player smartAiPlayer = new SmartAiPlayer(testBoardObject, "O");
    private HashMap<Integer, String> testBoard = new HashMap<Integer, String>(9);

    @Test
    public void testAiClaimsWinner() {
        for(int i=0; i<9; i++) testBoard.put(i, " ");
        testBoard.put(3, "O");
        testBoard.put(4, "O");
        int winningMove = smartAiPlayer.getMove(testBoard, "X", "O");
        assertEquals(5, winningMove);
    }

    @Test
    public void testAiBlocksLoser() {
        for(int i=0; i<9; i++) testBoard.put(i, " ");
        testBoard.put(3, "X");
        testBoard.put(4, "X");
        int blockingMove = smartAiPlayer.getMove(testBoard, "X", "O");
        assertEquals(5, blockingMove);
    }

    @Test
    public void testAiClaimsWinnerBeforeBlockingLoser() {
        for(int i=0; i<9; i++) testBoard.put(i, " ");
        testBoard.put(0, "X");
        testBoard.put(2, "X");
        testBoard.put(6, "O");
        testBoard.put(8, "O");
        int winningMove = smartAiPlayer.getMove(testBoard, "X", "O");
        assertEquals(7, winningMove);
    }

    @Test
    public void testAiClaimsMiddleByDefaultWithOddSizeBoard() {
        for(int i=0; i<9; i++) testBoard.put(i, " ");
        int middleClaim = smartAiPlayer.getMove(testBoard, "X", "O");
        assertEquals(4, middleClaim);
    }

}