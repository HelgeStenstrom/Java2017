package playingcards;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testRank() {
        Card c = new Card(Ranks.FOUR, Suits.CLUBS);
        int expected = Ranks.FOUR;
        int actual = c.rank();
        assertEquals(expected, actual);

    }
}