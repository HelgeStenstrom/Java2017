/*
 * Copyright (c) 2017. Helge Stenström
 */

package Helge;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CellarManager implements Iterable<WineBase> {
    private ArrayList<WineBase> wines = new ArrayList<>();


    /**
     * Return all wines in the list, regardless of if they are full or empty.
     *
     * @return
     */
    public ArrayList<WineBase> getWines() {
        return wines;
    }

    public void foobar() {
        wines.get(0);
    }

    public void add(WineBase wine) {
        wines.add(wine);
    }

    public void consume(int index) {
        wines.get(index).consume();
    }

    public ArrayList<WineBase> getConsumed() {
        ArrayList<WineBase> gone = new ArrayList<>();
        for (WineBase wine : wines) {
            if (wine.isConsumed())
                gone.add(wine);
        }
        return gone;
    }

    public ArrayList<WineBase> getUnConsumed() {
        ArrayList<WineBase> remains = new ArrayList<>();
        for (WineBase wine : wines) {
            if (!wine.isConsumed())
                remains.add(wine);
        }
        return remains;
    }

    public void remove(int index) {
        wines.remove(index);
    }

    public ArrayList<WineBase> getWinesOfType(WineType wineType) {
        ArrayList<WineBase> matching = new ArrayList<>();
        for (WineBase wine : wines) {
            if (wineType.equals(wine.getWineType()))
                matching.add(wine);
        }
        return matching;
    }

    public int size() {
        return wines.size();
    }

    public WineBase get(int index) {
        return wines.get(index);
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

    public void replace(int index, WineBase replacement) {
        wines.set(index, replacement);
    }
}
