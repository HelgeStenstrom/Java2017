package helloworld;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Vad heter du? ");
        String yourname = input.nextLine();

        System.out.printf("Hej %s!", yourname);
    }
}
