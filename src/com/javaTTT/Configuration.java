package com.javaTTT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by robertmulholand on 10/19/14.
 */
public class Configuration {
    public int chooseGameType() {
        System.out.println("How do you want to play? Enter 0 for Human vs Human, or 1 for Human vs Computer.");
        String gameType = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            gameType = br.readLine();
        } catch (IOException e) {
            System.err.println("Invalid input! Please enter a valid move (unoccupied index between 0-8)!");
        }
        return Integer.parseInt(gameType);
    }

}
