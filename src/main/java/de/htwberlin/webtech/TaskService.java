package de.htwberlin.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public Task update(Long id, Task todoDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task mit ID " + id + " nicht gefunden"));
        task.setDescription(todoDetails.getDescription());
        task.setCompleted(todoDetails.isCompleted());
        return taskRepository.save(task);
    }

    public List<Task> findByPersonId(Long personId) {
        // Implementierung, um Tasks für die gegebene Person-ID zu finden
        return taskRepository.findByPersonId(personId);
    }

    public Task createAndAssignTask(Long personId, String taskDescription) {
        Task newTask = new Task();
        newTask.setDescription(taskDescription);
        // Weitere Eigenschaften setzen...

        Optional<Person> personOptional = personRepository.findById(personId);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            person.addTask(newTask);
            taskRepository.save(newTask); // Speichert den Task
            personRepository.save(person); // Speichert die Person mit der aktualisierten Task-Liste
            return newTask;
        } else {
            throw new RuntimeException("Person mit ID " + personId + " nicht gefunden");
        }
    }

    // Weitere spezifische Geschäftslogikmethoden
}
