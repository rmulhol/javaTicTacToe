package com.javaTTT;

import java.util.HashMap;

public class Runner {

    private Display display;
    private Board board;
    private Player player1;
    private Player player2;
    private int counter = 0;
    private String player1Move;
    private String player2Move;

    Runner(Display display, Board board, Player player1, Player player2) {
        this.display = display;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        player1Move = player1.getMoveSignature();
        player2Move = player2.getMoveSignature();
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

    void setPlayer1Move() {
        int move = getPlayerMove(player1);
        while(!playerMoveIsValid(move)) {
            move = getPlayerMove(player1);
        }
        setMove(move);
        HashMap myBoard = getBoard();
        displayBoard(myBoard);
    }

    void setPlayer2Move() {
        int move = getPlayerMove(player2);
        while(!playerMoveIsValid(move)) {
            move = getPlayerMove(player2);
        }
        setMove(move);
        HashMap myBoard = getBoard();
        displayBoard(myBoard);
    }

    void introduceGame() { display.introduceGame(); }

    HashMap getBoard() { return board.getBoard(); }

    void displayBoard(HashMap board) { display.displayBoard(board); }

    void setMove(int move) {
        counter++;
        if(counter % 2 == 1) board.setMove(board.board, move, player1Move);
        else board.setMove(board.board, move, player2Move);
    }

    void announceWinner() {
        if(player1Wins()) announceWinForPlayer(player1Move);
        else if(player2Wins()) announceWinForPlayer(player2Move);
        else if(tieGame()) announceTieGame();
    }

    void announceWinForPlayer(String playerMove) { display.announceWinForPlayer(playerMove); }

    void announceTieGame() { display.announceTieGame(); }

    int getPlayerMove(Player player) { return player.getMove(player1Move, player2Move); }

    boolean playerMoveIsValid(int move) { return spaceAvailable(move) && spaceInRange(move); }

    boolean spaceAvailable(int move) { return board.spaceAvailable(board.board, move); }

    boolean spaceInRange(int move) { return board.spaceInRange(board.boardSize, move); }

    boolean player1Wins() { return board.playerWins(board.board, player1Move); }

    boolean player2Wins() { return board.playerWins(board.board, player2Move); }

    boolean tieGame() { return board.tieGame(board.board); }

    boolean gameOver() { return board.gameOver(board.board, player1Move, player2Move); }
}