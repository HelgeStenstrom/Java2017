/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3D;

public class PhoneCall {
    private String callerName;
    private String callerPhoneNumber;

    PhoneCall(String callerName, String callerPhoneNumber) {
        this.callerName = callerName;
        this.callerPhoneNumber = callerPhoneNumber;
    }

    // Simplified constructor with default fields.
    public PhoneCall() {
        this.callerName = "No Name";
        this.callerPhoneNumber = "No number";
    }

    String getCallerName() {
        return callerName;
    }

    String getCallerPhoneNumber() {
        return callerPhoneNumber;
    }
}
