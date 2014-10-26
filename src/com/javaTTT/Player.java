package com.javaTTT;

import java.util.HashMap;

abstract class Player {

    String moveSignature;

    // parameters only useful for smart ai player at this point
    abstract int getMove(HashMap board, String player1Move, String player2Move);

    abstract String getMoveSignature();

}
