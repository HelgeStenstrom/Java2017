/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

import java.util.Scanner;

public class D1U1C implements Startable{
    private Scanner input;

    public void start() {
        input = new Scanner(System.in);

        printInstructions();
        int rows = askForInt("Antal rader:");
        int columns = askForInt("Antal kolumner:");
        printGrid(rows, columns);

    }

    private void printInstructions() {
        System.out.println();
        System.out.println("Du är i en lastbil, där pengar ska placeras i högar.");
        System.out.println("Högarna ordnas i rader och kolumner på lastbilens golv.");
        System.out.println();
    }

    private int askForInt(String s) {
        System.out.printf("%s ", s);
        return Integer.parseInt(input.nextLine());
    }

    private void printGrid(int rows, int columns) {
        System.out.println("Så här placeras pengarna. Varje * är en hög med pengar.");
        System.out.println();
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < columns; c++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
