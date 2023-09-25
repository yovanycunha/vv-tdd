package test.java;

import main.java.org.com.TaskManager;
import main.java.org.com.model.Priority;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    public  void setUp() {
        taskManager = new TaskManager();
        taskManager.createTask("Test Task 1", "Task Description 1", LocalDate.parse("2023-08-31"), Priority.ALTA);
        taskManager.createTask("Test Task 3", "Task Description 3", LocalDate.parse("2023-09-15"), Priority.BAIXA);
        taskManager.createTask("Test Task 2", "Task Description 2", LocalDate.parse("2023-08-29"), Priority.MEDIA);
    }

    @Test
    @DisplayName("Test List Tasks")
    @Order(2)
    public void testListTaks() throws Exception {

        assertEquals(3, taskManager.listTasks().size());
    }

    @Test
    @DisplayName("Test Get Task")
    @Order(1)
    public void testgetTask() throws Exception {
        assertEquals("Task Description 1", taskManager.getTask(0).getDescription());
        assertEquals(Priority.BAIXA, taskManager.getTask(1).getPriority());
    }
    @Test
    @DisplayName("Test Create Task")
    @Order(0)
    public void testSortByPriority() throws Exception {
        System.out.println(taskManager.listTasks());
        taskManager.sortByPriority();

        assertAll("Title",
                () -> assertEquals("Test Task 1", taskManager.listTasks().get(0).getTitle()),
                () -> assertEquals("Test Task 2", taskManager.listTasks().get(1).getTitle()),
                () -> assertEquals("Test Task 3", taskManager.listTasks().get(2).getTitle())
        );
    }


    @Test
    @Order(3)
    @DisplayName("Test Sort By Deadline")
    public void testSortByDeadline() throws Exception {
        taskManager.sortByDeadline();

        assertEquals("Test Task 1", taskManager.listTasks().get(1).getTitle());
        assertEquals("Test Task 2", taskManager.listTasks().get(0).getTitle());
        assertEquals("Test Task 3", taskManager.listTasks().get(2).getTitle());
    }
   
    @DisplayName("Test Update Task")
    @Order(4)
    @RepeatedTest(3)
    public void testUpdateTask() throws Exception {
        taskManager.updateTask(0, "Test Task 1 Updated", "Test Description 1 Updated",  LocalDate.parse("2023-08-28"), Priority.ALTA);

        assertEquals("Test Task 1 Updated", taskManager.getTask(0).getTitle());
        assertEquals("Test Description 1 Updated", taskManager.getTask(0).getDescription());
        assertEquals(LocalDate.parse("2023-08-28"), taskManager.getTask(0).getDueDate());

    }


    @Test
    @DisplayName("Test Delete Task")
    @Order(5)
    public void testDeleteTask() throws Exception {
        taskManager.deleteTask(0);
        assertEquals(2, taskManager.listTasks().size());
    }
}
