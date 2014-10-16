package com.javaTTT;

/**
 * Created by robertmulholand on 10/10/14.
 */
public class Runner {

    private Display display;
    private Board board;
    private Player player;

    Runner(Display display, Board board, Player player) {
        this.display = display;
        this.board = board;
        this.player = player;
    }

    public void playGame() {
        int[] newBoard = getBoard();
        displayBoard(newBoard);
        while(!gameOver()) {
            String move = getMove();
            if(spaceAvailable(move)) {
                setMove(move);
                newBoard = getBoard();
                displayBoard(newBoard);
            } else {
                System.out.println("Invalid input!");
            }
        }
        if(board.xWins()) {
            System.out.println("Player X wins the game!");
        } else if(board.oWins()) {
            System.out.println("Player O wins the game!");
        }
        System.out.println("Thanks for playing!");
    }

    public int[] getBoard() {
        return board.getBoard();
    }

    public void displayBoard(int[] boardArray) {
        display.displayBoard(boardArray);
    }

    public String getMove() {
        return player.getMove();
    }

    public boolean spaceAvailable(String move) {
        return board.checkSpaceAvailability(move);
    }

    public void setMove(String move) {
        board.addPlayerMove(move);
    }

    public boolean gameOver() {
        return board.gameOver();
    }
}
