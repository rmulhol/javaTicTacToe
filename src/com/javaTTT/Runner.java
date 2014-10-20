package com.javaTTT;

/**
 * Created by robertmulholand on 10/10/14.
 */
public class Runner {

    private Display display;
    private Board board;
    private Player player1;
    private Player player2;

    Runner(Display display, Board board, Player player1, Player player2) {
        this.display = display;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playGame() {
        int[] gameBoard = getBoard();
        displayBoard(gameBoard);
        while(!gameOver()) {
            setPlayer1Move(gameBoard);
            if(gameOver()) { break; }
            setPlayer2Move(gameBoard);
        }
        announceWinner();
    }

    public void setPlayer1Move(int[] myBoard) {
        String move = getPlayer1Move();
        while(!spaceAvailable(move)) {
            move = getPlayer1Move();
        }
        setMove(move);
        myBoard = getBoard();
        displayBoard(myBoard);
    }

    public void setPlayer2Move(int[] myBoard) {
        String move = getPlayer2Move();
        while(!spaceAvailable(move)) {
            move = getPlayer2Move();
        }
        setMove(move);
        myBoard = getBoard();
        displayBoard(myBoard);
    }

    public void announceWinner() {
        if(xWins()) announceWinForX();
        else if(oWins()) announceWinForO();
        else if(tieGame()) announceTieGame();
    }

    public void introduceGame() { display.introduceGame(); }

    public int[] getBoard() {
        return board.getBoard();
    }

    public void displayBoard(int[] boardArray) {
        display.displayBoard(boardArray);
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
        return board.checkSpaceAvailability(move);
    }

    public void setMove(String move) {
        board.addPlayerMove(move);
    }

    public boolean gameOver() {
        return board.gameOver();
    }

    public boolean xWins() {
        return board.xWins();
    }

    public boolean oWins() {
        return board.oWins();
    }

    public boolean tieGame() { return board.tieGame(); }
}