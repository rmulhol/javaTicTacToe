package com.javaTTT;

import java.util.HashMap;

public class HumanPlayer extends Player {
    Display display;
    String moveSignature;

    // this class depends on Display

    HumanPlayer(Display display, String moveSignature) {
        this.display = display;
        this.moveSignature = moveSignature;
    }

    @Override
    public int getMove(HashMap board, String player1Move, String player2Move) {
        System.out.println("Enter your move: ");
        return display.getValidInteger("(|[0-9])[0-9]");
    }

    @Override
    String getMoveSignature() {
        return moveSignature;
    }
}


