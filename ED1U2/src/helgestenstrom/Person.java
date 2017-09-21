/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

public class Person {
    public String getFullName() {
        return fullName;
    }

    private String fullName;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String mainPhoneNumber;

    static Person nullPerson() {
        Person p = new Person();
        p.fullName = "Nomen Nescio";
        p.streetAddress = "Gatan 17";
        p.postalCode = "123 45";
        p.city = "Storstad";
        p.mainPhoneNumber = "073-123456";

        return p;
    }
    static Person getOwner() {
        return nullPerson();
    }

    void printInfo() {
        System.out.printf("Namn:        %s \n", fullName);
        System.out.printf("Adress:      %s \n", streetAddress);
        System.out.printf("             %s ", postalCode);
        System.out.printf("%s \n", city);
        System.out.printf("Telefon      %s \n", mainPhoneNumber);
    }
}
