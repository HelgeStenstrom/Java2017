/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
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

            System.out.print("Are you satisfied with your answers? (y/n) ");
            satisfied = input.nextLine();
            System.out.printf("Your answer: '%s' \n", satisfied);
            if (satisfied.equals("y")){
                System.out.println("you are satisfied");
            }

        } while (!(satisfied.equals("y")));

    }

    private void askQuestions() {
        System.out.print("What is your gender? ");
        gender = input.nextLine();

        System.out.print("Are you a register customer? (y/n) ");
        String response = input.nextLine();
        isRegistered = response.equals("y");

        System.out.print("What is your age? ");
        int age = input.nextInt();

        if (age <= 10) ageRange = "0-10";
                else {
            if (age <= 20) ageRange = "11-20";
            else ageRange = "21+";
            }
        System.out.println();
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
