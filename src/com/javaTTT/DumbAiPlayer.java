package com.javaTTT;

import java.util.Random;

public class DumbAiPlayer extends Player {
    Board board;

    public DumbAiPlayer(Board board) {
        this.board = board;
    }

    @Override
    public int getMove(String player1Move, String player2Move) {
        Random rand = new Random();
        return rand.nextInt(8);
    }
}
