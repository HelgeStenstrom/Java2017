/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

import java.util.Scanner;

public class BankMenu implements Startable {

    // SubTask[] tasks; // Hold list of tasks to choose
    private Scanner input;
    private Account account;

    public void start() {
        input = new Scanner(System.in);
        account = new Account();
        runMenu();
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

    private void runMenu() {
        int choice;
        while (true) {
            printChoices();
            //choice = getChoice();
            choice = getIntWithPompt("Ditt val: ");
            if (choice == 0) {
                break;
            }

            runChoice(choice);
        }
    }

    private int getIntWithPompt(String prompt) {
        int result = 0;
        boolean done = false;
        while (!done) {
            System.out.printf("%s: ", prompt);
            try {
                    result = Integer.parseInt(input.nextLine());
                    done = true;
            }
            catch (NumberFormatException e) {
                // Not catching the exception is probably not very good structure, but it works.
            }
        }
        return result;
    }

    private void runChoice(int choice) {
        switch (choice) {
            case 1:
                enterAccountInfo();
                break;
            case 2:
                makeDeposit();
                break;
            case 3:
                makeWithdrawal();
                break;
            case 4:
                seeAccountInfo();
                break;
            default: {
                System.out.println("Ogiltigt val, försök igen!");
                System.out.println();
            }
        }
    }

    private void enterAccountInfo() {
        account.enterInfo();
    }

    private void makeDeposit() {
        account.makeDeposit();
    }

    private void makeWithdrawal(){
        account.makeWithdrawal();
    }

    private void seeAccountInfo() {
        account.printInfo();
    }

}
