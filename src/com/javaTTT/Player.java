package com.javaTTT;

abstract class Player {

    String moveSignature;

    // parameters only useful for smart ai player at this point
    abstract int getMove(String player1Move, String player2Move);

    abstract String getMoveSignature();

}
