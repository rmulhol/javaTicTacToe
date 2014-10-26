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
        displayBoardWithIndexes(gameBoard.size());
        displayBoard(gameBoard);
        while(!gameOver()) {
            moveSequence(player1);
            if(gameOver()) { break; }
            moveSequence(player2);
        }
        announceWinner();
    }

    void moveSequence(Player player) {
        int move = getPlayerMove(player);
        while(!playerMoveIsValid(move)) {
            move = getPlayerMove(player);
        }
        setMove(move);
        HashMap myBoard = getBoard();
        displayBoard(myBoard);
    }

    void introduceGame() { display.introduceGame(); }

    HashMap getBoard() { return board.getBoard(); }

    void displayBoard(HashMap board) { display.displayBoard(board); }

    void displayBoardWithIndexes(int boardSize) { display.displayBoardWithIndexes(boardSize);}

    void setMove(int move) {
        counter++;
        if(counter % 2 == 1) board.setMove(board.board, move, player1Move);
        else board.setMove(board.board, move, player2Move);
    }

    void announceWinner() {
        if(playerWins(player1Move)) announcePlayerWin(player1Move);
        else if(playerWins(player2Move)) announcePlayerWin(player2Move);
        else if(tieGame()) announceTieGame();
    }

    void announcePlayerWin(String playerMove) { display.announcePlayerWin(playerMove); }

    void announceTieGame() { display.announceTieGame(); }

    int getPlayerMove(Player player) { return player.getMove(board.board, player1Move, player2Move); }

    boolean playerMoveIsValid(int move) { return board.moveIsValid(board.board, move); }

    boolean playerWins(String playerMove) { return board.playerWins(board.board, playerMove); }

    boolean tieGame() { return board.tieGame(board.board); }

    boolean gameOver() { return board.gameOver(board.board, player1Move, player2Move); }
}