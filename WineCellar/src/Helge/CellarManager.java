package Helge;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class CellarManager {
    private ArrayList<Wine> wines = new ArrayList<>();


    /**
     * Return all wines in the list, regardless of if they are full or empty.
     * @return
     */
    public ArrayList<Wine> getWines() {
        throw new NotImplementedException();
    }

    public void foobar() {
        wines.get(0);
    }

    public void add(Wine wine) {
        wines.add(wine);
    }
    public void consume(int index) {
        wines.get(index).consume();
    }

    public ArrayList<Wine> getConsumed() {
        ArrayList<Wine> gone = new ArrayList<>();
        for (Wine wine : wines) {
            if (wine.isConsumed())
                gone.add(wine);
        }
        return gone;
    }
    public ArrayList<Wine> getUnConsumed() {
        ArrayList<Wine> remains = new ArrayList<>();
        for (Wine wine : wines) {
            if (!wine.isConsumed())
                remains.add(wine);
        }
        return remains;
    }

    public void remove(int index) {
        wines.remove(index);
    }

    public ArrayList<Wine> getWinesOfType(WineType wineType) {
        ArrayList<Wine> matching = new ArrayList<>();
        for (Wine wine: wines) {
            if (wineType.equals(wine.getWineType()))
                matching.add(wine);
        }
        return matching;
    }

    public int size() {
        return wines.size();
    }

    public Wine get(int index) {
        return wines.get(index);
    }
}
