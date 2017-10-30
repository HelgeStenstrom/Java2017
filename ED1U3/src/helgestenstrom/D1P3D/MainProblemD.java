/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3D;

import java.util.Scanner;

// User-facing code is in this class, which has only static members.
// The queue is handled by the callss PhoneQueue

public class MainProblemD {
    private static PhoneQueue queue;
    private final static int maxQueueSize = 10;
    private static Scanner input = new  Scanner(System.in);

    public static void main(String[] args) {
        // Create the (empty) queue and start the menu.
        queue = new PhoneQueue(maxQueueSize);
        menuHandler();
    }

    private static void menuHandler() {
        // The user menu select what to do.

        System.out.print(menuText());

        System.out.printf("Current queue size: %d \n", queue.getCallsInQueue());
        System.out.print("> ");
        int choice = input.nextInt();
        boolean exit = false;

        while (true) {
            // This is a loop. It may be the only one.
            System.out.println();
            switch (choice) {
                case 1:
                    addCall();
                    break;
                case 2:
                    answerCall();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong choice, try again!");
                    break;
            }
            if (exit)
                break;
            else {
                System.out.print(menuText());

                System.out.printf("Current queue size: %d \n", queue.getCallsInQueue());
                System.out.print("> ");
                choice = input.nextInt();
            }
        }

        System.out.println("Than you for using the phone system");
    }

    private static String menuText() {
        return  " -------- Menu -------- \n" +
                "| 1. Add phone call    |\n" +
                "| 2. Answer phone call |\n" +
                "| 9. Exit              |\n" +
                " ---------------------- \n";
    }



    private static void addCall() {
        System.out.println("--- New call ---");
        System.out.print("Name of caller: ");

        // The following line throws away one piece of input.
        // I don't fully understand why it's needed.
        // If it's not there, there will be a mismatch between propmpts and inputs.
        input.nextLine();
        String name = input.nextLine();

        System.out.print("Phone number: ");
        String number = input.nextLine();

        queue.addCall(new PhoneCall(name, number));

    }

    private static void answerCall() {
        // Only answer if there really is a call.
        if (queue.hasCalls()) {
            PhoneCall caller = queue.pop();
            System.out.printf("Now answering: %s (%s) \n", caller.getCallerName(), caller.getCallerPhoneNumber());
        }
        else {
            System.out.println("Now calls on queue.");
        }
        System.out.println();
    }
}
