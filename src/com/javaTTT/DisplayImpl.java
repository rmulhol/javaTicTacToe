package com.javaTTT;

import java.util.HashMap;

public class DisplayImpl extends Display {
    Board board;
    int boardLength;
    int boardSize;

    DisplayImpl(Board board) {
        this.board = board;
        this.boardLength = board.boardLength;
        this.boardSize = board.boardSize;
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

    @Override
    public void displayBoard(HashMap boardHashMap) {
        printBoardLine();
        for(int i=0; i<boardLength; i++) {
                printNoLine("|  " + boardHashMap.get(i) + " ");
            if (i % boardSize == boardSize - 1) {
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
        for(int i=0; i<boardSize; i++) {
            System.out.print("|----");
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
            if (i % boardSize == boardSize - 1) {
                printLine("|");
                printBoardLine();
            }
        }
        printLine("");
    }

    private void printLine(String string) {
        System.out.println(string);
    }

    private void printNoLine(String string) {
        System.out.print(string);
    }
}
