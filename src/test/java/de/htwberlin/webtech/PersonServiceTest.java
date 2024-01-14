package de.htwberlin.webtech;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    public void testSavePerson() {
        Person person = new Person();
        person.setName("Max Mustermann");
        personService.save(person);
        verify(personRepository, times(1)).save(person);
    }
}
