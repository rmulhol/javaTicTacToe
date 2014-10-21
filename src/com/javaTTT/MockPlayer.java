package com.javaTTT;

public class MockPlayer extends Player {

    boolean getMoveCalled = false;

    @Override
    public int getMove(String player1Move, String player2Move) {
        getMoveCalled = true;
        return 0;
    }

    boolean getMoveCalled() { return getMoveCalled; }

}
