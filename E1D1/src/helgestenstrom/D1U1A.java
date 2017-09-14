/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

// This exercise has variables: input, sum, i
// a foor-loop
// a Scanner (input)
// an if-statement
// There is a switch statement in the calling function Menu()


import java.util.Scanner;

public class D1U1A implements Startable{
    private Scanner input;
    private double sum = 0;

    public void start() {
        input = new Scanner(System.in);
        banner();
        getAndSumNumbers();
    }

    private void blankLine() {
        System.out.println();
    }

    private void banner() {
        System.out.println("Delprov 1, Programmeringsuppgift 1, Problen A");
        blankLine();
    }

    private void getAndSumNumbers() {
        System.out.println("Enter 10 numbers, one by one. ");
        System.out.println("The numbers represent deposits (positive) and withdrawals (negative).");
        blankLine();

        int numberOfNumbers = 10;
        for (int i=0; i < numberOfNumbers ; i++) {
            System.out.printf("Enter value #%d: ", i+1);
            sum += input.nextDouble();
        }

        System.out.println("-------------------------");
        System.out.printf("The sum of the numbers is %.2f. \n", sum);

        if (sum < 0){
            System.out.println("That is a negative number. You owe someone money.");
        }
    }
}
