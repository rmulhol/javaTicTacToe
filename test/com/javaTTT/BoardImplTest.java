package com.javaTTT;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardImplTest {
    private Board board = new BoardImpl();
    private int[] emptyBoard = board.createEmptyBoard();

    @Test
    public void testEmptyBoardLength() {
        int boardLength = emptyBoard.length;
        Assert.assertEquals(9, boardLength);
    }

    @Test
    public void testEmptyBoardContents() {
        int numberOfZeroes = 0;
        for (int i=0; i<9; i++)
            if (emptyBoard[i] == 0) numberOfZeroes++;
        Assert.assertEquals(9, numberOfZeroes);
    }

    @Test
    public void testGetBoardReturnsABoard() {
        int[] myBoard = board.getBoard();
        int boardLength = myBoard.length;
        Assert.assertEquals(9, boardLength);
    }
}