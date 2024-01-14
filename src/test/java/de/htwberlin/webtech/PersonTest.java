package de.htwberlin.webtech;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testPersonGettersAndSetters() {
        Person person = new Person();
        person.setName("Max Mustermann");
        person.setEmail("max@example.com");

        assertEquals("Max Mustermann", person.getName());
        assertEquals("max@example.com", person.getEmail());
    }
}
