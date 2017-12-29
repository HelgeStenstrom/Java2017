/*
 * Copyright (c) 2017. Helge Stenström
 */

package Helge;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * CellarManager manages the list of wines, providing functions for adding, removing and changing wines
 * as well as returning subsets of the wine list.
 * An attempt was made to make this an iterable list, but it doesn't work.
 */
public class CellarManager implements Iterable<WineBase> {
    private ArrayList<WineBase> wines = new ArrayList<>();


    /**
     * Return all wines in the list, regardless of if they are full or empty.
     *
     * @return
     */
    public ArrayList<WineBase> getWines() {
        ArrayList<WineBase> ws = new ArrayList<>();
        for (WineBase wine : wines)
            ws.add(new WineBase(wine));
        return ws;
    }

    /**
     * Return a wine by index.
     * @param index
     * @return
     */
    public WineBase get(int index) {
        return wines.get(index);
    }

    /**
     * Adds a wine to the wine cellar
     * @param wine
     */
    public void add(WineBase wine) {
        wines.add(wine);
    }

    /**
     * Replace a wine in the cellar with a different one. Typically used for small editing operations.
     * @param index
     * @param replacement wine.
     */
    public void replace(int index, WineBase replacement) {
        wines.set(index, replacement);
    }

    /**
     * Remove a wine from the cellar, by index.
     * @param index of the wine to remove
     */
    public void remove(int index) {
        wines.remove(index);
    }

    /**
     * Marks a wine as consumed
     * @param index
     */
    public void consume(int index) {
        wines.get(index).consume();
    }

    /**
     * @return all wines in the cellar that are marked as consumed
     */
    public ArrayList<WineBase> getConsumed() {
        ArrayList<WineBase> gone = new ArrayList<>();
        for (WineBase wine : wines) {
            if (wine.isConsumed())
                gone.add(wine);
        }
        return gone;
    }

    /**
     * @returna ll wines in the cellar that are not marked as consumed
     */
    public ArrayList<WineBase> getUnConsumed() {
        ArrayList<WineBase> remains = new ArrayList<>();
        for (WineBase wine : wines) {
            if (!wine.isConsumed())
                remains.add(wine);
        }
        return remains;
    }

    /**
     * Return all wines of a certain type (Red or White)
     * @param wineType
     * @return
     */
    public ArrayList<WineBase> getWinesOfType(WineType wineType) {
        ArrayList<WineBase> matching = new ArrayList<>();
        for (WineBase wine : wines) {
            if (wineType.equals(wine.getWineType()))
                matching.add(wine);
        }
        return matching;
    }

    /**
     * @return the size of the wine list, i.e., the number of wines in the cellar.
     */
    public int size() {
        return wines.size();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<WineBase> iterator() {
        Iterator<WineBase> it = new Iterator<WineBase>() {

            // private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return wines.iterator().hasNext();
            }

            @Override
            public WineBase next() {
                return wines.iterator().next();
            }

            @Override
            public void remove() {
                wines.iterator().remove();
            }
        };
        return it;
    }
}
