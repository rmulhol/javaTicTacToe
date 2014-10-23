package com.javaTTT;

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
}
