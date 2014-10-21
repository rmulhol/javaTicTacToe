package com.javaTTT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Configuration {
    public String chooseGameType() {
        System.out.println("How do you want to play? Enter 0 for Human vs Human, 1 for Human vs (Dumb) Computer, or 2 for Human vs (Less Dumb) Computer.");
        String gameType = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            gameType = br.readLine();
        } catch (IOException e) {
            System.err.println("Invalid input! Please enter a valid move (unoccupied index between 0-8)!");
        }
        return gameType;
    }

}
