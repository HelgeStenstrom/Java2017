/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstromTests;

import helgestenstrom.*;

import org.junit.*;

import static org.junit.Assert.*;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deposit_increases_balance() throws Exception {
        account.deposit( 17.0);
        assertEquals(17.0, account.getBalance(), 0.001);
    }

    @Test
    public void withdrawal_decreases_balance() throws Exception {
        account.withdraw( 17.0);
        assertEquals(-17.0, account.getBalance(), 0.001);
    }

}
