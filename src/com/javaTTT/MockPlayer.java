package com.javaTTT;

import java.util.HashMap;

public class MockPlayer extends Player {

    boolean getMoveCalled = false;

    @Override
    public int getMove(HashMap board, String player1Move, String player2Move) {
        getMoveCalled = true;
        return 0;
    }

    @Override
    String getMoveSignature() {
        return null;
    }

    boolean verifyGetMoveCalled() { return getMoveCalled; }

}
