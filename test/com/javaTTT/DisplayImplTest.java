package com.javaTTT;

import org.testng.annotations.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertTrue;

public class DisplayImplTest {

    OutputStream mockOutputStream = new MockOutputStream();
    MockPrintStream mockPrintStream = new MockPrintStream(mockOutputStream);
    Board mockBoard = new MockBoard();
    Display testDisplay = new DisplayImpl(mockPrintStream, mockBoard);

    @Test
    public void testPrintLineCallsPrintln() {
        testDisplay.printLine("test");
        boolean printlnWasCalled = mockPrintStream.printlnWasCalled();
        assertTrue(printlnWasCalled);
    }

    @Test
    public void testPrintNoLineCallsPrint() {
        testDisplay.printNoLine("test");
        boolean printWasCalled = mockPrintStream.printWasCalled();
        assertTrue(printWasCalled);
    }

}