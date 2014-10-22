package com.javaTTT;

import java.io.PrintStream;
import java.util.HashMap;

public class DisplayImpl extends Display {
    Board board;
    int boardLength;
    int boardSideLength;
    PrintStream printStream;

    DisplayImpl(PrintStream printStream, Board board) {
        this.printStream = printStream;
        this.board = board;
        this.boardLength = board.boardLength;
        this.boardSideLength = board.boardSideLength;
    }

    @Override
    void introduceGame() {
        printLine("Hello, welcome to tic tac toe.");
        printLine("");
        printLine("For this game, the spaces are indexed as shown here:");
        printLine("");
        printBoardIndexes();
        printLine("");
        printLine("Please note that you can only choose an open space, and you must enter a valid integer to do so.");
        printLine("");
        printLine("Let's get started!");
        printLine("");
    }

    void announceGameWillNotBegin() {
        printLine("Sorry, this game is only configured for HvH or HvC play.");
        printLine("You must enter 0, 1, or 2 to select one of those options.");
        printLine("Since you did not, this game will now close. Goodbye.");
    }

    @Override
    public void displayBoard(HashMap boardHashMap) {
        printBoardLine();
        for(int i=0; i<boardLength; i++) {
                printNoLine("|  " + boardHashMap.get(i) + " ");
            if (i % boardSideLength == boardSideLength - 1) {
                printLine("|");
                printBoardLine();
            }
        }
        printLine("");
    }

    @Override
    void announceWinForPlayer1(String player1Move) {
        printLine("");
        printLine("Player " + player1Move + " wins the game! Thanks for playing!");
    }

    @Override
    void announceWinForPlayer2(String player2Move) {
        printLine("");
        printLine("Player " + player2Move + " wins the game! Thanks for playing!");
    }

    @Override
    void announceTieGame() {
        printLine("");
        printLine("Tie game! Thanks for playing!");
    }

    private void printBoardLine() {
        for(int i=0; i<boardSideLength; i++) {
            printNoLine("|----");
        }
        printLine("|");
    }

    private void printBoardIndexes() {
        printBoardLine();
        for(int i=0; i<boardLength; i++) {
            if(i > 9) {
                printNoLine("| " + i + " ");
            } else {
                printNoLine("|  " + i + " ");
            }
            if (i % boardSideLength == boardSideLength - 1) {
                printLine("|");
                printBoardLine();
            }
        }
        printLine("");
    }

    public void printLine(String string) { printStream.println(string); }

    public void printNoLine(String string) { printStream.print(string); }
}
