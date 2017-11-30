package Tests;

import Helge.White;
import Helge.Wine;
import Helge.WineType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiteTest {
    @Test
    void getWineType() {
        Wine white = new White();
        assertEquals(WineType.White, white.getWineType(), "Alla instanser av White ska ha typen White.");
    }

// http://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions

}