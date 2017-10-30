/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3C;

import java.util.ArrayList;

public class MainProblemC {

    public static void main(String[] args) {

        // Eftersom uppgiften inte säger något om totalvolymen, men video gör det,
        // använder jag totalvolym och påsarnas storlek från videon
        int totalVolume = 130;
        Bag big = new Bag(10, 10, 1);
        Bag medium = new Bag(5, 10, 1);
        Bag small = new Bag(2, 10, 1);

        // En ArrayList listar påstyperna.
        // Det finns ingen praktisk anledning att låta varje påse vara ett objekt,
        // när det fungerar bra att bara beräkna påstyperna.
        ArrayList<Bag> bags  = new ArrayList<>();
        bags.add(big);
        bags.add(medium);
        bags.add(small);

        System.out.printf("Total volume is : %d\n", totalVolume);
        int remainingVolume = totalVolume;
        for (Bag bagModel: bags) {
            // Heltalsdivision för att se hur många påsar av aktuell sort som får plats.
            // Matematik istället för trial & error. Därmed behöver inte varje
            // enskild påse representeras av ett objekt, det duger bra med att
            // påstyperna gör det.
            int numberThatFits = remainingVolume / bagModel.volume();
            System.out.printf("Fitting %d bag(s) of %s. ", numberThatFits, bagModel);
            remainingVolume = remainingVolume - numberThatFits * bagModel.volume();
            System.out.printf("Remaining volume: %d.\n", remainingVolume);
        }
    }
}
