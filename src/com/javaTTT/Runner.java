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
        int move = getPlayer1Move();
        while(!spaceAvailable(move) || !spaceInRange(move)) {
            move = getPlayer1Move();
        }
        setMove(move);
        HashMap myBoard = getBoard();
        displayBoard(myBoard);
    }

    public void setPlayer2Move() {
        int move = getPlayer2Move();
        while(!spaceAvailable(move) || !spaceInRange(move)) {
            move = getPlayer2Move();
        }
        setMove(move);
        HashMap myBoard = getBoard();
        displayBoard(myBoard);
    }

    public void introduceGame() { display.introduceGame(); }

    public HashMap getBoard() { return board.getBoard(); }

    public void displayBoard(HashMap board) { display.displayBoard(board); }

    public void setMove(int move) {
        counter++;
        if(counter % 2 == 1) board.setMove(board.board, move, player1Move);
        else board.setMove(board.board, move, player2Move);
    }

    public void announceWinner() {
        if(player1Wins()) announceWinForPlayer(player1Move);
        else if(player2Wins()) announceWinForPlayer(player2Move);
        else if(tieGame()) announceTieGame();
    }

    public void announceWinForPlayer(String playerMove) { display.announceWinForPlayer(playerMove); }

    public void announceTieGame() { display.announceTieGame(); }

    public int getPlayer1Move() { return player1.getMove(player1Move, player2Move); }

    public int getPlayer2Move() { return player2.getMove(player1Move, player2Move); }

    public boolean spaceAvailable(int move) { return board.spaceAvailable(board.board, move); }

    public boolean spaceInRange(int move) { return board.spaceInRange(board.boardSize, move); }

    public boolean player1Wins() { return board.playerWins(board.board, player1Move); }

    public boolean player2Wins() { return board.playerWins(board.board, player2Move); }

    public boolean tieGame() { return board.tieGame(board.board); }

    public boolean gameOver() { return board.gameOver(board.board, player1Move, player2Move); }
}