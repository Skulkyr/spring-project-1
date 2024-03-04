package com.javarush.pogonin.springproject1.services;

import com.javarush.pogonin.springproject1.entity.Task;
import com.javarush.pogonin.springproject1.services.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTaskById(Integer id) {
        return taskRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User this id = " + id + " is not found"));
    }

    public List<Task> getTaskList() {
        List<Task> list = taskRepository.findAll();
        list.forEach(System.out::println);
        return list;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }
}
