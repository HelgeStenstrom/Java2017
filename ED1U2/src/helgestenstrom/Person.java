/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

import java.util.Scanner;

public class Person {
    // En person behövs som ägare till ett Account.
    // Personen har namn, adress, telefonnummer.

    public String getFullName() {
        return fullName;
    }

    private String fullName;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String mainPhoneNumber;
    private static final Scanner input = new Scanner(System.in);

    private static Person nullPerson() {
        Person p = new Person();
        p.fullName = "Nomen Nescio";
        p.streetAddress = "Gatan 17";
        p.postalCode = "123 45";
        p.city = "Storstad";
        p.mainPhoneNumber = "073-123456";

        return p;
    }
    public static Person getOwner() {
        return nullPerson();
    }

    void printInfo() {
        System.out.printf("Namn:        %s \n", fullName);
        System.out.printf("Adress:      %s \n", streetAddress);
        System.out.printf("             %s ", postalCode);
        System.out.printf("%s \n", city);
        System.out.printf("Telefon      %s \n", mainPhoneNumber);
    }


    void enterAccountInfo() {
        while (true) {
            System.out.println();
            System.out.println("Ange kontoägare");

            fullName = promptFor("För- och efternamn");
            streetAddress = promptFor("Gatuadress");
            postalCode = promptFor("Postnummer");
            city = promptFor("Postort");
            mainPhoneNumber = promptFor("Telefonnummer");

            System.out.println();
            System.out.print("Är du nöjd? (j/n) ");
            String answer = input.nextLine();

            if (answer.equals("j"))
                break;
            System.out.println("Försök igen" );
        }
    }


    private static String promptFor(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextLine();
    }
}
