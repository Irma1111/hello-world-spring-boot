package de.htwberlin.webtech;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import org.springframework.scheduling.config.Task;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "person") // Angenommen, die Task-Klasse hat ein Feld 'person'
    private List<Task> tasks; // Liste von To-Do-Listeneinträgen

    // Getter und Setter für id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter und Setter für name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter und Setter für email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter und Setter für tasks
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    // Weitere Methoden nach Bedarf
}


