package de.htwberlin.webtech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testSaveAndRetrieveTask() {
        // Erstellen und speichern Sie ein Task-Objekt in der Datenbank
        Task task = new Task();
        task.setDescription("Buy groceries");
        task.setCompleted(false);

        Task savedTask = taskRepository.save(task);

        // Überprüfen Sie, ob das Task-Objekt korrekt gespeichert wurde und eine ID hat
        assertNotNull(savedTask.getId());

        // Rufen Sie das Task-Objekt aus der Datenbank ab
        Task retrievedTask = taskRepository.findById(savedTask.getId()).orElse(null);

        // Überprüfen Sie, ob das abgerufene Task-Objekt den erwarteten Werten entspricht
        assertNotNull(retrievedTask);
        assertEquals("Buy groceries", retrievedTask.getDescription());
        assertEquals(false, retrievedTask.isCompleted());
    }
}
