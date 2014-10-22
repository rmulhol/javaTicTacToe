package com.javaTTT;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardImplTest {

    private Board testBoardSize3 = new BoardImpl(3);
    private Board testBoardSize4 = new BoardImpl(4);

    @Test
    public void testCalculateBoardLengthForSize3() {
        int actualBoardSize = testBoardSize3.calculateBoardLength(3);
        assertEquals(9, actualBoardSize);
    }

    @Test
    public void testCalculateBoardLengthForSize4() {
        int actualBoardSize = testBoardSize4.calculateBoardLength(4);
        assertEquals(16, actualBoardSize);
    }

    @Test
    public void testCreateEmptyBoardForSize3() {
        HashMap actualEmptyBoard = testBoardSize3.createEmptyBoard(9);
        HashMap<Integer, String> expectedEmptyBoard;
        expectedEmptyBoard = new HashMap<Integer, String>();
        for (int i = 0; i < 9; i++) {
            expectedEmptyBoard.put(i, " ");
        }
        assertEquals(expectedEmptyBoard, actualEmptyBoard);
    }

    @Test
    public void testCreateEmptyBoardForSize4() {
        HashMap actualEmptyBoard = testBoardSize4.createEmptyBoard(16);
        HashMap<Integer, String> expectedEmptyBoard;
        expectedEmptyBoard = new HashMap<Integer, String>();
        for (int i = 0; i < 16; i++) {
            expectedEmptyBoard.put(i, " ");
        }
        assertEquals(expectedEmptyBoard, actualEmptyBoard);
    }

    @Test
    public void testGetBoardReturnsEmptyBoardAtBeginningOfGame() {
        HashMap expectedEmptyBoard = testBoardSize3.createEmptyBoard(9);
        HashMap actualEmptyBoard = testBoardSize3.getBoard();
        assertEquals(expectedEmptyBoard, actualEmptyBoard);
    }

    @Test
    public void testSetMoveClaimsOpenSpace() {
        HashMap<Integer, String> expectedBoard = new HashMap<Integer, String>();
        for (int i = 0; i < 9; i++) {
            expectedBoard.put(i, " ");
        }
        expectedBoard.put(1, "X");
        testBoardSize3.setMove(testBoardSize3.board, 1, "X");
        HashMap boardWithMove = testBoardSize3.getBoard();
        assertEquals(expectedBoard, boardWithMove);
    }

    @Test
    public void testAllSpacesAvailableAtBeginning() {
        testBoardSize3.createEmptyBoard(3);
        boolean allSpacesEmpty = true;
        for (int i = 0; i < 9; i++) {
            if (!testBoardSize3.spaceAvailable(testBoardSize3.board, i)) {
                allSpacesEmpty = false;
            }
        }
        assertTrue(allSpacesEmpty);
    }

    @Test
    public void testClaimedSpacesNotAvailable() {
        testBoardSize3.setMove(testBoardSize3.board, 1, "X");
        boolean allSpacesEmpty = true;
        for (int i = 0; i < 9; i++) {
            if (!testBoardSize3.spaceAvailable(testBoardSize3.board, i)) {
                allSpacesEmpty = false;
            }
        }
        assertFalse(allSpacesEmpty);
    }

    @Test
    public void testGeneratesRowsForSize3() {
        int[][] expectedRows = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        int[][] actualRows = testBoardSize3.rows(3);
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
        int[][] actualRows = testBoardSize4.rows(4);
        Assert.assertArrayEquals(expectedRows, actualRows);
    }

    @Test
    public void testGeneratesColumnsForSize3() {
        int[][] expectedColumns = {
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8}
        };
        int[][] actualColumns = testBoardSize3.columns(3);
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
        int[][] actualColumns = testBoardSize4.columns(4);
        Assert.assertArrayEquals(expectedColumns, actualColumns);
    }

    @Test
    public void testGeneratesLeftToRightDiagonalForSize3() {
        int[][] expectedDiagonal = {
                {0, 4, 8}
        };
        int[][] actualDiagonals = testBoardSize3.leftToRightDiagonal(3);
        Assert.assertArrayEquals(expectedDiagonal, actualDiagonals);
    }

    @Test
    public void testGeneratesLeftToRightDiagonalForSize4() {
        int[][] expectedDiagonal = {
                {0, 5, 10, 15}
        };
        int[][] actualDiagonals = testBoardSize4.leftToRightDiagonal(4);
        Assert.assertArrayEquals(expectedDiagonal, actualDiagonals);
    }

    @Test
    public void testGeneratesRightToLeftDiagonalForSize3() {
        int[][] expectedDiagonal = {
                {2, 4, 6}
        };
        int[][] actualDiagonal = testBoardSize3.rightToLeftDiagonal(3);
        Assert.assertArrayEquals(expectedDiagonal, actualDiagonal);
    }

    @Test
    public void testGeneratesRightToLeftDiagonalForSize4() {
        int[][] expectedDiagonal = {
                {3, 6, 9, 12}
        };
        int[][] actualDiagonal = testBoardSize4.rightToLeftDiagonal(4);
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
        int[][] actualCombinations = testBoardSize3.winningCombinations(3);
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
        int[][] actualCombinations = testBoardSize4.winningCombinations(4);
        Assert.assertArrayEquals(expectedCombinations, actualCombinations);
    }

    @Test
    public void testRecognizesPlayerWin() {
        HashMap gameBoard = testBoardSize3.board;
        testBoardSize3.setMove(gameBoard, 0, "X");
        testBoardSize3.setMove(gameBoard, 1, "X");
        testBoardSize3.setMove(gameBoard, 2, "X");
        boolean gameOver = testBoardSize3.playerWins(gameBoard, "X");
        assertTrue(gameOver);
    }

    @Test
    public void testDoesNotFalselyAssignWin() {
        boolean gameOver = testBoardSize3.playerWins(testBoardSize3.board, "X");
        assertFalse(gameOver);
    }

    @Test
    public void testRecognizesTieGame() {
        for(int i=0; i<9; i++) {
            testBoardSize3.setMove(testBoardSize3.board, i, "X");
        }
        boolean gameOver = testBoardSize3.tieGame(testBoardSize3.board);
        assertTrue(gameOver);
    }

    @Test
    public void testDoesNotFalselyAssignTieGame() {
        boolean gameOver = testBoardSize3.tieGame(testBoardSize3.board);
        assertFalse(gameOver);
    }

    @Test
    public void testGameOverRecognizesPlayerWin() {
        for(int i=0; i<9; i++) {
            testBoardSize3.setMove(testBoardSize3.board, i, "X");
        }
        boolean gameOver = testBoardSize3.gameOver(testBoardSize3.board, "X", "O");
        assertTrue(gameOver);
    }

    @Test
    public void testGameOverRecognizesTie() {
        HashMap gameBoard = testBoardSize3.board;
        testBoardSize3.setMove(gameBoard, 0, "X");
        testBoardSize3.setMove(gameBoard, 1, "O");
        testBoardSize3.setMove(gameBoard, 2, "X");
        testBoardSize3.setMove(gameBoard, 3, "X");
        testBoardSize3.setMove(gameBoard, 4, "O");
        testBoardSize3.setMove(gameBoard, 5, "O");
        testBoardSize3.setMove(gameBoard, 6, "0");
        testBoardSize3.setMove(gameBoard, 7, "X");
        testBoardSize3.setMove(gameBoard, 8, "X");
        boolean gameOver = testBoardSize3.gameOver(gameBoard, "X", "O");
        assertTrue(gameOver);
    }
}