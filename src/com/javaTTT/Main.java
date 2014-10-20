package com.javaTTT;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Configuration chooseGameType = new Configuration();
        Display display = new DisplayImpl();
        Board board = new BoardImpl(3);
        Player player1 = new HumanPlayer();
        Player player2 = null;

        display.introduceGame();
        int gameType = chooseGameType.chooseGameType();

        if(gameType == 0) {
            player2 = new HumanPlayer();
        } else if(gameType == 1) {
            player2 = new DumbAiPlayer();
        }

        Runner newGame = new Runner(display, board, player1, player2);
        newGame.playGame();

    }
}