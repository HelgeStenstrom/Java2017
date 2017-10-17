/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

public class Transporter implements Startable {

    class BuntStorlek {
        double length;
        double width;
        double height;

        double volume () {
            return length * width * height;
        }
    }

    @Override
    public void start() {
        // Do nothing.
    }

    public double metod(int antalSedelbuntar, BuntStorlek storlek) {
        return antalSedelbuntar * storlek.volume();
    }

}
