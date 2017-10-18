/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;


import java.util.ArrayList;

public class Transporter implements Startable {
    // Uppgiften handlar om transport av sedelbuntar, och då vill man veta hur stor plats de tar.


    class Bunt {
        double length;
        double width;
        double height;

        Bunt(double l, double w, double h) {
            length = l;
            width = w;
            height = h;
        }

        double volume () {
            // Volymen för en sedelbunt
            return length * width * height;
        }
    }

    class BuntGrupp {
        Bunt bunt;
        int antal;

        BuntGrupp(Bunt bunt, int antal) {
            this.bunt = bunt;
            this.antal = antal;
        }

        double volume () {
            // Totala volymen för flera sedalbuntar av samma sort.
            return antal * bunt.volume();
        }
    }

    private ArrayList<BuntGrupp> buntarna = new ArrayList<BuntGrupp>();

    @Override
    public void start() {
        System.out.println();
        System.out.println("Några exempel på den plats sedlar kan ta.");
        System.out.println("-----------------------------------------");

        Bunt buntLiten = new Bunt(1, 2, 3);
        Bunt buntMellan = new Bunt(10, 10, 10);
        Bunt buntStor = new Bunt(10, 10, 10.1);

        buntarna.add(new BuntGrupp(buntLiten, 1));
        buntarna.add(new BuntGrupp(buntMellan, 1));
        buntarna.add(new BuntGrupp(buntStor, 2));

        float totVol = 0;
        for (BuntGrupp b : buntarna
             ) {
            System.out.printf("%d buntar med dimensionerna %.1f * %.1f * %.1f", b.antal, b.bunt.length, b.bunt.width, b.bunt.height);
            System.out.printf(", med totalvolymen %.1f. \n", b.volume());

            totVol += b.volume();
        }
        System.out.printf("Alla buntar tillsammans har volymen %.1f", totVol);

        System.out.println();
    }
}
