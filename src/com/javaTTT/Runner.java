package com.javaTTT;

import java.util.HashMap;

public class Runner {

    private Display display;
    private Board board;
    private Player player1;
    private Player player2;
    private int counter = 0;

    Runner(Display display, Board board, Player player1, Player player2) {
        this.display = display;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playGame() {
        HashMap gameBoard = getBoard();
        displayBoard(gameBoard);
        while(!gameOver()) {
            setPlayer1Move();
            if(gameOver()) { break; }
            setPlayer2Move();
        }
        announceWinner();
    }

    public void setPlayer1Move() {
        String move = getPlayer1Move();
        while(!spaceAvailable(move)) {
            move = getPlayer1Move();
        }
        setMove(move);
        HashMap myBoard = getBoard();
        displayBoard(myBoard);
    }

    public void setPlayer2Move() {
        String move = getPlayer2Move();
        while(!spaceAvailable(move)) {
            move = getPlayer2Move();
        }
        setMove(move);
        HashMap myBoard = getBoard();
        displayBoard(myBoard);
    }

    public boolean gameOver() {
        return xWins() || oWins() || tieGame();
    }

    public void introduceGame() { display.introduceGame(); }

    public HashMap getBoard() {
        return board.getBoard();
    }

    public void displayBoard(HashMap boardArray) {
        display.displayBoard(boardArray);
    }

    public void setMove(String move) {
        int moveToPlace = Integer.parseInt(move);
        counter++;
        if(counter % 2 == 1) board.setMove(moveToPlace, "X");
        else board.setMove(moveToPlace, "O");
    }

    public void announceWinner() {
        if(xWins()) announceWinForX();
        else if(oWins()) announceWinForO();
        else if(tieGame()) announceTieGame();
    }

    public void announceWinForX() {
        display.announceWinForX();
    }

    public void announceWinForO() {
        display.announceWinForO();
    }

    public void announceTieGame() { display.announceTieGame(); }

    public String getPlayer1Move() {
        return player1.getMove();
    }

    public String getPlayer2Move() {
        return player2.getMove();
    }

    public boolean spaceAvailable(String move) {
        int moveToPlace = Integer.parseInt(move);
        return board.spaceAvailable(moveToPlace);
    }

    public boolean xWins() {
        return board.playerWins("X");
    }

    public boolean oWins() {
        return board.playerWins("O");
    }

    public boolean tieGame() { return board.tieGame(); }
}