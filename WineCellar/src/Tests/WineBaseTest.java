package Tests;

import Helge.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WineBaseTest {

    @Test
    void construct() {
        Wine red = new WineBase(WineType.Red,
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

        Wine another = new WineBase(red);
    }

    @Test
    void copyFromWite() {
        WineBase white = new White("name", 1999, CharacterType.Druvigt_och_blommigt, false);
        Wine another = new WineBase(white);
        // TODO: Förstå varför jag måste ha WineBase, och det inte duger med Wine.

        assertEquals(WineType.White, white.getWineType());
        assertEquals(WineType.White, another.getWineType());
    }
}