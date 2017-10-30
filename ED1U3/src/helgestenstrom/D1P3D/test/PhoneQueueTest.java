/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3D.test;

import helgestenstrom.D1P3D.PhoneCall;
import helgestenstrom.D1P3D.PhoneQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhoneQueueTest {
    private PhoneQueue q;

    @Before
    public void setUp() throws Exception {
        int maxSize = 3;
        q = new PhoneQueue(maxSize);
    }

    @Test
    public void pushIncreaseQueueLength() throws Exception {
        Assert.assertEquals(0, q.getCallsInQueue());
        q.push(new PhoneCall());
        Assert.assertEquals(1, q.getCallsInQueue());
    }

    @Test
    public void popGetsLastPushedCall() throws Exception {
        // Setup
        PhoneCall aCall = new PhoneCall();
        PhoneCall anotherCall = new PhoneCall();

        // Execise
        q.push(aCall);
        q.push(anotherCall);

        // Verify
        Assert.assertSame(anotherCall, q.pop());
        Assert.assertSame(aCall, q.pop());
    }

    @Test
    public void hasCallsWhenCallIsPushed() throws Exception {
        // pre-check
        Assert.assertFalse("No call before one is pushed on a new queue", q.hasCalls());
        // Exercise
        q.push(new PhoneCall());
        // Verify
        Assert.assertTrue("Has a call, because one is pushed onto the queue", q.hasCalls());
        q.pop();
        Assert.assertFalse("No calls, because the one is popped", q.hasCalls());
    }

    @Test
    public void addCallPlacesItLastInQueue() throws Exception {
        // Setup
        PhoneCall c1 = new PhoneCall();
        PhoneCall c2 = new PhoneCall();

        // Exercise
        q.addCall(c1);
        q.addCall(c2);

        // Verify
        Assert.assertEquals(2, q.getCallsInQueue());
        Assert.assertSame(c1, q.pop());
        Assert.assertSame(c2, q.pop());
        Assert.assertEquals(0, q.getCallsInQueue());
    }

}