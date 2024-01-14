package de.htwberlin.webtech;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    public TaskControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateTodoWithPerson() throws Exception {
        Task task = new Task();
        task.setDescription("Buy groceries");
        Long personId = 1L;

        when(taskService.createAndAssignTask(personId, task.getDescription())).thenReturn(task);

        ObjectMapper objectMapper = new ObjectMapper();
        String taskJson = objectMapper.writeValueAsString(task);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/tasks?personId=" + personId)
                        .contentType("application/json")
                        .content(taskJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Buy groceries"));
    }


    @Test
    public void testGetAllTodos() throws Exception {
        Task task1 = new Task();
        task1.setDescription("Task 1");
        task1.setCompleted(false);

        Task task2 = new Task();
        task2.setDescription("Task 2");
        task2.setCompleted(true);

        when(taskService.findAll()).thenReturn(List.of(task1, task2));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Task 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].completed").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].description").value("Task 2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].completed").value(true));
    }

    // Weitere Testfälle für die anderen Endpunkte (updateTodo, deleteTodo, getTodosByUserId) hier hinzufügen...
}
