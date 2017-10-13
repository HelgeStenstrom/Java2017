/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Scanner;

public class Person {
    public String getFullName() {
        return fullName;
    }

    private String fullName;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String mainPhoneNumber;
    private static Scanner input = new Scanner(System.in);

    static Person nullPerson() {
        Person p = new Person();
        p.fullName = "Nomen Nescio";
        p.streetAddress = "Gatan 17";
        p.postalCode = "123 45";
        p.city = "Storstad";
        p.mainPhoneNumber = "073-123456";

        return p;
    }
    public static Person getOwner() {
        //return this;
        return nullPerson();
    }

    void printInfo() {
        System.out.printf("Namn:        %s \n", fullName);
        System.out.printf("Adress:      %s \n", streetAddress);
        System.out.printf("             %s ", postalCode);
        System.out.printf("%s \n", city);
        System.out.printf("Telefon      %s \n", mainPhoneNumber);
    }

    public static Person makePersonDialog() {
        Person p = new Person();
        System.out.println("Ange kontoägare");
        p.fullName = promptFor("För- och efternamn");
        p.streetAddress = promptFor("Gatuadress");
        p.postalCode = promptFor("Postnummer");
        p.city = promptFor("Postort");
        p.mainPhoneNumber = promptFor("Telefonnummer");
        return p;
    }

    static String promptFor(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextLine();
    }
}
