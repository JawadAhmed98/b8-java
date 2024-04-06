package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAppConstructor() {
        try {
            new App();
        } catch (Exception e) {
            fail("Construction failed.");
        }
    }

    @Test
    public void testAppMain() {
        App.main(null);
        String expectedOutput = "Hello World!!" + System.getProperty("line.separator");
        assertEquals("Output doesn't match expected", expectedOutput, outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
