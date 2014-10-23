package com.javaTTT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {
    Display display;
    Board board;
    int boardSize;

    HumanPlayer(Display display, Board board) {
        this.display = display;
        this.board = board;
        boardSize = board.boardSize;

    }

    @Override
    public int getMove(String player1Move, String player2Move) {
        System.out.println("Enter your move: ");
        return display.getValidInteger(boardSize - 1);
    }
}


