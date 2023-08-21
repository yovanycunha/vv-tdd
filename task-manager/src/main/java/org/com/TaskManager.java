package main.java.org.com;

import main.java.org.com.model.Priority;
import main.java.org.com.model.Task;
import main.java.org.com.repository.TaskRep;

import java.time.LocalDate;
import java.util.ArrayList;


public class TaskManager {
   private TaskRep taskRep;

   public TaskManager(){
      taskRep = new TaskRep();
   }
   public void createTask(String title, String description, LocalDate dueDate, Priority priority) {
      Task task = new Task(title,description,dueDate,priority);
      taskRep.addTask(task);
   }

   public ArrayList<Task> listTasks() {
      return taskRep.getTaskList();
   }

   public Task getTask(Integer id) {
      return this.taskRep.getTaskById(id);
   }

   public void sortByPriority() {
      this.taskRep.sortByPriority();
   }



   public void updateTask(Integer id, String title, String description, LocalDate dueDate, Priority priority) {
      Task task = taskRep.getTaskById(id);
      task.setTitle(title);
      task.setDescription(description);
      task.setDueDate(dueDate);
      task.setPriority(priority);

   }

   public void sortByDeadline() {
      this.taskRep.sortByDeadline();
   }

   public void deleteTask(Integer id) {
      this.taskRep.removeTaskById(id);
   }


}