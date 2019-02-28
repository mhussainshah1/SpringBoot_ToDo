package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Size(min = 4)
    private String name;

    @NonNull
    @Size(min = 10)
    private String description;

    @NonNull
    @Min(1)
    private int priority;

    @Autowired
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dueDate;

    @NotNull
    @Value("false")
    private boolean completed;

    public Task() {
    }

    public Task(@Size(min = 4) String name, @Size(min = 10) String description, @Min(1) int priority, @NotNull boolean completed) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.dueDate = LocalDate.now();
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
