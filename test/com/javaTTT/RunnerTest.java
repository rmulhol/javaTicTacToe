package com.javaTTT;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class RunnerTest {

    private MockDisplay mockDisplay = new MockDisplay();
    private MockBoard mockBoard = new MockBoard();
    private MockPlayer mockPlayer1 = new MockPlayer();
    private MockPlayer mockPlayer2 = new MockPlayer();

    private Runner newGame = new Runner(mockDisplay, mockBoard, mockPlayer1, mockPlayer2);

    // Test playGame()

    // Test moveSequence()

    @Test
    public void testIntroduceGame() {
        newGame.introduceGame();
        boolean displayCalled = mockDisplay.verifyIntroduceGameCalled();
        assertTrue(displayCalled);
    }

    @Test
    public void testGetBoard() {
        newGame.getBoard();
        boolean boardCalled = mockBoard.verifyGetBoardCalled();
        assertTrue(boardCalled);
    }

    @Test
    public void testDisplayBoard() {
        HashMap emptyBoard = new HashMap();
        newGame.displayBoard(emptyBoard);
        boolean displayCalled = mockDisplay.verifyDisplayBoardCalled();
        assertTrue(displayCalled);
    }

    @Test
    public void testDisplayBoardWithIndexes() {
        newGame.displayBoardWithIndexes(9);
        boolean displayCalled = mockDisplay.verifyDisplayBoardWithIndexesCalled();
        assertTrue(displayCalled);
    }

    @Test
    public void testSetMove() {
        newGame.setMove(1);
        boolean boardCalled = mockBoard.verifySetMoveCalled();
        assertTrue(boardCalled);
    }

    // test announceWinner

    @Test
    public void testAnnouncePlayerWin() {
        newGame.announcePlayerWin("X");
        boolean displayCalled = mockDisplay.verifyAnnouncePlayerWinCalled();
        assertTrue(displayCalled);
    }

    @Test
    public void testAnnounceTieGame() {
        newGame.announceTieGame();
        boolean displayCalled = mockDisplay.verifyAnnounceTieGameCalled();
        assertTrue(displayCalled);
    }

    @Test
    public void testGetPlayerMove() {
        newGame.getPlayerMove(mockPlayer1);
        boolean playerCalled = mockPlayer1.verifyGetMoveCalled();
        assertTrue(playerCalled);
    }

    @Test
    public void testPlayerMoveIsValid() {
        newGame.playerMoveIsValid(1);
        boolean boardCalled = mockBoard.verifyMoveIsValidCalled();
        assertTrue(boardCalled);
    }

    @Test
    public void testPlayerWins() {
        newGame.playerWins("X");
        boolean boardCalled = mockBoard.verifyPlayerWinsCalled();
        assertTrue(boardCalled);
    }

    @Test
    public void testTieGame() {
        newGame.tieGame();
        boolean boardCalled = mockBoard.verifyTieGameCalled();
        assertTrue(boardCalled);
    }

    @Test
    public void testGameOver() {
        newGame.gameOver();
        boolean boardCalled = mockBoard.verifyGameOverCalled();
        assertTrue(boardCalled);
    }

}