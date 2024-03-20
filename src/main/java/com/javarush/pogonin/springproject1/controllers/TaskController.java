package com.javarush.pogonin.springproject1.controllers;


import com.javarush.pogonin.springproject1.entity.Task;
import com.javarush.pogonin.springproject1.services.TaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class TaskController {

    private final TaskService service;
    public TaskController(TaskService service) {
        this.service = service;
    }
    @GetMapping("/{page}/")
    public String getTasks(@PathVariable Integer page, Model model, Task task, Integer countTasks) {
        countTasks = 10;
        int countPages = getCountPages(countTasks);
        model.addAttribute("taskList", service.getTaskByPage(page, countTasks));
        model.addAttribute(task);
        model.addAttribute("countPages", countPages);
        return "index";
    }

    @GetMapping("/")
    public String getMainPage() {
        return "redirect:/1/";
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

    public Integer getCountPages(Integer countTasks) {
        return service.getCountPages(countTasks);
    }

    public static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true);
    }
}
