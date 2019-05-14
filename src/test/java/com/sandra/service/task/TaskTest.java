package com.sandra.service.task;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TaskTest {
    private static  final Integer id= 1234566;
    private static  final Integer userId=1234556778;
    private static  final String title= "title";
    private static  final String description= "description";
    private static  final String dueDate= "dueDate";
    private static  final String reminder= "reminder";
    private static  final Boolean done= true;
    private static  final String completionDate= "completionDate";
    private static final Task task= new Task();

    @Test
    public void taskConstructorTest(){
        Task task1= new Task(title, description, dueDate, reminder, done, completionDate);
        assertEquals(task1.getTitle(), title);
        assertEquals(task1.getDescription(), description);
        assertEquals(task1.getDueDate(), dueDate);
        assertEquals(task1.getReminder(), reminder);
        assertEquals(task1.getDone(), done);
        assertEquals(task1.getCompletionDate(), completionDate);

    }


    @Test
    public void idTest(){
        task.setId(id);
        assertEquals(task.getId(), id);
    }

    @Test
    public void userIdTest(){
        task.setUserId(userId);
        assertEquals(task.getUserId(), userId);
    }


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