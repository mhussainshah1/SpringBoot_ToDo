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
        Task task = new Task("grocery", "chicken, eggs, bread", "https://res.cloudinary.com/mhussainshah1/image/upload/c_fill,g_face,h_30,r_50,w_30/v1551473204/java-bootcamp/high-priority.jpg", true);
        repository.save(task);

        task = new Task("laundry", "white and color clothes", "https://res.cloudinary.com/mhussainshah1/image/upload/c_fill,g_face,h_30,r_50,w_30/v1551473204/java-bootcamp/medium-priority.png", false);
        repository.save(task);

        task = new Task("shopping", "glasses, napkins and spices", "https://res.cloudinary.com/mhussainshah1/image/upload/c_fill,g_face,h_30,r_50,w_30/v1551473204/java-bootcamp/low-priority.jpg", true);
        repository.save(task);
    }
}
