package com.javarush.pogonin.springproject1.controllers;


import com.javarush.pogonin.springproject1.entity.Task;
import com.javarush.pogonin.springproject1.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    private final TaskService service;
    public TaskController(TaskService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String getTasks(Model model, Task task) {
        model.addAttribute("taskList", service.getTaskList());
        model.addAttribute(task);
        return "index";
    }

    @PostMapping("/save")
    public String saveTask(Task task) {
        service.saveTask(task);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteTask(@RequestParam("id") Integer id, Model model) {
        service.deleteTaskById(id);
        return "redirect:/";
    }

    public TaskService getService() {
        return service;
    }
}
