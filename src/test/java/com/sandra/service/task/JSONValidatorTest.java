package com.sandra.service.task;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JSONValidatorTest {
    private static  final String title= "title";
    private static  final String description= "description";
    private static  final String dateInvalid= "11-11-2019";
    private static  final String dateValid= "11/11/2019";
    private static  final String reminderValid= "11/11/2019 11:20";
    private static  final String reminderInvalid= "11/11/2019 11-20";
    private static  final Boolean doneTrue= true;
    private static  final Boolean doneFalse= false;
    private static final Task task1= new Task(title,description,dateValid,reminderValid,doneTrue, dateValid );



    @Test
    public void testValidatorNull() {
        Task task = null;
        Assert.assertEquals(JSONValidator.validator(task), false);
    }
    @Test
    public void testValidatorTrue() {

        Assert.assertEquals(JSONValidator.validator(task1), true);
    }

    @Test
    public void testValidatorNoDescription() {
        task1.setDescription(null);
        Assert.assertEquals(JSONValidator.validator(task1), false);
        task1.setDescription(description);
    }

    @Test
    public void testNoTitle() {
        task1.setTitle(null);
        Assert.assertEquals(JSONValidator.validator(task1), false);
        task1.setTitle(title);
    }
    @Test
    public void testNoValidDueDate() {
        task1.setDueDate(dateInvalid);
        Assert.assertEquals(JSONValidator.validator(task1), false);
        task1.setDueDate(dateValid);
    }

    @Test
    public void testNoValidCompletionDate() {
        task1.setCompletionDate(dateInvalid);
        Assert.assertEquals(JSONValidator.validator(task1), false);
        task1.setCompletionDate(dateValid);
    }
    @Test
    public void testNoValidReminder() {
        task1.setReminder(reminderInvalid);
        Assert.assertEquals(JSONValidator.validator(task1), false);
        task1.setReminder(reminderValid);
    }

    @Test
    public void testDoneNull() {
        task1.setDone(null);
        Assert.assertEquals(JSONValidator.validator(task1), false);
        task1.setDone(doneTrue);
    }

    @Test
    public void testDoneWithoutCompletionDate() {
        task1.setDone(doneTrue);
        task1.setCompletionDate(null);
        Assert.assertEquals(JSONValidator.validator(task1), false);
        task1.setCompletionDate(dateValid);
    }

    @Test
    public void testUndoneWithCompletionDate() {
        task1.setDone(doneFalse);
        task1.setCompletionDate(dateValid);
        Assert.assertEquals(JSONValidator.validator(task1), false);
        task1.setDone(doneTrue);
    }

    @Test
    public void testIsReminderValid() {
    }

    @Test
    public void testIsDateValid() {
    }
}