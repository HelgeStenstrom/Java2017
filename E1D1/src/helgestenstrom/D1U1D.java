
/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

import java.util.Scanner;

public class D1U1D implements Startable {
    private Scanner input;

    public void start() {
        input = new Scanner(System.in);

        printInstructions();
        int numberOfGrades = askForInt("Hur många studenter finns det? ");

        getGradesAndPrintStats(numberOfGrades);
        System.out.println();
    }

    private void printInstructions() {
        System.out.println();
        System.out.println();
    }

    private int askForInt(String s) {
        System.out.printf("%s ", s);
        return Integer.parseInt(input.nextLine());
    }

    private void getGradesAndPrintStats(int count) {
        //String grade;
        int invalids = 0;
        int Us = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int total = 0;

        for (int stud = 1 ; stud <= count; stud++) {
            String prompt = String.format("Ge resultat för student #%d", stud);
            int points = askForInt(prompt);

            if ((points < 0) || (points > 40)) invalids += 1;
            else if (points < 20) Us += 1;
            else if (points < 30) threes += 1;
            else if (points < 36) fours += 1;
            else fives += 1;

            if ((points >= 0) && (points <= 40)) {
                total += points;
            }
        }
        double mean = total/(double) count;

        System.out.printf("There are %d students with grade U. \n", Us);
        System.out.printf("There are %d students with grade 3. \n", threes);
        System.out.printf("There are %d students with grade 4. \n", fours);
        System.out.printf("There are %d students with grade 5. \n", fives);
        System.out.printf("%d student have invalid points. \n", invalids);
        System.out.printf("The mean number of points is %.1f. \n", mean);
    }
}
