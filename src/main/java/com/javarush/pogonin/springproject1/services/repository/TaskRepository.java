package com.javarush.pogonin.springproject1.services.repository;

import com.javarush.pogonin.springproject1.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TaskRepository extends JpaRepository<Task, Integer> {
}
