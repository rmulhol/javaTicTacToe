package com.javaTTT;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardImplTest {

    private Board testBoard = new BoardImpl(3);

    @Test
    public void testCalculatesBoardLengthForSideLength3() {
        int actualBoardSize = testBoard.calculateBoardSizeFromSideLength(3);
        assertEquals(9, actualBoardSize);
    }

    @Test
    public void testCalculatesBoardLengthForSideLength4() {
        int actualBoardSize = testBoard.calculateBoardSizeFromSideLength(4);
        assertEquals(16, actualBoardSize);
    }

    @Test
    public void testCalculatesBoardSize9FromBoard() {
        HashMap<Integer, String> boardLength9 = new HashMap<Integer, String>();
        for(int i=0; i<9; i++) { boardLength9.put(i, " "); }
        int actualSizeOfBoard = testBoard.calculateBoardSizeFromBoard(boardLength9);
        assertEquals(9, actualSizeOfBoard);
    }

    @Test
    public void testCalculatesBoardSize16FromBoard() {
        HashMap<Integer, String> boardLength16 = new HashMap<Integer, String>();
        for(int i=0; i<16; i++) { boardLength16.put(i, " "); }
        int actualSizeOfBoard = testBoard.calculateBoardSizeFromBoard(boardLength16);
        assertEquals(16, actualSizeOfBoard);
    }

    @Test
    public void testCalculatesBoardSideLength3FromBoard() {
        HashMap<Integer, String> boardLength9 = new HashMap<Integer, String>();
        for(int i=0; i<9; i++) { boardLength9.put(i, " "); }
        int actualSideLengthOfBoard = testBoard.calculateBoardSideLengthFromBoard(boardLength9);
        assertEquals(3, actualSideLengthOfBoard);
    }

    @Test
    public void testCalculatesBoardSideLength4FromBoard() {
        HashMap<Integer, String> boardLength16 = new HashMap<Integer, String>();
        for(int i=0; i<16; i++) { boardLength16.put(i, " "); }
        int actualSideLengthOfBoard = testBoard.calculateBoardSideLengthFromBoard(boardLength16);
        assertEquals(4, actualSideLengthOfBoard);
    }

    @Test
    public void testCreatesEmptyBoardForSize3() {
        HashMap actualEmptyBoard = testBoard.createEmptyBoard(9);
        HashMap<Integer, String> expectedEmptyBoard;
        expectedEmptyBoard = new HashMap<Integer, String>();
        for (int i = 0; i < 9; i++) {
            expectedEmptyBoard.put(i, " ");
        }
        assertEquals(expectedEmptyBoard, actualEmptyBoard);
    }

    @Test
    public void testCreatesEmptyBoardForSize4() {
        HashMap actualEmptyBoard = testBoard.createEmptyBoard(16);
        HashMap<Integer, String> expectedEmptyBoard;
        expectedEmptyBoard = new HashMap<Integer, String>();
        for (int i = 0; i < 16; i++) {
            expectedEmptyBoard.put(i, " ");
        }
        assertEquals(expectedEmptyBoard, actualEmptyBoard);
    }

    @Test
    public void testGetBoardReturnsEmptyBoardAtBeginningOfGame() {
        HashMap expectedEmptyBoard = testBoard.createEmptyBoard(9);
        HashMap actualEmptyBoard = testBoard.getBoard();
        assertEquals(expectedEmptyBoard, actualEmptyBoard);
    }

    @Test
    public void testGetBoardReturnsModifiedBoardWithMoves() {
        HashMap<Integer, String> expectedBoard = new HashMap<Integer, String>();
        for(int i=0; i<9; i++) {
            expectedBoard.put(i, " ");
        }
        expectedBoard.put(3, "X");
        HashMap actualBoard = testBoard.board;
        testBoard.setMove(actualBoard, 3, "X");
        assertEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testSetMoveClaimsOpenSpace() {
        HashMap<Integer, String> expectedBoard = new HashMap<Integer, String>();
        for (int i = 0; i < 9; i++) {
            expectedBoard.put(i, " ");
        }
        expectedBoard.put(1, "X");
        testBoard.setMove(testBoard.board, 1, "X");
        HashMap boardWithMove = testBoard.getBoard();
        assertEquals(expectedBoard, boardWithMove);
    }

    @Test
    public void testGeneratesRowsForSize3() {
        int[][] expectedRows = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        int[][] actualRows = testBoard.rows(3);
        Assert.assertArrayEquals(expectedRows, actualRows);
    }

    @Test
    public void testGeneratesRowsForSize4() {
        int[][] expectedRows = {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };
        int[][] actualRows = testBoard.rows(4);
        Assert.assertArrayEquals(expectedRows, actualRows);
    }

    @Test
    public void testGeneratesColumnsForSize3() {
        int[][] expectedColumns = {
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8}
        };
        int[][] actualColumns = testBoard.columns(3);
        Assert.assertArrayEquals(expectedColumns, actualColumns);
    }

    @Test
    public void testGeneratesColumnsForSize4() {
        int[][] expectedColumns = {
                {0, 4, 8, 12},
                {1, 5, 9, 13},
                {2, 6, 10, 14},
                {3, 7, 11, 15}
        };
        int[][] actualColumns = testBoard.columns(4);
        Assert.assertArrayEquals(expectedColumns, actualColumns);
    }

    @Test
    public void testGeneratesLeftToRightDiagonalForSize3() {
        int[][] expectedDiagonal = {
                {0, 4, 8}
        };
        int[][] actualDiagonals = testBoard.leftToRightDiagonal(3);
        Assert.assertArrayEquals(expectedDiagonal, actualDiagonals);
    }

    @Test
    public void testGeneratesLeftToRightDiagonalForSize4() {
        int[][] expectedDiagonal = {
                {0, 5, 10, 15}
        };
        int[][] actualDiagonals = testBoard.leftToRightDiagonal(4);
        Assert.assertArrayEquals(expectedDiagonal, actualDiagonals);
    }

    @Test
    public void testGeneratesRightToLeftDiagonalForSize3() {
        int[][] expectedDiagonal = {
                {2, 4, 6}
        };
        int[][] actualDiagonal = testBoard.rightToLeftDiagonal(3);
        Assert.assertArrayEquals(expectedDiagonal, actualDiagonal);
    }

    @Test
    public void testGeneratesRightToLeftDiagonalForSize4() {
        int[][] expectedDiagonal = {
                {3, 6, 9, 12}
        };
        int[][] actualDiagonal = testBoard.rightToLeftDiagonal(4);
        Assert.assertArrayEquals(expectedDiagonal, actualDiagonal);
    }

    @Test
    public void testGeneratesWinningCombinationsForSize3() {
        int[][] expectedCombinations = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };
        int[][] actualCombinations = testBoard.winningCombinations(3);
        Assert.assertArrayEquals(expectedCombinations, actualCombinations);
    }

    @Test
    public void testGeneratesWinningCombinationsForSize4() {
        int[][] expectedCombinations = {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15},
                {0, 4, 8, 12},
                {1, 5, 9, 13},
                {2, 6, 10, 14},
                {3, 7, 11, 15},
                {0, 5, 10, 15},
                {3, 6, 9, 12}
        };
        int[][] actualCombinations = testBoard.winningCombinations(4);
        Assert.assertArrayEquals(expectedCombinations, actualCombinations);
    }

    @Test
    public void testAllSpacesAvailableAtBeginning() {
        testBoard.createEmptyBoard(3);
        boolean allSpacesEmpty = true;
        for (int i = 0; i < 9; i++) {
            if (!testBoard.spaceAvailable(testBoard.board, i)) {
                allSpacesEmpty = false;
            }
        }
        assertTrue(allSpacesEmpty);
    }

    @Test
    public void testClaimedSpacesNotAvailable() {
        testBoard.setMove(testBoard.board, 1, "X");
        boolean allSpacesEmpty = true;
        for (int i = 0; i < 9; i++) {
            if (!testBoard.spaceAvailable(testBoard.board, i)) {
                allSpacesEmpty = false;
            }
        }
        assertFalse(allSpacesEmpty);
    }

    @Test
    public void testGameOverRecognizesPlayerWin() {
        for(int i=0; i<9; i++) {
            testBoard.setMove(testBoard.board, i, "X");
        }
        boolean gameOver = testBoard.gameOver(testBoard.board, "X", "O");
        assertTrue(gameOver);
    }

    @Test
    public void testGameOverRecognizesTie() {
        HashMap gameBoard = testBoard.board;
        testBoard.setMove(gameBoard, 0, "X");
        testBoard.setMove(gameBoard, 1, "O");
        testBoard.setMove(gameBoard, 2, "X");
        testBoard.setMove(gameBoard, 3, "X");
        testBoard.setMove(gameBoard, 4, "O");
        testBoard.setMove(gameBoard, 5, "O");
        testBoard.setMove(gameBoard, 6, "0");
        testBoard.setMove(gameBoard, 7, "X");
        testBoard.setMove(gameBoard, 8, "X");
        boolean gameOver = testBoard.gameOver(gameBoard, "X", "O");
        assertTrue(gameOver);
    }

    @Test
    public void testRecognizesPlayerWin() {
        HashMap gameBoard = testBoard.board;
        testBoard.setMove(gameBoard, 0, "X");
        testBoard.setMove(gameBoard, 1, "X");
        testBoard.setMove(gameBoard, 2, "X");
        boolean gameOver = testBoard.playerWins(gameBoard, "X");
        assertTrue(gameOver);
    }

    @Test
    public void testDoesNotFalselyAssignWin() {
        boolean gameOver = testBoard.playerWins(testBoard.board, "X");
        assertFalse(gameOver);
    }

    @Test
    public void testRecognizesTieGame() {
        for(int i=0; i<9; i++) {
            testBoard.setMove(testBoard.board, i, "X");
        }
        boolean gameOver = testBoard.tieGame(testBoard.board);
        assertTrue(gameOver);
    }

    @Test
    public void testDoesNotFalselyAssignTieGame() {
        boolean gameOver = testBoard.tieGame(testBoard.board);
        assertFalse(gameOver);
    }
}