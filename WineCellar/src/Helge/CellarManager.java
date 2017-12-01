package Helge;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class CellarManager {
    private ArrayList<Wine> wines;


    /**
     * Return all wines in the list, regardless of if they are full or empty.
     * @return
     */
    public ArrayList<Wine> getWines() {
        throw new NotImplementedException();
    }

    public void add(Wine wine) {
        throw new NotImplementedException();
    }
    public void consume(int index) {
        throw new NotImplementedException();
    }

    public ArrayList<Wine> getConsumed() {
        throw new NotImplementedException();
    }
    public ArrayList<Wine> getUnConsumed() {
        throw new NotImplementedException();
    }

    public void remove(int index) {
        throw new NotImplementedException();
    }

    public ArrayList<Wine> getWinesOfType(WineType wineType) {
        throw new NotImplementedException();
    }

}
