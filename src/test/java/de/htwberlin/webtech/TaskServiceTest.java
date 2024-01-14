package de.htwberlin.webtech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private PersonRepository personRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveTask() {
        // Mocked Task and Person
        Task task = new Task();
        Person person = new Person();
        person.setId(1L);
        task.setPerson(person);

        // Mock behavior of repositories
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));
        when(taskRepository.save(task)).thenReturn(task);

        // Test saveTask
        Task savedTask = taskService.createTask(task, 1L);
        assertEquals(person, savedTask.getPerson());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    public void testDeleteTask() {
        // Mocked Task
        Task task = new Task();
        task.setId(1L);

        // Mock behavior of repositories
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        // Test deleteTask
        taskService.delete(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testFindAllTasks() {
        // Mocked Task list
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task());
        taskList.add(new Task());

        // Mock behavior of repositories
        when(taskRepository.findAll()).thenReturn(taskList);

        // Test findAllTasks
        List<Task> retrievedTasks = taskService.findAll();
        assertEquals(2, retrievedTasks.size());
    }

    @Test
    public void testUpdateTask() {
        // Mocked Task
        Task task = new Task();
        task.setId(1L);

        // Mock behavior of repositories
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(taskRepository.save(task)).thenReturn(task);

        // Test updateTask
        Task updatedTask = taskService.update(1L, task);
        assertEquals(task.getId(), updatedTask.getId());
    }

    @Test
    public void testFindByPersonId() {
        // Mocked Task list
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task());
        taskList.add(new Task());

        // Mock behavior of repositories
        when(taskRepository.findByPersonId(1L)).thenReturn(taskList);

        // Test findByPersonId
        List<Task> retrievedTasks = taskService.findByPersonId(1L);
        assertEquals(2, retrievedTasks.size());
    }

    @Test
    public void testCreateTaskWithoutPerson() {
        // Mocked Task
        Task task = new Task();

        // Mock behavior of repositories
        when(taskRepository.save(task)).thenReturn(task);

        // Test createTask without specifying a person
        Task createdTask = taskService.createTask(task, null);
        assertEquals(null, createdTask.getPerson());
    }

    @Test
    public void testCreateTaskWithNonExistentPerson() {
        // Mocked Task
        Task task = new Task();

        // Mock behavior of repositories
        when(personRepository.findById(1L)).thenReturn(Optional.empty());

        // Test createTask with a non-existent person ID
        assertThrows(RuntimeException.class, () -> taskService.createTask(task, 1L));
    }
}

