package com.javaTTT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by robertmulholand on 10/19/14.
 */
public class HumanPlayer extends Player {
    @Override
    public String getMove() {
        System.out.println("Enter your move: ");
        String move = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            move = br.readLine();
        } catch (IOException e) {
            System.err.println("Invalid input! Please enter a valid move (unoccupied index between 0-8)!");
        }
        return move;
    }
}


