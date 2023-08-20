import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskManagerTest {
    private TaskManager taskManager;

    @Before
    public void setUp() {

        taskManager = new TaskManager();
        taskManager.createTask('Test Task 1', 'Test Description 1', '2023-08-31', 'high');
        taskManager.createTask('Test Task 2', 'Test Description 2', '2023-08-29', 'low');
        taskManager.createTask('Test Task 3', 'Test Description 3', '2023-09-15', 'normal');

    }


    @Test
    public void testListTaks() throws Exception {
        Assert.assertEquals(3, taskManager.listTasks().size());
    }

    @Test
    public void testgetTask() throws Exception {
        Assert.assertEquals('Task Description 1', taskManager.getTask('Test Task 1').getDescription());
        Assert.assertEquals('low', taskManager.getTask('Test Task 3').getPriority());
    }

    @Test
    public void testUpdateTask() throws Exception {
        taskManager.updateTask('Test Task 1', 'Test Task 1 Updated', 'Test Description 1 Updated', '2023-08-28', 'high');

        Assert.assertEquals('Test Task 1 Updated', taskManager.getTask('Test Task 1 Updated').getName());
        Assert.assertEquals('Test Description 1 Updated', taskManager.getTask('Test Task 1 Updated').getDescription());
        Assert.assertEquals('2023-08-28', taskManager.getTask('Test Task 1 Updated').getDueDate());

    }

   @Test
    public void testSortByPriority() throws Exception {
        taskManager.sortByPriority();

        Assert.assertEquals('Test Task 1 Updated', taskManager.listTasks().get(0).getName());
        Assert.assertEquals('Test Task 2', taskManager.listTasks().get(2).getName());
        Assert.assertEquals('Test Task 3', taskManager.listTasks().get(1).getName());
    }


    @Test
    public void testSortByDeadline() throws Exception {
        taskManager.sortByDeadline();

        Assert.assertEquals('Test Task 1 Updated', taskManager.listTasks().get(1).getName());
        Assert.assertEquals('Test Task 2', taskManager.listTasks().get(0).getName());
        Assert.assertEquals('Test Task 3', taskManager.listTasks().get(2).getName());
    }

    @Test
    public void testDeleteTask() throws Exception {
        taskManager.deleteTask('Test Task 1 Updated');
        Assert.assertEquals(2, taskManager.listTasks().size());
    }
}
