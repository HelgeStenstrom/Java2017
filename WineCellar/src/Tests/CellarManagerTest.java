package Tests;

import Helge.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class CellarManagerTest {

    CellarManager cm;
    Wine w;
    Wine r;

    @BeforeEach
    void setUp() {
        cm = new CellarManager();
        w = new White("white", 1999, CharacterType.Druvigt_och_blommigt, false);
        r = new WineBase(WineType.Red, "red", 1999, CharacterType.Druvigt_och_blommigt, false);

    }

    @Test
    void construct() {
        // Verify
        assertEquals(0, cm.size());
    }

    @Test
    void getWines() {
        fail("Test not written");
    }

    @Test
    void add() {
        // Setup
        // Exercise
        cm.add(w);
        cm.add(r);
        // Verify
        assertEquals(2, cm.size());
    }

    @Test
    void getByIndex() {
        // Setup
        cm.add(w);
        cm.add(r);
        Wine w1 = cm.get(0);
        assertEquals("white", w1.getName());
        assertEquals("red", cm.get(1).getName());
    }

    @Test
    void consume() {
        // Setup
        cm.add(w);
        cm.add(r);
        assertFalse(cm.get(1).isConsumed());

        // Exercise
        cm.consume(1);

        // Verify
        assertTrue(cm.get(1).isConsumed());
    }

    @Test
    void getUnConsumed() {
        // Setup
        cm.add(w);
        cm.add(r);
        assertFalse(cm.get(1).isConsumed());
        cm.consume(1);

        // Exercise
        ArrayList<Wine> remains = cm.getUnConsumed();

        // Verify
        assertEquals(1, remains.size());
        assertSame(w, remains.get(0));
    }

    @Test
    void getConsumed() {
        // Setup
        cm.add(w);
        cm.add(r);
        assertFalse(cm.get(1).isConsumed());
        cm.consume(1);

        // Exercise
        ArrayList<Wine> remains = cm.getConsumed();

        // Verify
        assertEquals(1, remains.size());
        assertSame(r, remains.get(0));
    }

    @Test
    void remove() {
        // Setup
        Wine w = new White("white", 1999, CharacterType.Druvigt_och_blommigt, false);
        Wine r = new WineBase(WineType.Red, "red", 1999, CharacterType.Druvigt_och_blommigt, false);
        // Exercise
        cm.add(w);
        cm.add(r);
        assertEquals(2, cm.size());
        cm.remove(1);
        assertEquals(1, cm.size());
    }

    @Test
    void getWinesOfType() {
        // Setup
        cm.add(r);
        cm.add(w);

        // Exercise
        ArrayList<Wine> whites = cm.getWinesOfType(WineType.White);
        ArrayList<Wine> reds = cm.getWinesOfType(WineType.Red);

        // Verify
        assertEquals(1, reds.size());
        assertEquals(1, whites.size());
        assertSame(r, reds.get(0));
        assertSame(w, whites.get(0));
    }
}