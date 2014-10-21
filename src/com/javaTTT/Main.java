package com.javaTTT;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Configuration chooseGameType = new Configuration();
        Display display = new DisplayImpl();
        Board board = new BoardImpl(3);
        Player player1 = new HumanPlayer();
        Player player2;

        display.introduceGame();
        int gameType = chooseGameType.chooseGameType();

        if(gameType == 0) {
            player2 = new HumanPlayer();
            Runner newGame = new Runner(display, board, player1, player2);
            newGame.playGame();
        } else if(gameType == 1) {
            player2 = new DumbAiPlayer();
            Runner newGame = new Runner(display, board, player1, player2);
            newGame.playGame();
        } else {
            System.out.println("Sorry, this game is only configured for HvH or HvC play.");
            System.out.println("You must enter 0 or 1 to select one of those options.");
            System.out.println("Since you did not, this game will now close. Goodbye.");
        }



    }
}