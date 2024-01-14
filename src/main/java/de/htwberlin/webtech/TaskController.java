package de.htwberlin.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

        @Autowired
        private TaskService service;

        // GET-Anfrage, um alle To-Dos abzurufen
        @GetMapping
        public List<Task> getAllTodos() {
            return service.findAll();
        }

        /*
        // POST-Anfrage, um ein neues To-Do zu erstellen
        @PostMapping
        public Task createTodo(@RequestBody Task todo, @RequestParam(required = false) Long personId) {
                return service.createTask(todo, personId);
        }
        */
        // POST-Anfrage, um ein neues To-Do zu erstellen und einer Person zuzuordnen
        @PostMapping
        public Task createTodo(@RequestBody Task todo, @RequestParam(required = false) Long personId) {
                if (personId != null) {
                        return service.createAndAssignTask(personId, todo.getDescription());
                } else {
                        return service.save(todo);
                }
        }

        // PUT-Anfrage, um ein To-Do zu aktualisieren
        @PutMapping("/{id}")
        public Task updateTodo(@PathVariable Long id, @RequestBody Task todoDetails) {
            return service.update(id,
                    todoDetails);
        }

        // DELETE-Anfrage, um ein To-Do zu löschen
        @DeleteMapping("/{id}")
        public void deleteTodo(@PathVariable Long id) {
            service.delete(id);
        }

        // GET-Anfrage, um alle To-Dos eines bestimmten Nutzers abzurufen
        @GetMapping("/user/{userId}")
        public List<Task> getTodosByUserId(@PathVariable Long userId) {
        return service.findByPersonId(userId);}

        // Weitere Endpunkte nach Bedarf
    }

