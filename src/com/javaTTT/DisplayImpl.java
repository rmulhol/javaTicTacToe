package com.javaTTT;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by robertmulholand on 10/16/14.
 */
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
    public void displayBoard(int[] boardArray) {
        int counter = 0;
        System.out.println("|---|---|---|");
        for(int space : boardArray) {
            if (space == 0) {
                System.out.print("|   ");
            } else if (space % 2 == 0) {
                System.out.print("| X ");
            } else if (space % 2 == 1) {
                System.out.print("| O ");
            }
            counter++;
            if (counter % 3 == 0) {
                System.out.println("|");
                System.out.println("|---|---|---|");
            }
        }
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
