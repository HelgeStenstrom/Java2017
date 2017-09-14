/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;


import java.util.Scanner;

public class Menu implements Startable {

    private Scanner input;

    public void start() {
        input = new Scanner(System.in);
        cycle();
        System.out.println("Thank you for running Helge Stenström's program.");
    }

    private void banner() {
        System.out.println("-------------------------");
        System.out.println("         MAIN MENU       ");
        System.out.println("-------------------------");
    }

    private void printChoices() {
        banner();
        System.out.println("1:      D1U1A, Ten deposits  ");
        System.out.println("2:      D1U1B, Ask questions ");
        System.out.println("3:      D1U1C, Print a grid  ");
        System.out.println("4:      D1U1D, Betygstatistik ");
        System.out.println("0:      quit");
    }

    private String getChoice() {
        System.out.println("Your choice: ");
        return input.nextLine();
    }

    private void cycle()
    // Main UI loop. Repeat until exit is selected by "0"
    {
        while (true)
        {
            printChoices();
            String choice = getChoice();
            if (choice.equals("0"))
                break;
            else
                runChoice(choice);
        }

    }

    private void runChoice(String choice) {
        Startable subprogram = new NullStartable();

        switch (Integer.parseInt(choice)){
            case 0:
                System.out.println("This can't happen");
                // Can't happen because we will not call the
                // method if choice == 0.
                break;

            case 1:
                subprogram = new D1U1A();
                break;

            case 2:
                subprogram = new D1U1B();
                break;

            case 3:
                subprogram = new D1U1C();
                break;

            case 4:
                subprogram = new D1U1D();
                break;

            default:
                System.out.println("Invalid choice");
        }
        subprogram.start();
    } // end of function
} // end of class
