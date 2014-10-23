package com.javaTTT;

import org.testng.annotations.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class MessagesImplTest {

    Messages messages = new MessagesImpl();

    @Test
    public void testIntroduceGameSaysHello() {
        String introGame = messages.introduceGame();
        boolean saysHello = introGame.contains("Hello.");
        assertTrue(saysHello);
    }

    @Test
    public void testGetBoardSizeQueriesUser() {
        String getBoardSize = messages.getBoardSize();
        boolean queriesBoardSize = getBoardSize.contains("side length");
        assertTrue(queriesBoardSize);
    }

    @Test
    public void testGetPlayerIdentity() {
        String getPlayerIdentity = messages.getPlayerIdentity(1);
        boolean queriesPlayerIdentity = getPlayerIdentity.contains("identity of player");
        assertTrue(queriesPlayerIdentity);
    }

    @Test
    public void testDisplayBoardIndexesIntroducesBoard() {
        String displayBoardWithIndexes = messages.displayBoardWithIndexes(9);
        boolean introducesBoard = displayBoardWithIndexes.contains("indexed as follows");
        assertTrue(introducesBoard);
    }

    @Test
    public void testDisplayBoardIndexesStartsGame() {
        String displayBoardWithIndexes = messages.displayBoardWithIndexes(9);
        boolean introducesGame = displayBoardWithIndexes.contains("Let's get started!");
        assertTrue(introducesGame);
    }

    @Test
    public void testDisplayIndexesWorksForSideLength3() {
        String expectedBoard = "\n" +
                "|----|----|----|\n" +
                "|  0 |  1 |  2 |\n" +
                "|----|----|----|\n" +
                "|  3 |  4 |  5 |\n" +
                "|----|----|----|\n" +
                "|  6 |  7 |  8 |\n" +
                "|----|----|----|\n";
        String actualBoard = messages.boardWithIndexes(9);
        assertEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testDisplayIndexesWorksForSideLength4() {
        String expectedBoard = "\n" +
                "|----|----|----|----|\n" +
                "|  0 |  1 |  2 |  3 |\n" +
                "|----|----|----|----|\n" +
                "|  4 |  5 |  6 |  7 |\n" +
                "|----|----|----|----|\n" +
                "|  8 |  9 | 10 | 11 |\n" +
                "|----|----|----|----|\n" +
                "| 12 | 13 | 14 | 15 |\n" +
                "|----|----|----|----|\n";
        String actualBoard = messages.boardWithIndexes(16);
        assertEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testDisplayBoardShowsBoardWithSideLength3() {
        String expectedBoard = "\n" +
                "|----|----|----|\n" +
                "|    |    |    |\n" +
                "|----|----|----|\n" +
                "|    |    |    |\n" +
                "|----|----|----|\n" +
                "|    |    |    |\n" +
                "|----|----|----|\n";
        HashMap<Integer, String> testBoard = new HashMap<Integer, String>();
        for(int i=0; i<9; i++) {
            testBoard.put(i, " ");
        }
        String actualBoard = messages.displayBoard(testBoard);
        assertEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testDisplayBoardShowsBoardWithSideLength4() {
        String expectedBoard = "\n" +
                "|----|----|----|----|\n" +
                "|    |    |    |    |\n" +
                "|----|----|----|----|\n" +
                "|    |    |    |    |\n" +
                "|----|----|----|----|\n" +
                "|    |    |    |    |\n" +
                "|----|----|----|----|\n" +
                "|    |    |    |    |\n" +
                "|----|----|----|----|\n";
        HashMap<Integer, String> testBoard = new HashMap<Integer, String>();
        for(int i=0; i<16; i++) {
            testBoard.put(i, " ");
        }
        String actualBoard = messages.displayBoard(testBoard);
        assertEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testAnnounceWinWorksForX() {
        String xWins = messages.announceWinForPlayer("X");
        boolean saysXWins = xWins.contains("X wins");
        assertTrue(saysXWins);
    }

    @Test
    public void testAnnounceWinWorksForO() {
        String oWins = messages.announceWinForPlayer("O");
        boolean saysOWins = oWins.contains("O wins");
        assertTrue(saysOWins);
    }

    @Test
    public void testAnnouncesTieGame() {
        String tieGame = messages.announceTieGame();
        boolean saysTieGame = tieGame.contains("Tie game!");
        assertTrue(saysTieGame);
    }

    @Test
    public void testDisplaysBoardLineForSideLength3() {
        String expectedBoardLine = "\n|----|----|----|\n";
        String actualBoardLine = messages.boardLine(3);
        assertEquals(expectedBoardLine, actualBoardLine);
    }

    @Test
    public void testDisplaysBoardLineForSideLength4() {
        String expectedBoardLine = "\n|----|----|----|----|\n";
        String actualBoardLine = messages.boardLine(4);
        assertEquals(expectedBoardLine, actualBoardLine);
    }

    @Test
    public void testInputError() {
        String inputError = messages.announceInputError();
        boolean announcesInputError = inputError.contains("Invalid input!");
        assertTrue(announcesInputError);
    }

}