package com.javaTTT;

import java.util.HashMap;

public class DisplayImpl extends Display {
    @Override
    void introduceGame() {
        System.out.println("Hello, welcome to tic tac toe.");
        System.out.println();
        System.out.println("For this game, the spaces are indexed as shown here:");
        System.out.println();
        System.out.println("|---|---|---|");
        System.out.println("| 0 | 1 | 2 |");
        System.out.println("|---|---|---|");
        System.out.println("| 3 | 4 | 5 |");
        System.out.println("|---|---|---|");
        System.out.println("| 6 | 7 | 8 |");
        System.out.println("|---|---|---|");
        System.out.println();
        System.out.println("Please note that you can only choose an open space, and you must enter a valid integer to do so.");
        System.out.println();
        System.out.println("Let's get started!");
        System.out.println();
    }

    @Override
    public void displayBoard(HashMap boardHashMap) {
        int counter = 0;
        System.out.println("|---|---|---|");
        for(int i=0; i<9; i++) {
            if (boardHashMap.get(i) == " ") {
                System.out.print("|   ");
            } else if (boardHashMap.get(i) == "X") {
                System.out.print("| X ");
            } else if (boardHashMap.get(i) == "O") {
                System.out.print("| O ");
            }
            counter++;
            if (counter % 3 == 0) {
                System.out.println("|");
                System.out.println("|---|---|---|");
            }
        }
        System.out.println();
    }

    @Override
    void announceWinForX() {
        System.out.println();
        System.out.println("Player X wins the game! Thanks for playing!");
    }

    @Override
    void announceWinForO() {
        System.out.println();
        System.out.println("Player O wins the game! Thanks for playing!");
    }

    @Override
    void announceTieGame() {
        System.out.println();
        System.out.println("Tie game! Thanks for playing!");
    }
}
