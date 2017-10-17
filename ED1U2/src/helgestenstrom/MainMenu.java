/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

import java.util.Scanner;

public class MainMenu implements Startable {
    // A null object is useful as default value.

    private Scanner input;

    public void start() {
        // The only public method. It starts the main menu.

        input = new Scanner(System.in);
        uiLoop();
        System.out.println("Thank you for running Helge Stenström's program.");
    }

    private void banner() {
        System.out.println("-------------------------");
        System.out.println("         MAIN MENU       ");
        System.out.println("-------------------------");
    }

    private void printChoices() {
        banner();
        System.out.println("1:      D1U2A, Bank account  ");
        System.out.println("2:      D1U2B, Interest and Profit ");
        System.out.println("3:      D1U2C, ???  ");
        System.out.println("4:      D1U2D, ??? ");
        System.out.println("0:      quit");
    }

    private String getChoice() {
        System.out.println("Your choice: ");
        return input.nextLine();
    }

    private void uiLoop()
    // Main UI loop. Repeat until exit is selected by "0"
    {
        while (true)
        {
            printChoices();
            String choice = getChoice();
            if (choice.equals("0"))
                break;
            else
                // If the choice is valid, run it!
                runChoice(choice);
        }

    }

    private void runChoice(String choice) {

        // The default is to not do anything. It will most likely be overridden.
        Startable subprogram = new NullStartable();

        switch (Integer.parseInt(choice)){
            case 0:
                System.out.println("This can't happen");
                // Can't happen because we will not call the
                // method if choice == 0.
                break;

            case 1:
                subprogram = new BankMenu();
                break;

            case 2:
                subprogram = new Profit();
                break;

            case 3:
                subprogram = new Profit();
                break;

            case 4:
                subprogram = new Profit();
                break;

            default:
                System.out.println("Invalid choice");
        }
        subprogram.start();
    } // end of function



}