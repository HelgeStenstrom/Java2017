/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

public class BankMain {

    public static void main(String[] args) {
        Profit.test();
        Startable bankMenu = new BankMenu();
        bankMenu.start();
    }
}
