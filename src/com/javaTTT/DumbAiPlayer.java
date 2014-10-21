package com.javaTTT;

import java.util.Random;

public class DumbAiPlayer extends Player {

    @Override
    public int getMove() {
        Random rand = new Random();
        return rand.nextInt(8);
    }
}
