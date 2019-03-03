package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    TaskRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Task task = new Task("grocery", "chicken, eggs, bread", "/img/high-priority.jpg", true);
        repository.save(task);

        task = new Task("laundry", "white and color clothes", "/img/medium-priority.jpg", false);
        repository.save(task);

        task = new Task("shopping", "glasses, napkins and spices", "/img/low-priority.jpg", true);
        repository.save(task);
    }
}
