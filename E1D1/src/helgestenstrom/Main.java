/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

public class Main {

    // Jag försöker hålla Main så enkel som möjligt. Anropa Menu() som gör jobbet!
    public static void main(String[] args) {
        Startable menu = new Menu();
        menu.start();
    }
}
