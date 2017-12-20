package Tests;

import Helge.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


class CellarManagerTest {

    private CellarManager cm = new CellarManager();
    private WineBase w;
    private WineBase r;

    @BeforeEach
    void setUp() {
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
        // Setup
        //Wine w = White.exampleWhite();
        //Wine r = new WineBase(WineType.Red,"red", 1997, CharacterType.Fylligt_och_smakrikt, false);
        cm.add(w);
        cm.add(r);

        // Exercise
        ArrayList<WineBase> wines = cm.getWines();
        assertSame(w, wines.get(0));
        assertSame(r, wines.get(1));
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
        WineBase w1 = cm.get(0);
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
        ArrayList<WineBase> remains = cm.getUnConsumed();

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
        ArrayList<WineBase> remains = cm.getConsumed();

        // Verify
        assertEquals(1, remains.size());
        assertSame(r, remains.get(0));
    }

    @Test
    void remove() {
        // Setup
        WineBase w = new White("white", 1999, CharacterType.Druvigt_och_blommigt, false);
        WineBase r = new WineBase(WineType.Red, "red", 1999, CharacterType.Druvigt_och_blommigt, false);
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
        ArrayList<WineBase> whites = cm.getWinesOfType(WineType.White);
        ArrayList<WineBase> reds = cm.getWinesOfType(WineType.Red);

        // Verify
        assertEquals(1, reds.size());
        assertEquals(1, whites.size());
        assertSame(r, reds.get(0));
        assertSame(w, whites.get(0));
    }

    @Test
    void replace() {
        // Setup
        cm.add(r);
        cm.add(w);
        WineBase w2 = White.exampleWhite();

        // Exercise
        cm.replace(1, w2);

        // Verify
        assertSame(cm.get(1), w2);
    }

    @Test @Disabled
    void iterateExpiclity() {

        // Setup
        cm.add(r);
        cm.add(w);
        ArrayList<WineBase> wines = new ArrayList<>();

        // Exercise and collec data
        for (Iterator<WineBase> i = cm.iterator(); i.hasNext();) {
            WineBase item = i.next();
            wines.add(item);
        }

        // Verify
        assertSame(r, wines.get(0));
        assertSame(w, wines.get(1));
    }

    @Test @Disabled
    void iterate() {

        // Setup
        cm.add(r);
        cm.add(w);
        ArrayList<WineBase> wines = new ArrayList<>();

        // Exercise and collec data
//        for (Wine wine : cm) {  // The test is on this row.
//            wines.add(wine);
//        }

        // Verify
        assertSame(r, wines.get(0));
        assertSame(w, wines.get(1));
    }
}