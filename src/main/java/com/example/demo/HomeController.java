package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping("/")
    public String listItems(Model model) {
        model.addAttribute("tasks", taskRepository.findAll()); //select * from todolist
        return "todolist";
    }

    @GetMapping("/add")
    public String courseForm(Model model) {
        model.addAttribute("task", new Task());
        return "taskform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "taskform";
        }
        taskRepository.save(task);//generate SQL statement and insert into database
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("task", taskRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("task", taskRepository.findById(id).get());
        return "taskform";
    }

    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id){
        taskRepository.deleteById(id);
        return "redirect:/";
    }
}
