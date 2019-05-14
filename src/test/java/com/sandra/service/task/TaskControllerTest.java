package com.sandra.service.task;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TaskControllerTest {
    private static  final Integer id= 1234566;
    private static  final Integer userId=1234556778;
    private static  final String title= "title";
    private static  final String description= "description";
    private static  final String dueDate= "dueDate";
    private static  final String reminder= "reminder";
    private static  final Boolean done= true;
    private static  final String completionDate= "completionDate";

    @Test
    public void MappingNotNullTask(){
        Task Gtask = new Task();
        Gtask.setId(id);
        Gtask.setUserId(userId);
        TaskDTO taskDTO= new TaskDTO();
        taskDTO.setTitle(title);
        taskDTO.setDescription(description);
        taskDTO.setDueDate(dueDate);
        taskDTO.setReminder(reminder);
        taskDTO.setDone(done);
        taskDTO.setCompletionDate(completionDate);
        Task newTask= TaskController.mappingTask(Gtask, taskDTO);
        assertEquals(newTask.getId(), id);
        assertEquals(newTask.getUserId(), userId);
        assertEquals(newTask.getTitle(), title);
        assertEquals(newTask.getDescription(), description);
        assertEquals(newTask.getDueDate(), dueDate);
        assertEquals(newTask.getReminder(), reminder);
        assertEquals(newTask.getDone(), done);
        assertEquals(newTask.getCompletionDate(), completionDate);

    }
    @Test
    public void MappingNullTask(){

        TaskDTO taskDTO= new TaskDTO();
        taskDTO.setTitle(title);
        taskDTO.setDescription(description);
        taskDTO.setDueDate(dueDate);
        taskDTO.setReminder(reminder);
        taskDTO.setDone(done);
        taskDTO.setCompletionDate(completionDate);
        Task newTask= TaskController.mappingTask(null, taskDTO);
        assertEquals(newTask.getId(), null);
        assertEquals(newTask.getUserId(), null);
        assertEquals(newTask.getTitle(), title);
        assertEquals(newTask.getDescription(), description);
        assertEquals(newTask.getDueDate(), dueDate);
        assertEquals(newTask.getReminder(), reminder);
        assertEquals(newTask.getDone(), done);
        assertEquals(newTask.getCompletionDate(), completionDate);

    }

}