/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3B;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class issueTrackerTests {

    private IssueTracker it;

    @Before
    public void setItUp() {
        it = new IssueTracker();
    }

    @Test
    public void addAnIssue() {
        it.add(new Issue("i1"));
    }

    @Test
    public void getUnresolvedIssues() {
        // Setup
        Issue i1 = new Issue("i1");
        Issue i2 = new Issue(("i2"));
        Issue i3 = new Issue("i3");
        it.add(i1);
        it.add(i2);
        it.add(i3);
        i2.resolve();

        // Exercise
        ArrayList<Issue> us = it.getUnresolved();

        // Verify
        assertEquals(2, us.size());
        assertSame(i1, us.get(0));
        assertSame(i3, us.get(1));
    }

    @Test
    public void getResolvedIssues() {
        // Setup
        Issue i1 = new Issue("i1");
        Issue i2 = new Issue(("i2"));
        Issue i3 = new Issue("i3");
        it.add(i1);
        it.add(i2);
        it.add(i3);
        i2.resolve();

        // Exercise
        ArrayList<Issue> us = it.getResolved();

        // Verify
        assertEquals(1, us.size());
        assertSame(i2, us.get(0));
    }

    @Test
    public void resovleByIdx() {
        // Setup
        Issue i1 = new Issue("i1");
        Issue i2 = new Issue(("i2"));
        Issue i3 = new Issue("i3");
        it.add(i1);
        it.add(i2);
        it.add(i3);

        // Exercise
        it.resolveByindes(1);

        // Verify
        assertEquals(2, it.getUnresolved().size());
        assertEquals(1, it.getResolved().size());
        assertEquals("i2", it.getResolved().get(0).getDescription());

    }

}
