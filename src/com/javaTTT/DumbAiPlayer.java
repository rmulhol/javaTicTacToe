package com.javaTTT;

import java.util.HashMap;
import java.util.Random;

public class DumbAiPlayer extends Player {
    Board board;
    String moveSignature;

    public DumbAiPlayer(Board boardObject, String moveSignature) {
        this.board = boardObject;
        this.moveSignature = moveSignature;
    }

    @Override
    public int getMove(HashMap board,String player1Move, String player2Move) {
        Random rand = new Random();
        return rand.nextInt(8);
    }

    @Override
    String getMoveSignature() {
        return moveSignature;
    }
}
