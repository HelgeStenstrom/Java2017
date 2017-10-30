/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3C;

import java.util.ArrayList;

public class MainProblemC {

    public static void main(String[] args) {
        int totalVolume = 130;
        Bag big = new Bag(10, 10, 1);
        Bag medium = new Bag(5, 10, 1);
        Bag small = new Bag(2, 10, 1);

        ArrayList<Bag> bags  = new ArrayList<>();
        bags.add(big);
        bags.add(medium);
        bags.add(small);

        System.out.printf("Total volume is : %d\n", totalVolume);
        int remains = totalVolume;
        for (Bag bag: bags) {
            int fit = remains / bag.volume();
            System.out.printf("Fitting %d bag(s) of %s. ", fit, bag);
            remains = remains - fit * bag.volume();
            System.out.printf("Remaining volume: %d.\n", remains);
        }
    }
}
