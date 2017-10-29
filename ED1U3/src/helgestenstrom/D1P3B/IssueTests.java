package helgestenstrom.D1P3B;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IssueTests {
    private Issue issue;

    @Before
    public void setUp() {
        issue = new Issue("text");
    }

    @Test
    public void createAnIssue() {
        // Setup
        // Issue issue = new Issue("text");
        // Verify
        assertEquals("Should be created as unresolved", false, issue.isResolved());
        assertEquals("Should be created with text 'text'", "text", issue.getText());
    }

    @Test
    public void resolved() {
        issue.resolve();
        assertTrue(issue.isResolved());
    }
    @Test
    public void unresolved() {
        issue.unresolve();
        assertFalse(issue.isResolved());
    }

    @Test
    public void textOfResolved() {
        issue.resolve();
        assertEquals("Resolved: text", issue.toString());
    }

    @Test
    public void textOfUnresolved() {
        issue.unresolve();
        assertEquals("Unresolved: text", issue.toString());
    }
}
