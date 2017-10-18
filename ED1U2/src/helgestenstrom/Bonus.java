/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

import java.util.Scanner;

public class Bonus implements Startable {
    private Scanner input = new Scanner(System.in);

    private double balance;
    private double deposit;

    public void start() {
        // Tolkning av uppgiftens text, hoppas jag har förstått rätt.
        // start() är en sekvens som löser uppgiften.

        balance = 100;

        System.out.printf("Tänk dig ett konto med ingående balans %.2f kr.", balance);

        tenDeposits();

        System.out.printf("Efter alla insättningar har du %.2f kr på kontot.\n", balance);
    }

    private void  addBonus() {
        // Öka värdet på en insättning enligt uppgiften.
        deposit *= 1.1;
    }

    private void tenDeposits() {
        // Metoden borde naturligtvis ha varit parametriserad med antalet insättningar,
        // men uppgiften säger att de skall vara tio.

        System.out.println("Vänligen mata in 10 belopp att sätta in.");
        System.out.printf("Använd samma decimaltecken som i %.4f", 3.1415927);
        System.out.println();
        for (int i = 1; i<= 10; i++) {
            System.out.printf( "Insättning %d: ", i);
            deposit = getDeposit();
            System.out.printf("Du satte in %.2f kr.", deposit);
            addBonus();
            System.out.printf(" Med 10 %% bonus blir det %.2f \n\n", deposit);
            balance += deposit;
        }

    }

    private double getDeposit() {
        // Del av användardialogen.
        double d = Double.parseDouble( input.nextLine());
        System.out.println();
        return d;
    }
}
