/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

import java.util.Scanner;

public class D1U1B implements Startable{
    private Scanner input;
    private String gender;
    private boolean isRegistered;
    private String ageRange;


    public void start() {
        input = new Scanner(System.in);
        banner();
        cycle();
    }

    private void banner() {
        System.out.println("You will be asked some questions.");
        System.out.println();
    }

    private void cycle() {
        String satisfied;
        do {
            askQuestions();

            printAnswers();

            satisfied = askFor("Are you satisfied with your answers? (y/n)");
            System.out.printf("Your answer: '%s' \n", satisfied);

        } while (!(satisfied.equals("y")));

        System.out.println("Thanks for participating in the exercise!");
    }

    private void askQuestions() {
        gender = askFor("What is your gender?");

        String response = askFor("Are you a register customer? (y/n)");
        isRegistered = response.equals("y");

        int age = askForInt("What is your age?");
        if (age <= 20) ageRange = "0-20";
                else {
            if (age <= 40) ageRange = "21-40";
            else ageRange = "41+";
            }
        System.out.println();
    }

    private int askForInt(String s) {
        System.out.printf("%s ", s);
        return Integer.parseInt(input.nextLine());
    }

    private String askFor(String s) {
        System.out.printf("%s: ", s);
        return input.nextLine();
    }

    private void printAnswers() {
        System.out.println("--------------------------------------");
        System.out.println("Your answers can be summarized:");
        System.out.printf("Your gender: %s \n", gender);
        System.out.printf("Are you registered? : %b \n", isRegistered);
        System.out.printf("Your age range is %s \n", ageRange);
        System.out.println("---------------------------------------");
    }
}
