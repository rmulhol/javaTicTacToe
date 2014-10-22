package com.javaTTT;

import java.io.OutputStream;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {

        Configuration chooseGameType = new Configuration();
        Board board = new BoardImpl(3);
        OutputStream outputStream = new RealOutputStream();
        PrintStream printStream = new RealPrintStream(outputStream);
        Display display = new DisplayImpl(printStream, board);
        Player player1 = new HumanPlayer();
        Player player2;

        display.introduceGame();
        String gameType = chooseGameType.chooseGameType();

        if(!gameType.equals("0") && !gameType.equals("1") && !gameType.equals("2")) {
            display.announceGameWillNotBegin();
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