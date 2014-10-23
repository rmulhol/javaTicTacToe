package com.javaTTT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Configuration {

    Display display;

    Configuration(Display display) {
        this.display = display;
    }

    public Runner chooseGameSetup() {
        display.introduceGame();

        // asks if user want to modify default configuration
        String modifySettings = "";
        BufferedReader settings = new BufferedReader(new InputStreamReader(System.in));
        try {
            modifySettings = settings.readLine();
        } catch (IOException e) {
            System.err.println("Invalid input!");
        }

        if(!modifySettings.equals("y")) {

            // runs default game setup if user input != "y"
            Board board = new BoardImpl(3);
            Player humanPlayer = new HumanPlayer(display, board);
            Player smartAiPlayer = new SmartAiPlayer(board);
            return new Runner(display, board, humanPlayer, smartAiPlayer);

        } else {

            // constructs board according to user input, looping for valid input
            display.getBoardSize();
            int boardSideLength = display.getValidInteger("[3-9]");
            Board board = new BoardImpl(boardSideLength);

            // constructs player 1 according to user input, looping for valid input
            display.getPlayerIdentity(1);
            int player1Identity = display.getValidInteger("[1-3]");
            Player player1 = createPlayer(player1Identity, board);

            // constructs player 2 according to user input, looping for valid input
            display.getPlayerIdentity(2);
            int player2Identity = display.getValidInteger("[1-3]");
            Player player2 = createPlayer(player2Identity, board);

            return new Runner(display, board, player1, player2);
        }
    }

    Player createPlayer(int i, Board board) {
        if(i == 1) {
            return new HumanPlayer(display, board);
        } else if(i == 2) {
            return new DumbAiPlayer(board);
        } else {
            return new SmartAiPlayer(board);
        }
    }

}