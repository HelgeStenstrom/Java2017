/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3A;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.fail;

// import static org.junit.Assert.fail;

public class mainTests // extends TestCase
{
    // @Test
    public void summation() throws Exception {
        fail();
    }

    @Test
    public void testThatFails() throws Exception {
        fail("den ska faila, för att se att det går.");
    }

    @Test
    public void testThatPasses() throws Exception {
    }

    @Test
    public void anotherTestThatPasses() throws Exception {
    }

    // @Test
    public void thisTestWillNotBeRun() throws Exception {
       fail("It will not fail, because it's not run.");
    }
}
