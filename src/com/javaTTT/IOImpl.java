package com.javaTTT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class IOImpl extends IO {
    PrintStream printStream;

    IOImpl(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    void printLine(String string) {
        printStream.println(string);
    }

    @Override
    void printNoLine(String string) {
        printStream.print(string);
    }

    @Override
    String getInput() {
        String input = "";
        BufferedReader newBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = newBufferedReader.readLine();
        } catch (IOException e) {
            System.err.println("Invalid input! Please enter a valid move (unoccupied index between 0-8)!");
        }
        return input;
    }

}
