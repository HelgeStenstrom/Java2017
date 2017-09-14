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

    String fullName;

    public String getStreetAddress() {
        return streetAddress;
    }

    public Person setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    String streetAddress;
    String postalCode;
    String city;
    String mainPhoneNumber;
}
