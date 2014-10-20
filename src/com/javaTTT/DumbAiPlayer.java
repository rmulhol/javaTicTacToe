package com.javaTTT;

import java.util.Random;

/**
 * Created by robertmulholand on 10/19/14.
 */
public class DumbAiPlayer extends Player {
    private int[] spaces = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
    private int index = 8;

    private int pop() {
        return spaces[index--];
    }

    @Override
    public String getMove() {
        Random rand = new Random();
        int move = rand.nextInt(8);
        return Integer.toString(move);
    }
}
