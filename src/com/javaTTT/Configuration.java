package com.javaTTT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Configuration {
    public Player chooseGameType(Board board) {
        Player player2 = null;
        System.out.println("How do you want to play? Enter 0 for Human vs Human, 1 for Human vs (Dumb) Computer, or 2 for Human vs (Less Dumb) Computer.");
        String gameType = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            gameType = br.readLine();
        } catch (IOException e) {
            System.err.println("Invalid input! Please enter a valid move (unoccupied index between 0-8)!");
        }
        if(!gameType.equals("0") && !gameType.equals("1") && !gameType.equals("2")) {
            System.out.println("Sorry, didn't understand that. Since you didn't enter 0, 1, or 2, I'm starting" +
            " the game with you playing against the less dumb AI player.");
            player2 = new SmartAiPlayer(board);
        } else if(gameType.equals("2")) {
            player2 = new SmartAiPlayer(board);
        } else if(gameType.equals("1")) {
            player2 = new DumbAiPlayer(board);
        } else {
            player2 = new HumanPlayer();
        }
        return player2;
    }

}
