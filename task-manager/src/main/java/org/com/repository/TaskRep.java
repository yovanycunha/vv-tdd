package main.java.org.com.repository;

import main.java.org.com.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TaskRep{

    private ArrayList<Task> tasks;

    public TaskRep(){
        tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTaskList() {
        return tasks;
    }

    public void sortByDeadline(){
        Comparator<Task> byDueDate = Comparator.comparing(Task::getDueDate);
        Collections.sort(this.tasks, byDueDate);
    }

    public void sortByPriority(){
        Comparator<Task> byPriority = Comparator.comparing(Task::getPriority);
        Collections.sort(this.tasks, byPriority);
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public Task getTaskById(Integer id){
        return this.tasks.get(id);
    }

    public void removeTaskById(Integer id){
        this.tasks.remove(getTaskById(id));
    }




}