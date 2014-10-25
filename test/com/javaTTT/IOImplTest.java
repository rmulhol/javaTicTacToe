package com.javaTTT;

import org.testng.annotations.Test;

import java.io.OutputStream;

import static org.junit.Assert.*;

public class IOImplTest {

    OutputStream mockOutputStream = new MockOutputStream();
    MockPrintStream mockPrintStream = new MockPrintStream(mockOutputStream);
    IO testIO = new IOImpl(mockPrintStream);

    @Test
    public void testPrintLineCallsPrintln() {
        testIO.printLine("test");
        boolean printlnWasCalled = mockPrintStream.printlnWasCalled();
        assertTrue(printlnWasCalled);
    }

    @Test
    public void testPrintNoLineCallsPrint() {
        testIO.printNoLine("test");
        boolean printWasCalled = mockPrintStream.printWasCalled();
        assertTrue(printWasCalled);
    }

    // Test getInput()

}