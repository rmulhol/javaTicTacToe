package com.javaTTT;

import java.io.OutputStream;
import java.io.PrintStream;

public class MockPrintStream extends PrintStream {
    public MockPrintStream(OutputStream out) { super(out); }

    private boolean printlnWasCalled = false;
    private boolean printWasCalled = false;

    public void println(String string) { printlnWasCalled = true; }

    public void print(String string) { printWasCalled = true; }

    public boolean printlnWasCalled() { return printlnWasCalled; }

    public boolean printWasCalled() { return printWasCalled; }
}
