package com.javaTTT;

import java.util.HashMap;

public class Runner {

    private Display display;
    private Board board;
    private Player player1;
    private Player player2;
    private int counter = 0;
    private String player1Move = "X";
    private String player2Move = "O";

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

    public void introduceGame() { display.introduceGame(); }

    public HashMap getBoard() { return board.getBoard(); }

    public void displayBoard(HashMap boardArray) { display.displayBoard(boardArray); }

    public void setMove(String move) {
        int moveToPlace = Integer.parseInt(move);
        counter++;
        if(counter % 2 == 1) board.setMove(moveToPlace, player1Move);
        else board.setMove(moveToPlace, player2Move);
    }

    public void announceWinner() {
        if(player1Wins()) announceWinForPlayer1();
        else if(player2Wins()) announceWinForPlayer2();
        else if(tieGame()) announceTieGame();
    }

    public void announceWinForPlayer1() { display.announceWinForPlayer1(player1Move); }

    public void announceWinForPlayer2() { display.announceWinForPlayer2(player2Move); }

    public void announceTieGame() { display.announceTieGame(); }

    public String getPlayer1Move() { return player1.getMove(); }

    public String getPlayer2Move() { return player2.getMove(); }

    public boolean spaceAvailable(String move) {
        int moveToPlace = Integer.parseInt(move);
        return board.spaceAvailable(moveToPlace);
    }

    public boolean player1Wins() { return board.playerWins(player1Move); }

    public boolean player2Wins() { return board.playerWins(player2Move); }

    public boolean tieGame() { return board.tieGame(); }

    public boolean gameOver() { return board.gameOver(player1Move, player2Move); }
}