package com.javaTTT;

import java.util.Random;

/**
 * Created by robertmulholand on 10/19/14.
 */
public class DumbAiPlayer extends Player {

    @Override
    public String getMove() {
        Random rand = new Random();
        int move = rand.nextInt(8);
        return Integer.toString(move);
    }
}
