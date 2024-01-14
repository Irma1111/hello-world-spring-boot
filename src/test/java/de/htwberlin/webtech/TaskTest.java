package de.htwberlin.webtech;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest {

    @Test
    public void testTaskDescription() {
        // Erstellen Sie eine Task-Instanz
        Task task = new Task();

        // Setzen Sie die Beschreibung
        task.setDescription("Buy groceries");

        // Überprüfen Sie, ob die Beschreibung korrekt abgerufen werden kann
        assertEquals("Buy groceries", task.getDescription());
    }

    @Test
    public void testTaskIsCompleted() {
        // Erstellen Sie eine Task-Instanz
        Task task = new Task();

        // Setzen Sie den Status auf abgeschlossen (isCompleted = true)
        task.setCompleted(true);

        // Überprüfen Sie, ob isCompleted korrekt abgerufen werden kann
        assertTrue(task.isCompleted());
    }

    @Test
    public void testTaskPerson() {
        // Erstellen Sie eine Task-Instanz
        Task task = new Task();

        // Erstellen Sie eine Person-Instanz
        Person person = new Person();
        person.setName("John");

        // Setzen Sie die Person in der Aufgabe
        task.setPerson(person);

        // Überprüfen Sie, ob die Person korrekt abgerufen werden kann
        assertEquals("John", task.getPerson().getName());
    }
}
