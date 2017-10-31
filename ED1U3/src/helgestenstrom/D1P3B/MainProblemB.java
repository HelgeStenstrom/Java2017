/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3B;

import java.util.Scanner;

// Huvudprogram. Skapa en IssueTracker, och sköt interaktionen med användaren.

public class MainProblemB {
    private static IssueTracker issueTracker = new IssueTracker();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Problem B");
        boolean cont = true;
        int val;
        do {
            val = MenuChoice();
            switch (val) {
                case 1:
                    CreateIssue();
                    break;
                case 2:
                    markAsResolved();
                    break;
                case 3:
                    viewUnresolved();
                    break;
                case 4:
                    viewResolved();
                    break;
                case 5:
                    cont = false;
                    break;

            }
        }
        while (cont);
    }

    // Skriv ut en meny.
    // Så här i efterhand skulle jag hellre ha en metod som bara returnerar texten.
    private static void printMenu() {
        System.out.println();
        System.out.println("--- MenuChoice --- ");
        System.out.println("1. Create a new issue");
        System.out.println("2. Mark issue as solved");
        System.out.println("3. View unsolved issues");
        System.out.println("4. View solved issues");
        System.out.println("5. Exit");
        System.out.println();
        System.out.println("Select an option.");

    }

    // Fråga användaren om ett menyval, och returnera valet.
    private static int MenuChoice() {
        int choice = -1;
        printMenu();
        System.out.print("> ");


        while (input.hasNext()) {
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (1 <= choice && choice <= 5)
                    break;
            }
            else
                input.next();
            printMenu();
            System.out.print("> ");
        }
        return choice;
    }

    // MenuChoice 1. Skapa ett ärende.
    private static void CreateIssue() {
        input.nextLine();
        System.out.println("--- Create new Issue");
        System.out.print("Describe the issue: ");
        String descr = input.nextLine();
        Issue issue = new Issue(descr);
        issueTracker.add(issue);
    }

    // MenuChoice 2. Mark issue as resolved
    private static void markAsResolved() {
        int index = -1;
        System.out.println("Select an issue to resolve:");

        while (input.hasNext()) {
            if (input.hasNextInt()) {
                index = input.nextInt();
                if (0 <= index && index < issueTracker.getIssues().size())
                    break;
            }
            else
                input.next();
            System.out.println("Select an issue to resolve:");
        }
        issueTracker.resolveByindes(index);
    }

    // Choice 3
    private static void viewUnresolved() {
        viewIssuesByStatus(false);
    }

    // Choice 4
    private static void viewResolved() {
        viewIssuesByStatus(true);
    }

    // Returnera de ärenden som har den efterfrågade statusen.
    private static void viewIssuesByStatus(boolean resolved) {
        int index = 0;
        for (Issue issue: issueTracker.getIssues()) {
            if (issue.isResolved() == resolved)
                System.out.printf("[%d]    %s\n", index, issue.getDescription());
            index++;
        }

    }
}
