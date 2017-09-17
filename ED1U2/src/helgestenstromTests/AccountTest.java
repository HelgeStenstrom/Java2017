/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstromTests;

import helgestenstrom.*;
import helgestenstrom.Menu;
//import helgestenstrom.K;



import org.junit.*;

import static org.junit.Assert.*;

public class AccountTest {
    Account a;

    @Before
    public void setUp() throws Exception {
        a = new Account();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getBalance() throws Exception {
        a.deposit(17);
        assertEquals(177, a.getBalance());
    }

    @Test
    public void enterInfo() throws Exception {
    }

    @Test
    public void printInfo() throws Exception {
        assertEquals(1,2);
    }

}