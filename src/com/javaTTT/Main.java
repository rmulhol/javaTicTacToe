package com.javaTTT;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Configuration chooseGameType = new Configuration();
        Board board = new BoardImpl(3);
        Display display = new DisplayImpl(board);
        Player player1 = new HumanPlayer();
        Player player2;

        display.introduceGame();
        String gameType = chooseGameType.chooseGameType();

        if(!gameType.equals("0") && !gameType.equals("1") && !gameType.equals("2")) {
            System.out.println("Sorry, this game is only configured for HvH or HvC play.");
            System.out.println("You must enter 0, 1, or 2 to select one of those options.");
            System.out.println("Since you did not, this game will now close. Goodbye.");
        } else if(gameType.equals("2")) {
            player2 = new SmartAiPlayer(board);
            Runner newGame = new Runner(display, board, player1, player2);
            newGame.playGame();
        } else if(gameType.equals("1")) {
            player2 = new DumbAiPlayer(board);
            Runner newGame = new Runner(display, board, player1, player2);
            newGame.playGame();
        } else if(gameType.equals("0")) {
            player2 = new HumanPlayer();
            Runner newGame = new Runner(display, board, player1, player2);
            newGame.playGame();
        }


    }
}