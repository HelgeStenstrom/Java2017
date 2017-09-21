/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstromTests;

import helgestenstrom.*;
import helgestenstrom.Menu;
//import helgestenstrom.K;



import org.junit.*;

import java.math.BigDecimal;

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
    public void deposit_increases_balance() throws Exception {
        a.deposit( 17.0);
        assertEquals(17.0, a.getBalance(), 0.001);
    }

    @Test
    public void withdrawal_decreases_balance() throws Exception {
        a.withdraw( 17.0);
        assertEquals(-17.0, a.getBalance(), 0.001);
    }

}