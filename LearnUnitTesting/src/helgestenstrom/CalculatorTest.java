package helgestenstrom;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

import static org.junit.Assert.*;

//import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void evaluate() throws Exception {
        Calculator c = new Calculator();
        int sum = c.evaluate("1+2+3");
        assertEquals(6,sum);
    }

    @Test
    public void anotherTest() {
        assertEquals(3, 3);
    }

    @Test
    public void userInputWithInputStream() {
        // From https://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input

        // Setup test
        ByteArrayInputStream in = new ByteArrayInputStream("11 12 13 14 5 My string".getBytes());
        System.setIn(in);

        // Exercise
        int anInt = Main.testUserInput();
        assertEquals( anInt, 5);

        // tear down
        System.setIn(System.in);

    }


    // Test that the expected exeption is thrown.
    @Test(expected = InputMismatchException.class)
    public void illegalUserInput() {

        // Setup test
        ByteArrayInputStream in = new ByteArrayInputStream("No integer in sight".getBytes());
        System.setIn(in);

        // Exercise
        int anInt = Main.testUserInput();

        // tear down
        System.setIn(System.in);

    }

    @Test
    public void outputWithPrint() {
        // From https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

        // Setup test
        ByteArrayInputStream in = new ByteArrayInputStream("11 5 My string".getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContents = new ByteArrayOutputStream();
        ByteArrayOutputStream errContents = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContents));
        System.setErr(new PrintStream(errContents));

        // Exercise
        int anInt = Main.testUserInput();
        assertEquals("Give a number between 1 and 10\nWrong number, try again.\n", outContents.toString());

        // tear down
        // Setting to null doesn't work well.
        System.setIn(System.in);
        System.setOut(System.out);
        System.setErr(System.err);


    }



}