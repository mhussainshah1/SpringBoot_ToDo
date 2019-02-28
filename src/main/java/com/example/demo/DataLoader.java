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
        Task task = new Task("grocery", "chicken, eggs, bread", 1, true);
        repository.save(task);

        task = new Task("laundry", "white and color clothes", 1, true);
        repository.save(task);

        task = new Task("shopping", "glasses, napkins and spices", 1, true);
        repository.save(task);
    }
}
