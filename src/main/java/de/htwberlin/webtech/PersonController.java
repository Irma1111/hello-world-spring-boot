package de.htwberlin.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired // Injizieren Sie den PersonService
    private PersonService personService;

    @Autowired // Injizieren Sie den TaskService
    private TaskService taskService;

    // Methode zum Abrufen aller Personen
    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    // Methode zum Abrufen der Tasks für jeden einzelnen Nutzer
    @GetMapping("/{personId}/tasks")
    public List<Task> getTasksOfPerson(@PathVariable Long personId) {
        return personService.getTasksOfPerson(personId);
    }

    // Methode zum Erstellen einer neuen Person
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    // Methode zum Aktualisieren einer Person
    @PutMapping("/{personId}")
    public Person updatePerson(@PathVariable Long personId, @RequestBody Person personDetails) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person nicht gefunden"));
        person.setName(personDetails.getName());
        person.setEmail(personDetails.getEmail());
        // Weitere Felder können hier aktualisiert werden
        return personRepository.save(person);
    }

    // Methode zum Löschen einer Person
    @DeleteMapping("/{personId}")
    public void deletePerson(@PathVariable Long personId) {
        personRepository.deleteById(personId);
    }

    // Methode zum Hinzufügen eines Tasks zu einer Person
    @PostMapping("/{personId}/tasks")
    public Task addTaskToPerson(@PathVariable Long personId, @RequestBody Task task) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person nicht gefunden"));
        task.setPerson(person); // Setzen Sie die Beziehung zur Person
        person.getTasks().add(task); // Fügen Sie den Task zur Liste der Person hinzu
        personRepository.save(person); // Speichern Sie die aktualisierte Person
        return taskRepository.save(task);
    }

    // Methode zum Aktualisieren eines Tasks
    @PutMapping("/tasks/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task taskDetails) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task nicht gefunden"));
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());
        return taskRepository.save(task);
    }

    // Methode zum Löschen eines Tasks
    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
