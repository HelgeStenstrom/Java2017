package Helge;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CellarManager implements Iterable<Wine> {
    private ArrayList<Wine> wines = new ArrayList<>();


    /**
     * Return all wines in the list, regardless of if they are full or empty.
     * @return
     */
    public ArrayList<Wine> getWines() {
        return wines;
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

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Wine> iterator() {
        Iterator<Wine> it = new Iterator<Wine>() {

            // private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return wines.iterator().hasNext();
            }

            @Override
            public Wine next() {
                return wines.iterator().next();
            }

            @Override
            public void remove() {
                wines.iterator().remove();
            }
        };
        return it;
    }

//    /**
//     * Performs the given action for each element of the {@code Iterable}
//     * until all elements have been processed or the action throws an
//     * exception.  Unless otherwise specified by the implementing class,
//     * actions are performed in the order of iteration (if an iteration order
//     * is specified).  Exceptions thrown by the action are relayed to the
//     * caller.
//     *
//     * @param action The action to be performed for each element
//     * @throws NullPointerException if the specified action is null
//     * @implSpec <p>The default implementation behaves as if:
//     * <pre>{@code
//     *     for (T t : this)
//     *         action.accept(t);
//     * }</pre>
//     * @since 1.8
//     */
//    @Override
//    public void forEach(Consumer<? super Wine> action) {
//        for (Wine w : this)
//            action.accept(w);
//    }

//    /**
//     * Creates a {@link Spliterator} over the elements described by this
//     * {@code Iterable}.
//     *
//     * @return a {@code Spliterator} over the elements described by this
//     * {@code Iterable}.
//     * @implSpec The default implementation creates an
//     * <em><a href="Spliterator.html#binding">early-binding</a></em>
//     * spliterator from the iterable's {@code Iterator}.  The spliterator
//     * inherits the <em>fail-fast</em> properties of the iterable's iterator.
//     * @implNote The default implementation should usually be overridden.  The
//     * spliterator returned by the default implementation has poor splitting
//     * capabilities, is unsized, and does not report any spliterator
//     * characteristics. Implementing classes can nearly always provide a
//     * better implementation.
//     * @since 1.8
//     */
//    @Override
//    public Spliterator<Wine> spliterator() {
//        return wines.spliterator();
//    }
}
