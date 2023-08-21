package main.java.org.com.model;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);

    private Integer id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Priority priority;

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Task(String title, String description, LocalDate dueDate, Priority priority1) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority1;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


}