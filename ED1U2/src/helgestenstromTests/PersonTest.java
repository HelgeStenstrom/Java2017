/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstromTests;

import helgestenstrom.Person;
//import helgestenstrom.Person.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void getCity() throws Exception {
        Person x = new Person();
        Person p = Person.getOwner();
        assertEquals("Nomen Nescio", p.getFullName());
    }

    @Test
    public void setCity() throws Exception {
    }

}