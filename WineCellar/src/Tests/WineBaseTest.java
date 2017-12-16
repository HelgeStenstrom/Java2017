package Tests;

import Helge.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WineBaseTest {

    @Test
    void construct() {
        WineBase red = new WineBase(WineType.Red,
                "namn",
                2007,
                CharacterType.Druvigt_och_blommigt,
                false);
    }

    @Test
    void copyBase() {
        WineBase red = new WineBase(WineType.Red,
                "namn",
                2007,
                CharacterType.Druvigt_och_blommigt,
                false);

        WineBase another = new WineBase(red);
    }

    @Test
    void copyFromWite() {
        WineBase white = new White("name", 1999, CharacterType.Druvigt_och_blommigt, false);
        WineBase another = new WineBase(white);

        assertEquals(WineType.White, white.getWineType());
        assertEquals(WineType.White, another.getWineType());
    }
}
