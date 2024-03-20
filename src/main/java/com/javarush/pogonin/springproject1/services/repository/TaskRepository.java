package com.javarush.pogonin.springproject1.services.repository;

import com.javarush.pogonin.springproject1.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(value = "select * from Task limit ?2 offset ?1", nativeQuery = true)
    List<Task> findByPage(Integer offset, Integer limit);
}
