package helgestenstrom;

import static org.junit.Assert.*;

public class CalculatorTest {
    @org.junit.Test
    public void evaluate() throws Exception {
        Calculator c = new Calculator();
        int sum = c.evaluate("1+2+3");
        assertEquals(6,sum);
    }
}