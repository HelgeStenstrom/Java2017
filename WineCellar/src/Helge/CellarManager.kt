/*
 * Copyright (c) 2017. Helge Stenström
 */

package Helge

import sun.reflect.generics.reflectiveObjects.NotImplementedException

import java.util.ArrayList
import java.util.Spliterator
import java.util.function.Consumer

/**
 * CellarManager manages the list of wines, providing functions for adding, removing and changing wines
 * as well as returning subsets of the wine list.
 * An attempt was made to make this an iterable list, but it doesn't work.
 */
class CellarManager : Iterable<WineBase> {
    private val wines = ArrayList<WineBase>()

    /**
     * @return all wines in the cellar that are marked as consumed
     */
    val consumed: ArrayList<WineBase>
        get() {
            val gone = ArrayList<WineBase>()
            for (wine in wines) {
                if (wine.isConsumed!!)
                    gone.add(wine)
            }
            return gone
        }

    /**
     * @returna ll wines in the cellar that are not marked as consumed
     */
    val unConsumed: ArrayList<WineBase>
        get() {
            val remains = ArrayList<WineBase>()
            for (wine in wines) {
                if (!wine.isConsumed)
                    remains.add(wine)
            }
            return remains
        }


    /**
     * Return all wines in the list, regardless of if they are full or empty.
     *
     * @return
     */
    fun getWines(): ArrayList<WineBase> {
        val ws = ArrayList<WineBase>()
        for (wine in wines)
            ws.add(WineBase(wine))
        return ws
    }

    /**
     * Return a wine by index.
     * @param index
     * @return
     */
    operator fun get(index: Int): WineBase {
        return wines[index]
    }

    /**
     * Adds a wine to the wine cellar
     * @param wine
     */
    fun add(wine: WineBase) {
        wines.add(wine)
    }

    /**
     * Replace a wine in the cellar with a different one. Typically used for small editing operations.
     * @param index
     * @param replacement wine.
     */
    fun replace(index: Int, replacement: WineBase) {
        wines[index] = replacement
    }

    /**
     * Remove a wine from the cellar, by index.
     * @param index of the wine to remove
     */
    fun remove(index: Int) {
        wines.removeAt(index)
    }

    /**
     * Marks a wine as consumed
     * @param index
     */
    fun consume(index: Int) {
        wines[index].consume()
    }

    /**
     * Return all wines of a certain type (Red or White)
     * @param wineType
     * @return
     */
    fun getWinesOfType(wineType: WineType): ArrayList<WineBase> {
        val matching = ArrayList<WineBase>()
        for (wine in wines) {
            if (wineType == wine.wineType)
                matching.add(wine)
        }
        return matching
    }

    /**
     * @return the size of the wine list, i.e., the number of wines in the cellar.
     */
    fun size(): Int {
        return wines.size
    }

    /**
     * Returns an iterator over elements of type `T`.
     *
     * @return an Iterator.
     */
    override fun iterator(): Iterator<WineBase> {
        return object : Iterator<WineBase> {

            // private int currentIndex = 0;

            override fun hasNext(): Boolean {
                return wines.iterator().hasNext()
            }

            override fun next(): WineBase {
                return wines.iterator().next()
            }

            //override
            fun remove() {
                wines.iterator().remove()
            }
        }
    }
}
