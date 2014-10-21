package com.javaTTT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {
    @Override
    public int getMove(String player1Move, String player2Move) {
        System.out.println("Enter your move: ");
        String move = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            move = br.readLine();
        } catch (IOException e) {
            System.err.println("Invalid input! Please enter a valid move (unoccupied index between 0-8)!");
        }
        return Integer.parseInt(move);
    }
}


