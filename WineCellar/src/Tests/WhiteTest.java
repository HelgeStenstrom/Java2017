package Tests;

import Helge.CharacterType;
import Helge.White;
import Helge.Wine;
import Helge.WineType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhiteTest {
    Wine example = new White("name", 1999, CharacterType.Druvigt_och_blommigt, false);

    @Test
    void getWineType() {
        Wine white = example;
        assertEquals(WineType.White, white.getWineType(), "Alla instanser av White ska ha typen White.");
    }

    @Test
    void fullConstructor() {
        Wine white = new White("name", 2007, CharacterType.Druvigt_och_blommigt, false);
    }

// http://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions

}

