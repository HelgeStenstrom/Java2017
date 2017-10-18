package helgestenstrom;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @org.junit.Test
    public void evaluate() throws Exception {
        Calculator c = new Calculator();
        int sum = c.evaluate("1+2+3");
        assertEquals(6,sum);
    }

    @org.junit.Test
    public void anotherTest() {
        assertEquals(3, 3);
    }

    @org.junit.Test
    public void thirdTest() {

        // Setup test
        ByteArrayInputStream in = new ByteArrayInputStream("11 12 13 14 5 My string".getBytes());
        System.setIn(in);

        // Exercise
        int anInt = Main.testUserInput();
        assertEquals( anInt, 5);

        // tear down
        System.setIn(System.in);

    }

}