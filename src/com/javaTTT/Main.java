package com.javaTTT;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Display display = new DisplayImpl();
        Board board = new BoardImpl();
        Player player1 = new PlayerImpl();
        Player player2 = new PlayerImpl();

        Runner newGame = new Runner(display, board, player1, player2);
        newGame.playGame();

    }
}