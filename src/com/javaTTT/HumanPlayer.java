package com.javaTTT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {
    Display display;

    // this class depends on Display

    HumanPlayer(Display display) {
        this.display = display;

    }

    @Override
    public int getMove(String player1Move, String player2Move) {
        System.out.println("Enter your move: ");
        return display.getValidInteger("(|[0-9])[0-9]");
    }
}


