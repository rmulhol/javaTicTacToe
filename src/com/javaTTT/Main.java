package com.javaTTT;

import java.io.OutputStream;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {

        Configuration chooseGameType = new Configuration();
        Board board = new BoardImpl(3);
        OutputStream outputStream = new RealOutputStream();
        PrintStream printStream = new RealPrintStream(outputStream);
        IO io = new IOImpl(printStream);
        Messages messages = new MessagesImpl();
        Display display = new DisplayImpl(io, messages, board);
        Player player1 = new HumanPlayer();
        Player player2;

        display.introduceGame();
        player2 = chooseGameType.chooseGameType(board);
        display.displayBoardWithIndexes(board.boardLength);
        Runner newGame = new Runner(display, board, player1, player2);
        newGame.playGame();


    }

}