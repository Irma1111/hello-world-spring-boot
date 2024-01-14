package de.htwberlin.webtech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testSaveAndFindPerson() {
        Person person = new Person();
        person.setName("Max Mustermann");
        person = personRepository.save(person);

        Person found = personRepository.findById(person.getId()).orElse(null);
        assertNotNull(found);
        assertEquals("Max Mustermann", found.getName());
    }
}
