package com.javaTTT;

import java.io.OutputStream;
import java.io.PrintStream;

public class RealPrintStream extends PrintStream {
    public RealPrintStream(OutputStream out) { super(out); }

    public void println(String string) { System.out.println(string); }

    public void print(String string) { System.out.print(string); }
}
