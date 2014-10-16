package com.javaTTT;

/**
 * Created by robertmulholand on 10/16/14.
 */
public class DisplayImpl extends Display {
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
}
