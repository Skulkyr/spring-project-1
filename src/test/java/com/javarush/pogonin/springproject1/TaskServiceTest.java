package com.javarush.pogonin.springproject1;

import com.javarush.pogonin.springproject1.entity.Status;
import com.javarush.pogonin.springproject1.entity.Task;
import com.javarush.pogonin.springproject1.services.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TaskServiceTest {

    static AnnotationConfigApplicationContext context;

    @BeforeAll
    public static void loadContext() {
        context = new AnnotationConfigApplicationContext(TestSpringConfiguration.class);
    }

    @Test
    public void getTaskWhereIdIsIncorrect() {

    }
    @Test
    public void getTask() {
        Task task = context.getBean("taskService", TaskService.class).getTaskById(1);
        Assertions.assertEquals(task.getStatus(), Status.DONE);
        Assertions.assertEquals(task.getDescription(), "aaa");
    }
}
