/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

public class Person {
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String fullName;

    public String getStreetAddress() {
        return streetAddress;
    }

    public Person setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    private String streetAddress;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private String postalCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String city;

    public String getMainPhoneNumber() {
        return mainPhoneNumber;
    }

    public void setMainPhoneNumber(String mainPhoneNumber) {
        this.mainPhoneNumber = mainPhoneNumber;
    }

    private String mainPhoneNumber;


    public static Person nullPerson() {
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

    public void printInfo() {
        System.out.printf("Namn:        %s \n", fullName);
        System.out.printf("Adress:      %s \n", streetAddress);
        System.out.printf("             %s ", postalCode);
        System.out.printf("%s \n", city);
        System.out.printf("Telefon      %s \n", mainPhoneNumber);
    }
}
