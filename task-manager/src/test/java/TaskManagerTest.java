package test.java;

import main.java.org.com.TaskManager;
import main.java.org.com.model.Priority;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class TaskManagerTest {
    private TaskManager taskManager;

    @Before
    public void setUp() {

        taskManager = new TaskManager();
        taskManager.createTask("Test Task 1", "Task Description 1", LocalDate.parse("2023-08-31"), Priority.ALTA);
        taskManager.createTask("Test Task 3", "Task Description 3", LocalDate.parse("2023-09-15"), Priority.BAIXA);
        taskManager.createTask("Test Task 2", "Task Description 2", LocalDate.parse("2023-08-29"), Priority.MEDIA);


    }


    @Test
    public void testListTaks() throws Exception {
        Assert.assertEquals(3, taskManager.listTasks().size());
    }

    @Test
    public void testgetTask() throws Exception {
        Assert.assertEquals("Task Description 1", taskManager.getTask(0).getDescription());
        Assert.assertEquals(Priority.BAIXA, taskManager.getTask(1).getPriority());
    }
    @Test
    public void testSortByPriority() throws Exception {
        taskManager.sortByPriority();

        Assert.assertEquals("Test Task 1", taskManager.listTasks().get(0).getTitle());
        Assert.assertEquals("Test Task 2", taskManager.listTasks().get(1).getTitle());
        Assert.assertEquals("Test Task 3", taskManager.listTasks().get(2).getTitle());
    }


    @Test
    public void testSortByDeadline() throws Exception {
        taskManager.sortByDeadline();

        Assert.assertEquals("Test Task 1", taskManager.listTasks().get(1).getTitle());
        Assert.assertEquals("Test Task 2", taskManager.listTasks().get(0).getTitle());
        Assert.assertEquals("Test Task 3", taskManager.listTasks().get(2).getTitle());
    }
    @Test
    public void testUpdateTask() throws Exception {
        taskManager.updateTask(0, "Test Task 1 Updated", "Test Description 1 Updated",  LocalDate.parse("2023-08-28"), Priority.ALTA);

        Assert.assertEquals("Test Task 1 Updated", taskManager.getTask(0).getTitle());
        Assert.assertEquals("Test Description 1 Updated", taskManager.getTask(0).getDescription());
        Assert.assertEquals(LocalDate.parse("2023-08-28"), taskManager.getTask(0).getDueDate());

    }


    @Test
    public void testDeleteTask() throws Exception {
        taskManager.deleteTask(0);
        Assert.assertEquals(2, taskManager.listTasks().size());
    }
}
