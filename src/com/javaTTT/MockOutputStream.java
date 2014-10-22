package com.javaTTT;

import java.io.IOException;
import java.io.OutputStream;

public class MockOutputStream extends OutputStream {
    boolean writeWasCalled;

    @Override
    public void write(int b) throws IOException {
        writeWasCalled = true;
    }
}
