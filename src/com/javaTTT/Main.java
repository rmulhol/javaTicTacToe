package com.javaTTT;

import java.io.OutputStream;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {

        OutputStream outputStream = new RealOutputStream();
        PrintStream printStream = new RealPrintStream(outputStream);
        IO io = new IOImpl(printStream);
        Messages messages = new MessagesImpl();
        Display display = new DisplayImpl(io, messages);

        Configuration configureGame = new Configuration(display);
        Runner myGame = configureGame.chooseGameSetup();
        myGame.playGame();

    }

}