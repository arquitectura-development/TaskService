package com.sandra.service.task;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TaskDTOTest {
    private static  final String title= "title";
    private static  final String description= "description";
    private static  final String dueDate= "dueDate";
    private static  final String reminder= "reminder";
    private static  final Boolean done= true;
    private static  final String completionDate= "completionDate";
    private static final TaskDTO task= new TaskDTO();

    @Test
    public void titleTest(){
        task.setTitle(title);
        assertEquals(task.getTitle(), title);
    }

    @Test
    public void descriptionTest(){
        task.setDescription(description);
        assertEquals(task.getDescription(), description);
    }

    @Test
    public void dueDateTest(){
        task.setDueDate(dueDate);
        assertEquals(task.getDueDate(), dueDate);
    }

    @Test
    public void reminderTest(){
        task.setReminder(reminder);
        assertEquals(task.getReminder(), reminder);
    }

    @Test
    public void doneTest(){
        task.setDone(done);
        assertEquals(task.getDone(), done);
    }

    @Test
    public void completionDateTest(){
        task.setCompletionDate(completionDate);
        assertEquals(task.getCompletionDate(), completionDate);
    }


}