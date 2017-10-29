package helgestenstrom.D1P3B;

import org.junit.Before;
import org.junit.Test;

// import static org.junit.Assert.fail;
import static junit.framework.TestCase.fail;

public class issueTrackerTests {

    IssueTracker it;

    @Before
    public void setItUp() {
        it = new IssueTracker();
    }

    @Test
    public void addAnIssue() {
        it.add(new Issue("i1"));
    }
}
