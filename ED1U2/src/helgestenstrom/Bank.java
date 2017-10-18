/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

import java.util.Scanner;

public class Bank implements Startable {

    private Scanner input = new Scanner(System.in);
    private Account account = new Account();

    public void start() {
        int choice;
        while (true) {
            printChoices();
            choice = getIntWithPrompt("Ditt val: ");
            if (choice == 0) {
                break;
            }

            runChoice(choice);
        }
    }

    private void printChoices() {
        System.out.println("Vad vill du göra?");
        System.out.println();
        System.out.println("1: Definiera konto");
        System.out.println("2: Sätt in pengar");
        System.out.println("3: Ta ut pengar");
        System.out.println("4: Se kontoinformation");
        System.out.println("0: Avsluta");
        System.out.println();
    }

    private int getIntWithPrompt(String prompt) {
        // Potentiellt återanvändingsbar funktion för att fråga om ett heltal.
        int result = 0;
        boolean done = false;
        while (!done) {
            System.out.printf("%s: ", prompt);
            try {
                    result = Integer.parseInt(input.nextLine());
                    done = true;
            }
            catch (NumberFormatException e) {
                // No need to do anything, except re-trying.
            }
        }
        return result;
    }

    private void runChoice(int choice) {
        // Sköter menyn för denna deluppgift.
        switch (choice) {
            case 1:
                account.enterInfo();
                break;
            case 2:
                account.makeDeposit();
                break;
            case 3:
                account.makeWithdrawal();
                break;
            case 4:
                account.printInfo();
                break;
            default: {
                System.out.println("Ogiltigt val, försök igen!");
                System.out.println();
            }
        }
    }
}
